package search_word;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
//import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import search_word.Ideone.trie;

//import search_word.Ideone.trie;
//import java.util.*;

@WebServlet("/input_search")
public class input_search extends HttpServlet{
	private static final long serialVersionUID = 1L;
    public input_search() {
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
			Ideone.inserting();
			autosuggest(key,out,response, request);
			    	
		}
		catch(Exception e)
		{
			out.println("Error msg is:"+e.getMessage());
		}
	}

	public void suggest(trie temp2, String prefix, PrintWriter out, HttpServletResponse response, HttpServletRequest request)
	{
		// TODO Auto-generated method stub
		try {
			out=response.getWriter();
		} catch (IOException e) {
			System.out.println("cannot search word ");
		}
		 if(temp2.isword==true)
	        {
			 	 out.println("<li>"+prefix+"</li>");
//			 out.println("<br />");
	        }
	        for(int i=0;i<26;i++)
	        {
	            if(temp2.child[i]!=null)
	            {int a=97+i;
	               prefix= prefix+(char)a;
	                suggest(temp2.child[i],prefix,out,response, request);
	                prefix=prefix.substring(0,prefix.length()-1);
	            }
	        }
	     
	        
		
	}

	public void autosuggest(String key, PrintWriter out, HttpServletResponse response, HttpServletRequest request) 
	{
		// TODO Auto-generated method stub
		
		if(key==null)
	       { return;}
	        	Ideone.trie temp=Ideone.root;
	        for(int i=0;i<key.length();i++)
	        {
	            int index = key.charAt(i) - 'a';
	            if(temp.child[index]==null)
	            { 
	                return;
	            }
	            temp=temp.child[index];
	        }
//	        out.println("<body>");
//	        out.println("<div class='result' style='position:absolute;"
//	        		+ "left:570px;"
//	        		+ "top:281px;"
//	        		+ "background-color:white;"
//	        		+ "width:180px;"
//	        		+ "max-height:400px;"
//	        		+ "overflow:scroll;"
//	        		+ "resize:both;"
////	        		+ "border-radius:8px;'>");
	        out.println("<ul class='list-unstyled'>");
	        suggest(temp,key,out,response, request);
	        out.println("</ul>");
//	        out.println("</div>");
////	      RequestDispatcher rd=request.getRequestDispatcher("/result");  
//	        try {
//				rd.forward(request, response);
//			} catch (ServletException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} 
//	        out.println("</body>");
//	        out.println("</html>");  
//		
	}
}   
	      
