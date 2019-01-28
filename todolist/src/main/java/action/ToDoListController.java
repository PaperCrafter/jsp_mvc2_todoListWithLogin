package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToDoListController
 */
@WebServlet("/ToDoListController")
public class ToDoListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ToDoListController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doProess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		ActionForward forward = null;
		
		MemberActionFactory factory = MemberActionFactory.getInstance();
		Action action = factory.makeAction(command);
    	
    	forward = action.execute(request, response);
		forward.execute(request, response);
	}
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	System.out.println("get");
    	doProess(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
		doProess(request, response);
		//doGet(request, response);
	}

}
