package busReservationProject;

import java.sql.*;

public class DBconnection {
	private static final String url = "jdbc:mysql://localhost:3306/busreservation";
	private static final String username = "root";
	private static final String password = "Vickys@38";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
}
