package cs23220.Login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet(urlPatterns="/Login", loadOnStartup=1)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	public void init() throws ServletException {
		User user1 = new User("John", "Doe", "jdoe","abcd");
		User user2 = new User("Sarah", "Miller", "SMill", "password");
		List<User> userbase = new ArrayList<User>();
		userbase.add(user1);
		userbase.add(user2);
		getServletContext().setAttribute("userbase", userbase);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Login</title></head><body>");
        out.println("<form action='Login' method='post'>" );
        out.println("Username: <input type='text' name='username'><br><br>" );
        out.println("Password: <input type='password' name='password'><br><br>" );
        out.println("<button>Login</button></form>" );
        out.println("</body></html>" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User>userbase = (List<User>)getServletContext().getAttribute("userbase");
		for(int i=0;i<userbase.size();i++)
		{
			if(request.getParameter("username").equals(userbase.get(i).getUsername()))
				if(request.getParameter("password").equals(userbase.get(i).getPassword()))
				{	
					 HttpSession session = request.getSession();
					 session.setAttribute("member", userbase.get(i));
					 response.sendRedirect( "Members" );
				}
		}
		doGet(request,response);
	}

	
}
