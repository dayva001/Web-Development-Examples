package cs23220.GuestBook.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs23220.GuestBook.model.GuestBookEntry;

/**
 * Servlet implementation class AddComment
 */
@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// display form
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        out.println( "<html><head><title>AddComment</title></head><body>" );
        out.println( "<form method='post'>" );
        out.println( "Name: <input type='text' name='name'><br>" );
        out.println(
            "<textarea name='message' rows='6' cols='60'></textarea><br>" );
        out.println( "<button>Add Comment</button></form>" );
        out.println( "</body></html>" );
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GuestBookEntry> entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
		
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		entries.add(new GuestBookEntry(name, message));
		
		response.sendRedirect("GuestBook");
	}

}
