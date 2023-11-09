package cs23220.Login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;


@WebServlet("/Members")
public class Members extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Members() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User loggedIn= (User)session.getAttribute("member");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Member Landing Page</title></head><body>");
		out.println( "<h2>Members Area</h2>" );
		out.println("Hi, " + loggedIn.getFirstName() + "! Welcome to the Members Area!<br><br>");
		out.println("<a href='Logout'>Logout</a>");
        out.println("</body></html>" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}
