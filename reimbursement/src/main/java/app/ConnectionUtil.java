package app;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import dev.Log;

/**
 * Final utitlity class to get connection in modular way
 * @author joeyi
 *
 */
public final class ConnectionUtil {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			new Log();
			Log.fatal("Oracle Driver not found. " + e.getMessage());
		}
	}
	
	public static Connection getConnection() throws SQLException, IOException
	{
		Properties props=new Properties();
		FileInputStream in = new FileInputStream("src/main/resources/db.properties");
		props.load(in);
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		return DriverManager.getConnection(url, username, password);
	
	}

	

}
