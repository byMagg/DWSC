package dwsc.activity4.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Service;
import dwsc.activity4.model.User;
import dwsc.activity4.model.Users;

@Service
public class UserServiceImpl implements UserService {
	public Users getUsersFromDB() {
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

			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("[UserService - getUsersFromDB] SQLException while querying the users");
			System.err.println(e.getMessage());
		}
		return users;
	}

	public User getUserFromDb(String username) {
		User user = new User();
		// Connect to database
		Connection conn = this.connect2DB();
		// Query the users and add them to the list
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM sampleusers WHERE username='" + username + "'");
			if (rs.next()) {
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
			System.err.println("[UserService - getUsersFromDB] SQLException while querying the users");
			System.err.println(e.getMessage());
		}
		return user;
	}
	
	public int postUserToDb(User user) {
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
		return numInserted;
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

}