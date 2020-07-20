package boooks;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boooks.home;

/**
 * Servlet implementation class details
 */
@WebServlet("/details")
public class details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext sc=request.getServletContext();
		home h=(home)sc.getAttribute("bref");
		
	    int id=Integer.parseInt(request.getParameter("id"));
	   
	    
         String html="<html><body bgcolor=teal style=\"background-color:#808080; color:white;\">"
	  			   +" <center>"
	  			   +"  <br><br><br>"
	  			   +"  <font face=\"lucida console\" size=8 color=white>"
	  			   +"   Book Detail for : "+id+" "
	  			   +"  </font><br>";
        
         if(h.books.get(id).qoh==0)
         {
        	 html =html+"******This book is out of stock!!******";
         }
	  			   
	  			html=html+"<br><br>"
                   +"<img src=images/"+id+".jpg  width=260 height=200>"	  			  
	  			   +" <br><br> <table border=5>"
	  			   +"  <tr>"
	  			   +"<td>Book Name</td>"
	  	           +"<td><font face=\\\"lucida console\\\" size=6 color=red>"+ h.books.get(id).bname +"</font></td>"		   
	  		       +"</tr>"
	  		       +"<td>Book Publication</td>"
	  	           +"<td><font face=\\\"lucida console\\\" size=6 color=red>"+ h.books.get(id).pub +"</font></td>"		   
	  		       +"</tr>"
	  		       +"<td>Author Name</td>"
	  	           +"<td><font face=\\\"lucida console\\\" size=6 color=red>"+ h.books.get(id).aname +"</font></td>"		   
	  		       +"</tr>"
	  		       +"<td>price</td>"
	  	           +"<td><font face=\\\"lucida console\\\" size=6 color=red>"+ h.books.get(id).price +"</font></td>"		   
	  		       +"</tr>"
	  		       +"</tr>"
	  			   +"</table>";
	  			 if(h.books.get(id).qoh!=0)
	  	         {
	  	        
	  			  html=html+"<form action=kart><input type=hidden name=bookid value="+id+"><input type=submit value=\"add to cart\" ></form>";
	  	         }
	 	    	  html=html+"<form action=home><input type=button value=back onclick=\"window.location.href='home'\" ></form>"
	  		               +"</center></body></html>";
	  			 
	 		response.getWriter().println(html);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
