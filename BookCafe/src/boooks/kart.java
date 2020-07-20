package boooks;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import boooks.home;

/**
 * Servlet implementation class kart
 */
@WebServlet("/kart")
public class kart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public kart() {
        super();
        // TODO Auto-generated constructor stub
    }
/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  int id=Integer.parseInt(request.getParameter("bookid"));

	  ServletContext sc=request.getServletContext();

	  home h=(home)sc.getAttribute("bref");
 
      int q=h.books.get(id).qoh-1;
      h.books.get(id).qoh=q;

	  HttpSession ssn=request.getSession(false);
	  
	  if(ssn==null)
	  {
		ssn=request.getSession();
		ssn.setAttribute(id+"",1);
	   
		String html="<html><body><center>You are successfully registered <br><br>"
       		       + "<form action=home><input type=button value=back onclick=\"window.location.href='home'\" ></form>"
       		      + "<form action=view><input type=submit value=viewcart name=view></form>"
       		      + "</form></center></body></html>";
       response.getWriter().println(html);

	  }
	
	  else
	  {
		  Integer qty=(Integer)ssn.getAttribute(id+"");
		  if(qty==null)
		  {
			  ssn.putValue(id+"",1);
		  }
		  else
		  {
			  int q1=(int) ssn.getValue(id+"")+1;
			  ssn.setAttribute(id+"",q1);			  
		  }
	      String html="<html><body>"
      			   +"<form action=view><input type=submit value=viewcart name=view></form>"
   		       +"<form action=home><input type=button value=back onclick=\"window.location.href='home'\" ></form>"
   		       +"</body></html>";

		   response.getWriter().println(html);;

	  
	  }
	  
	  
	  
	  
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
