package boooks;
import java.sql.*;

import boooks.home;

public class BookDets extends home
{
	String bname,aname,pub;
	int id,price,qoh;
	
	public BookDets(ResultSet rs) throws SQLException
	{
		try
		{
		 bname=rs.getString("title");
		 aname=rs.getString("author");
		 pub=rs.getString("publication");
		 
		 id=rs.getInt("bid");
		 price=rs.getInt("price");
		 qoh=rs.getInt("qoh");
			
		 System.out.println(bname);
				
			
		}
		catch(SQLException e)
		{
			System.err.println("\ndriver alert[3] - "+e.getMessage());
		}
	}
}