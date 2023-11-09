package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cs3220.model.Event;

/**
 * Servlet implementation class AddEvent
 */
@WebServlet("/AddEvent")
public class AddEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddEvent() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>AddEvent</title></head><body>");
		out.println("<h2>New Event</h2>");
        out.println("<form method='post'>" );
        out.println(	"Event Name: <input type='text' name='name'><br>" );
        out.println(	"Date: <input type='date' name='date'><br>" );
        out.println(	"Creator: <input type='text' name='creator'><br>" );
        out.println("<button>Add</button></form>" );
        out.println("</body></html>" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Event> eventList = (List<Event>)getServletContext().getAttribute("eventList");
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		String name = request.getParameter("name");
		Date date = null;
		try {
			date = parser.parse(request.getParameter("date"));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		System.out.println(date);
		String creator = request.getParameter("creator");
		eventList.add(new Event(name, date, creator));
		
		response.sendRedirect("ListEvents");
	}

}
