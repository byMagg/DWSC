package activity3.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import activity3.model.User;
import activity3.model.Users;

@Path("/users")
public class UserService {
	@GET
	@Produces({ "application/json", "application/xml" })
	public Response getUsers() {
		Users users = this.getUsersFromDB();
		return Response.status(200).entity(users).build();
	}

	@Path("xml")
	@GET
	@Produces("application/xml")
	public Response getUsersXML() {
		Users users = this.getUsersFromDB();
		return Response.status(200).entity(users).build();
	}

	@Path("json")
	@GET
	@Produces("application/json")
	public Response getUsersJSON() {
		Users users = this.getUsersFromDB();
		return Response.status(200).entity(users).build();
	}

	@Path("{username}")
	@GET
	@Produces("application/json")
	public Response getExampleUser(@PathParam("username") String username) {
		User user = this.getUserFromDB(username);
		if (user != null) {
			return Response.status(200).entity(user).build();
		} else {
			return Response.status(400).build();
		}
	}

	@POST
	@Consumes("application/json")
	@Produces("application/text")
	public Response postUser(User user) {
		if (user != null) {
			if(this.postUserToDB(user) == null) return Response.status(409).entity("ERROR: Username o DNI repetidos").build();
			return Response.status(201).entity(user.getUsername()).build();
		} else {
			return Response.status(400).build();
		}
	}

	private Connection connect2DB() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://34.155.124.130:5432/itsi";
			conn = DriverManager.getConnection(url, "estudiante", "estudiante");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	private Users getUsersFromDB() {
		Users users = new Users();
		// Connect to database
		Connection conn = this.connect2DB();
		// Query the users and add them to the list
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM sampleusers ORDER BY age");
			
			while (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setDni(rs.getString("dni"));
				user.setName(rs.getString("name"));
				user.setSurnames(rs.getString("surnames"));
				user.setAge(rs.getInt("age"));
				users.add(user);
			}
			users.sort(Comparator.comparing(User::getUsername));
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("[UserService - getUsersFromDB] SQLException while querying the users");
			System.err.println(e.getMessage());
		}
		return users;
	}

	private User getUserFromDB(String username) {
		User user = null;
		// Connect to database
		Connection conn = this.connect2DB();
		// Query the user
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM sampleusers WHERE username = '" + username + "'");
			if (rs.next()) {
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setDni(rs.getString("dni"));
				user.setName(rs.getString("name"));
				user.setSurnames(rs.getString("surnames"));
				user.setAge(rs.getInt("age"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("[UserService - getUserFromDB] SQLException while querying a user");
			System.err.println(e.getMessage());
		}
		return user;
	}

	private User postUserToDB(User user) {
		// Connect to database
		Connection conn = this.connect2DB();
		// Query the user
		int numInserted = 0;
		try {
			Statement st = conn.createStatement();
			ResultSet rsCheckRepeated = st.executeQuery("SELECT COUNT(1) FROM sampleusers " + "WHERE username = '"
					+ user.getUsername() + "' " + "OR dni = '" + user.getDni() + "'");
			if (rsCheckRepeated.next()) {
				if((rsCheckRepeated.getInt(1)==0)) {					
					numInserted = st.executeUpdate("INSERT INTO sampleusers (username, password, dni, name, surnames, age)"
							+ " VALUES ('" + user.getUsername() + "'" + ", '" + user.getPassword() + "'" + ", '"
							+ user.getDni() + "'" + ", '" + user.getName() + "'" + ", '" + user.getSurnames() + "'" + ", '"
							+ user.getAge() + "')");
				}
			}

			rsCheckRepeated.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("[UserService - postUserToDB] SQLException while adding a user");
			System.err.println(e.getMessage());
		}
		if(numInserted == 0) return null;
		return user;
	}
}