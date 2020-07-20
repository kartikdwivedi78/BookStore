package boooks;

import java.io.IOException;
import java.sql.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.TimeZone;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import boooks.BookDets;

/**
 * Servlet implementation class home
 */
@WebServlet("/home")
	public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Connection cn;
    Statement st;
    Statement st1;
    PreparedStatement pst;
    Hashtable <Integer, BookDets> books=new Hashtable<>();
    
    

    int rid[]=new int[] {101,102,103,104,105,106,107,108},i;
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public home() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		ServletContext sc = getServletContext();
		sc.setAttribute("bref", this);

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3311/book"+"?useSSL=false && serverTimezone="+TimeZone.getDefault().getID(),"root","kartik@mysql");
			st = cn.createStatement();
       
		
			pst=cn.prepareStatement("UPDATE books SET qoh = ? where bid=?");
			
		    ResultSet rs = st.executeQuery("select * from books");
		    
			while(rs.next())
		    {
                rid[i++]=rs.getInt("bid");
				books.put(rs.getInt("bid"), new BookDets(rs));
		    }
			
			
		}	  
		catch(ClassNotFoundException e)
		{
			System.err.println("\ndriver alert[1] - "+e.getMessage());
		}
		catch(SQLException e)
		{
			System.err.println("\ndriver alert[2] - "+e.getMessage());
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	 	  HttpSession ssn=request.getSession(false);
		  
	    
			String html="<html>"
					   +"<head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
					   +"<style>body {margin: 0;font-family: Arial, Helvetica, sans-serif;}\r\n" 
					   +".topnav {  overflow: hidden;background-color: #333;}.topnav a {float: left;color: #f2f2f2;text-align: center; padding: 14px 16px; text-decoration: none; font-size: 17px;}"
					   +".topnav a:hover {background-color: #ddd;color: black;}.topnav a.active {background-color: #4CAF50;color: white;}</style></head>"
					   +"<body>"
					   +"<div class=\"topnav\"><a class=\"active\" href=\"#home\">Home</a><a href=\"kart.java\">News</a><a href=\"#contacdsadasdsadt\">Contact</a><a href=\"#about\">About</a></div>"
					   +" <center>"
					   +"  <br><br><br><br><br>"
					   +"  <font face=\"lucida console\" size=8 color=white>"
					   +"   Welcome To BOOK  STORE";
			if(ssn!=null)
			{
					   html=html+"<br>You Are already Logged In "
							    +"<form action=view><input type=submit value=view name=view></form>";
			}		  
					html=html+"  </font><br><br><br>"
					   +"  <table border=5>"
					   +"  <tr rowspan=1>"
					   +"   <td colspan=1><a href=details?id="+rid[1]+"><img src=images/101.jpg width=180px height=200px  style=\"padding-bottom:0.5em;\"><center>"+books.get(rid[1]).bname+"<br>Price : "+books.get(rid[1]).price+"</center><br></td>"
					   +"   <td colspan=1><a href=details?id="+rid[2]+"><img src=images/102.jpg width=180px height=200px  style=\"padding-bottom:0.5em;\"><center>"+books.get(rid[2]).bname+"<br>Price : "+books.get(rid[2]).price+"</center><br></td>"
	         		   +"   <td colspan=1><a href=details?id="+rid[3]+"><img src=images/103.jpg width=180px height=200px  style=\"padding-bottom:0.5em;\"><center>"+books.get(rid[3]).bname+"<br>Price : "+books.get(rid[3]).price+"</center><br></td>"
	         		   +"   <td colspan=1><a href=details?id="+rid[7]+"><img src=images/104.jpg width=180px height=200px  style=\"padding-bottom:0.5em;\"><center>"+books.get(rid[7]).bname+"<br>Price : "+books.get(rid[7]).price+"</center><br></td>"
	         						
					   +"  </tr>"
				
					   +"  <tr rowspan=1>"
					   +"   <td colspan=1><a href=details?id="+rid[4]+"><img src=images/105.jpg width=180px height=200px  style=\"padding-bottom:0.5em;\"><center>"+books.get(rid[4]).bname+"<br>Price : "+books.get(rid[4]).price+"</center><br></td>"
					   +"   <td colspan=1><a href=details?id="+rid[5]+"><img src=images/106.jpg width=180px height=200px  style=\"padding-bottom:0.5em;\"><center>"+books.get(rid[5]).bname+"<br>Price : "+books.get(rid[5]).price+"</center><br></td>"
					   +"   <td colspan=1><a href=details?id="+rid[6]+"><img src=images/107.jpg width=180px height=200px  style=\"padding-bottom:0.5em;\"><center>"+books.get(rid[6]).bname+"<br>Price : "+books.get(rid[6]).price+"</center><br></td>"
	         		   +"   <td colspan=1><a href=details?id="+rid[7]+"><img src=images/108.jpg width=180px height=200px  style=\"padding-bottom:0.5em;\"><center>"+books.get(rid[7]).bname+"<br>Price : "+books.get(rid[7]).price+"</center><br></td>"
					
					   +"  </tr>";
					  
					 /*  +"  <tr rowspan=1>"
					   +"   <td colspan=1><a href=details?id="+rid[8]+"><img src=images/109.jpg width=180px height=200px  style=\"padding-bottom:0.5em;\"><center>"+books.get(rid[8]).bname+"<br>Price : "+books.get(rid[8]).price+"</center><br></td>"
					   +"   <td colspan=1><a href=details?id="+rid[9]+"><img src=images/110.jpg width=180px height=200px  style=\"padding-bottom:0.5em;\"><center>"+books.get(rid[9]).bname+"<br>Price : "+books.get(rid[9]).price+"</center><br></td>"
					   +"   <td colspan=1><a href=details?id="+rid[10]+"><img src=images/111.jpg width=180px height=200px  style=\"padding-bottom:0.5em;\"><center>"+books.get(rid[10]).bname+"<br>Price : "+books.get(rid[10]).price+"</center><br></td>"
	         		   +"   <td colspan=1><a href=details?id="+rid[11]+"><img src=images/112.jpg width=180px height=200px  style=\"padding-bottom:0.5em;\"><center>"+books.get(rid[11]).bname+"<br>Price : "+books.get(rid[11]).price+"</center><br></td>"
					
					   +"  </tr>"*/
		 	
			
		 	
		 			  
			Enumeration kz = books.keys();
			
			while(kz.hasMoreElements())
			{
				int k = (Integer)kz.nextElement();
				System.out.println(books.get(k));
			}
			
			html = html + "</table></center></body></html>";
			
			response.getWriter().println(html);
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void destroy() 
	{
		// TODO Auto-generated method stub
		try
		{	 		
		Enumeration kz = books.keys();
			
			while(kz.hasMoreElements())
			{
				int k = (Integer)kz.nextElement();
				int q=books.get(k).qoh;
		        System.out.println("updated in destroyed : "+q);
				pst.setInt(1,q);
		        pst.setInt(2,i);
		        pst.executeUpdate();
			}     
				cn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
