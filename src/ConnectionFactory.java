import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			/* HOMOLOGACAO */
			return DriverManager.getConnection("jdbc:mysql://localhost/doudb", "root", "");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}