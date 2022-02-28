package utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionManager {
	private String jdbcURL = "jdbc:mysql://localhost/dbname";
	private String jdbcUsername = "root";
	private String jdbcPassword = "examly";

	

	public ConnectionManager() {
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(this.jdbcURL, this.jdbcUsername, this.jdbcPassword);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		return connection;
	}
}