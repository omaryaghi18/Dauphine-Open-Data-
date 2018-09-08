package com.omaropendata.dao;



import java.sql.*;

import com.omaropendata.entity.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PersonDao {
	
	//public Person getStudent(String name){
		
		//Student s = new Student();
		
		//HttpSession session = request.getSession();
		
	//	session.getAttribute("Persontodb");
		//s.setStdid(1);
		//s.setName("Karam");
		//s.setfName("Haytham Mohammed");
		
		// in order to connect to the db , we have to do 7 steps, 
		//run the driver , then create a connection , then think ( create a statement)
		// then say somthing ( write the query ) 
		// save the result of the query inside a return statement
		// use a rs.next to point the pointer to the next row in the db, we do this inside an if to check if there is another row or no
		// then we save the rows from the db into the Student object, one by one
		// String jdbc = "jdbc:mysql://localhost/hibernatedb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	//	try {
		//	Class.forName("com.mysql.jdbc.Driver"); // loading the jdbc driver
	//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hibernatedb","root","root"); // creating a connection with the db
	//		Statement st = con.createStatement(); // initialising a statement to say it to the db , then saying it
			//ResultSet rs = st.executeQuery("Select * from student Where std_id="+stdid); // executing the query:statement, and saving it in a result set which is the return of  createstatment
//			if(rs.next()) // checking if there are more rows after the stdid , if yes ?
		//	{
//	this		s.setStdid(rs.getInt("std_id")); //get the first row
//	is	to		//System.out.println("\n");
//	get	from		s.setName(rs.getString("std_name")); // get the second
//	db			//System.out.println("\n");
//				s.setfName(rs.getString("std_fname")); // get the third
				
				//to insert to the db we do 
		//		String sql = "INSERT INTO course (course_code, course_desc, course_chair)" +
			//	        "VALUES (?, ?, ?)";
//				PreparedStatement preparedStatement = conn.prepareStatement(sql);
//				preparedStatement.setString(1, "Test");
//				preparedStatement.setString(2, "Test2");
//				preparedStatement.setString(3, "Test3");
//				preparedStatement.executeUpdate(); 
  		//}
			
			
//		} catch (Exception e) {
			// TODO: handle exception
		//	System.out.println(e); // if no connection errors or any error , we will get our results !	
		//}
		
		//return s;
		
	//}

}
