package in.code.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private JdbcUtil() {
	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getJdbcConnection() throws SQLException, IOException {
		// Physical Loading and getting Connection
		FileInputStream fis = new FileInputStream(
				"G:\\My_Project\\OnlineEbookStore\\src\\main\\resources\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		Connection con = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
				properties.getProperty("password"));
		return con;

	}

	public static void cleanUp(Connection con, Statement st, ResultSet rs) throws SQLException {
		if (con != null)
			con.close();
		if (st != null)
			st.close();
		if (rs != null)
			rs.close();
	}
}