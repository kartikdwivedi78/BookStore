package boooks;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class view
 */
@WebServlet("/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  HttpSession ssn=request.getSession(false);
	  //Hashtable<Integer,Integer>kart;
  
	  //kart=(Hashtable<Integer, Integer>) ssn.getAttribute("cart");
	  
		
	  String html="<html>"
			   +" <body background=\"images/images.jpg"
			   + "\">" 
			  +"<center>"
			  +" <br><br><br><br>"
			  +" <font face=\"lucida console\" size=5 color=orange>"
			  +" Your Cart "
			  +" </font><br><br><br>"
			  +"<center><font face=\"lucida console\" size=4 color=black>"
			  +"<table border=1>"
			  +"<tr>"
			  +"<th><font face=\"lucida console\" size=5 color=orange>Item Id "
			  +"<th><font face=\"lucida console\" size=5 color=orange>Quantity "
			  +"</tr>";
	
  Enumeration<String> kz=ssn.getAttributeNames();

  while(kz.hasMoreElements())
  {
   String k=kz.nextElement();
  // System.out.println(k+" : "+hr.hs.get(k));
 
	html=html+ "<tr>"
	  +" <td>"+k+"</td>"
	  +" <td>"+ssn.getAttribute(k)+"</td>"
	  +"</tr>";


  }

	 html=html+"</table></font><br><br><form action=home>"
			  +"<input type=button value=back onclick=\"window.location.href='home'\" >"
			  +"<input type=button value=Buy Now onclick=\"window.location.href='home'\" >"
   		      +"</form></center></body></html>";

	 
	 
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
