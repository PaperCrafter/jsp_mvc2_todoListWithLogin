package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionForward {
	private boolean isRedirect = false;
	private String viewName = "";
	public ActionForward(){}
	public ActionForward(boolean isRedirect, String viewName) {
		this.isRedirect = isRedirect;
		this.viewName = viewName;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(isRedirect) {
    		System.out.println("redirected!!");
    		response.sendRedirect(viewName);
    	}else {
			RequestDispatcher view = request.getRequestDispatcher(viewName);
			System.out.println("fowarded!!");
			view.forward(request, response);
    	}
	}
}
