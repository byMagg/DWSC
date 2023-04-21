package dwsc.trackinsert.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Service;
import dwsc.trackinsert.model.Track;

@Service
public class TrackServiceImpl implements TrackService {

	public int postUserToDb(Track user) {
		// Connect to database
		Connection conn = this.connect2DB();
		// Query the user
		int numInserted = 0;
		try {
			Statement st = conn.createStatement();
			// ResultSet rsCheckRepeated = st.executeQuery("SELECT COUNT(1) FROM sampleusers
			// " + "WHERE username = '"
			// + user.getUsername() + "' " + "OR dni = '" + user.getDni() + "'");
			numInserted = st
					.executeUpdate("INSERT INTO sampleusers (name)"
							+ " VALUES ('" + user.getName() + "'");
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
			String url = "jdbc:postgresql://localhost:5432/Tracks";
			conn = DriverManager.getConnection(url, "postgres", "example");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}