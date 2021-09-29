package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.HumanDto;

public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet doGet()");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String hobby[] = req.getParameterValues("hobby");
        
        HumanDto human = new HumanDto(name, age, gender, hobby);
        /*
        resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>HelloServletHtml</title>");
	    pw.println("</head>");
		
	    pw.println("<body>");		
	    
	    pw.println("<h3>Hello Servlet</h3>");	
	    	
	    pw.println("<p>human:" + human.toString() + "</p>");	
	    
	    pw.println("</body>");		
		
		pw.println("</html>");
		
		pw.close();
		*/
		req.setAttribute("name", name );
		req.setAttribute("age", age );
		req.setAttribute("gender", gender );
		req.setAttribute("hobby", hobby );
		req.setAttribute("human", human);
		
		RequestDispatcher rd = req.getRequestDispatcher("world");
		rd.forward(req, resp);
		
	//	resp.sendRedirect("world");
		
        
	}
		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

}
