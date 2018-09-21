package selenium.web.automation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import org.testng.annotations.Test;

/*open run configuration & write below line to VM Arguments box
-Djava.library.path="C:\Program Files\Java\jre1.8.0_181\bin"
-Djava.library.path="D:\QA Important 2018\JDBC SQL\sqljdbc_6.4\enu\auth\x64" */ //this for sqljdbc_auth.dll file

public class JDBCConnectionSQL {
	final String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=Practice;integratedSecurity=true;";

	@Test
	public void jdbcConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Driver Loaded");
		Connection con = DriverManager.getConnection(url);
		if (con != null) {
			System.out.println("Connected to the database test1");
			System.out.println("===============================");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from tblEmployee");

			while (rs.next()) {
				System.out.println("DepID: " + rs.getString(1) + " DepName: " + rs.getString(2) + " City: "
						+ rs.getString(3) + " DepHead: " + rs.getString(4));
			}
		}
	}
}