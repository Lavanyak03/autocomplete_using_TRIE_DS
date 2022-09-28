package insert_input;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/input_insert")
public class input_insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public input_insert() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		String data=request.getParameter("input word");
		PrintWriter out=response.getWriter();
		if(data==null)
		{
			out.println("enter a word");
		}
		else {
			adding(data,out);
		}
	}
	private void adding(String data,PrintWriter out) {
		// TODO Auto-generated method stub
		try {
	         File f1 = new File("datas.txt");
	         if(!f1.exists())
	         {
	        	 f1.createNewFile();
	         }
	         Scanner sc=null;
			    	sc=new Scanner(f1);
			    	while(sc.hasNextLine())
			    	{
			    		String test=sc.nextLine();
			    		String[] words=test.split(" ");
			    		for(String word:words)
			    		{
			    			if(word.equals(data))
			    			{
			    				out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" >");
			    				out.println("<body style=background-image:url('https://www.blinkeredmedia.com/wp-content/uploads/2017/12/BlinkeredMedia-background-for-homepage-squares.jpg');"
			    						+ "background-size:cover;text-align:center;'>"
			    		         		+ "<div>");
			    		         out.println("<b>Word Already Exists!!!!</b>");
			    		         
			    		         out.println("<a style='' class='btn btn-secondary btn-large' href='project_insert.html' role='button'>GOBACK</a>	"
			    		         		+ "</div>"
			    		         		+ "</body>");
			    				sc.close();
			    				return;
			    			}
			    		}
			    	}
			    
	         FileWriter fileWritter = new FileWriter(f1.getName(),true);
	         BufferedWriter bw = new BufferedWriter(fileWritter);
		         bw.write(" \n");
		         bw.write(data);
		         bw.close();
		         out.println("<body style=background-image:url('https://thumbs.dreamstime.com/z/success-word-wooden-cubes-over-blur-background-business-concept-conc-99657688.jpg');background-size:cover;text-align:center;>"
		         		+ "<div>");
		         out.println("Done");
		         out.println("Successfully inserted");
		         out.println("<a  href='project_insert.html' role='button'>GOBACK</a>	"
		         		+ "</div>"
		         		+ "</body>");
	      } 
		 catch(IOException e){
	         out.println("cannot read file:"+e.getMessage());
	      }
		    }
		
	}

