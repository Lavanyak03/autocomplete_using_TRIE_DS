package search_new;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/search_new")
public class search_new extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public search_new() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=null;
		try
		{
			out=response.getWriter();
			String key=request.getParameter("user");
//			RequestDispatcher rd=request.getRequestDispatcher("/result"); 
			response.sendRedirect("www.google.com");
			out.close();
			    	
		}
		catch(Exception e)
		{
			out.println("Error msg is:"+e.getMessage());
		}
	}

}
