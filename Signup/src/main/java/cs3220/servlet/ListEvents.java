package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Event;

@WebServlet(urlPatterns="/ListEvents", loadOnStartup=1)
public class ListEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListEvents() {
		super();
	}

	public void init() throws ServletException {
		Event ev1 = new Event("Room 19 Valentine Party", new Date(2023,1,14), "Amy Frank");
		Event ev2 = new Event("Room 19 Kindergarten Graduation", new Date(2023,5,15), "Amy Frank");
		List<Event> eventList = new ArrayList<Event>();
		eventList.add(ev1);
		eventList.add(ev2);
		getServletContext().setAttribute("eventList", eventList);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Event> localEventList = (List<Event>) getServletContext().getAttribute("eventList");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Events</title></head><body>");
		out.println("<h2>Events</h2>");
		out.println("<div><a href=\"AddEvent\">New Events</a></div><br>");
		out.println("<div>");
		out.println("<table border=\"1\" cellspacing=\"2\" cellpadding=\"5\">");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Event</th>");
		out.println("<th>Date</th>");
		out.println("<th>Created By</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for(int i=0;i<localEventList.size();i++)
		{
			out.println("<tr>");
			out.println("<td>" + localEventList.get(i).getName() + "</td>");
			out.println("<td>" + localEventList.get(i).getDateAsString() + "</td>");
			out.println("<td>" + localEventList.get(i).getCreator() + "</td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
