package com.covid.info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Covid {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection connet = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "Juned@56");
		Statement st = connet.createStatement();
		//ResultSet result = st.executeQuery("select location, new_cases, new_cases_smoothed from covidinformation limit 1800");
		ResultSet result = st.executeQuery("SELECT location, Count(new_cases) as new_cases FROM covidinformation WHERE new_cases> 1000 GROUP BY location ORDER BY new_cases");
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getString(2));
		}
		connet.close();
		System.out.println("Featching data: ");
	}
}
