import java.sql.*;
import javax.swing.*;

public class OracleDatabaseConnection {
	Connection conn = null;
	public static Connection dbConnector()
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","bayaognjen");
			JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
			
	}
		
}
