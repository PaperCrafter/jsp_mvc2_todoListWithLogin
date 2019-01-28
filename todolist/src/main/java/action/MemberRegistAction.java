package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.MemberVo;

public class MemberRegistAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String id = request.getParameter("id");
		int idInt = 0;
		String userName = request.getParameter("user");
		String password = request.getParameter("pass");
		MemberVo vo = new MemberVo(idInt, userName, password);
		
		MemberRegisterService service = new MemberRegisterService();
		service.insert(vo);
		
		System.out.println(idInt + "/" + userName + "/" + password);
		
		return new ActionForward(true,"index.jsp");
	}
}
