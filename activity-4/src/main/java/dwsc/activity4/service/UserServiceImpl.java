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