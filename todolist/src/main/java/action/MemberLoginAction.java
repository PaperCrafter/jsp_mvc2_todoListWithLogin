package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.MemberVo;

public class MemberLoginAction implements Action{
	@SuppressWarnings("null")
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = request.getServletContext();
		String userName = request.getParameter("user");
		String password = request.getParameter("pass");
		
		MemberLoginService service = new MemberLoginService();
		MemberVo member = service.getMember(userName);
		
		if(member != null) {
			if(password.equals(member.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("userName", userName);
				session.setAttribute("userId",member.getId());
				context.log("로그인 성공");
				return new ActionForward(false, "member/TodoList.jsp");
			}
		}else {
			context.log("아이디가 존재하지 않습니다.");
			String login="dontExist";
			request.setAttribute("login", login);
			
		}
		return new ActionForward(false, "index.jsp");
	}
}