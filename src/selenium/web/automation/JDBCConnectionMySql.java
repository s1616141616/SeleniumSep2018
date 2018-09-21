package selenium.web.automation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import org.testng.annotations.Test;


public class JDBCConnectionMySql {

	final String url = "jdbc:mysql://localhost:3306/selenium";
	final String user = "root";
	final String password = "21041980";

	@Test
	public void jdbcConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Loaded");
		Connection con = DriverManager.getConnection(url, user, password);
		if (con != null) {
			System.out.println("Connected to the database test1");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from tblEmployee");

			while (rs.next()) {

				String EmpID = rs.getString("EmpID");
				String fName = rs.getString("fName");
				System.out.print("EmpID: " + EmpID + "  ");

				System.out.println("First Name: " + fName);
			}
		}
	}

}