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
		String cnfPassword = request.getParameter("cnfPass");
		MemberVo vo = new MemberVo(idInt, userName, password);
		
		MemberRegisterService service = new MemberRegisterService();
		String res = service.insert(vo);

		if(res=="existUser"){
			String result = "existUser";
			request.setAttribute("signin",result);
			return new ActionForward(false,"member/member_form.jsp");
		}
		
		else if(password != cnfPassword) {
			String result = "pwdDosentEqual";
			request.setAttribute("signin",result);
			System.out.println("패스워드가 일치하지 않습니다.");
			return new ActionForward(false,"member/member_form.jsp");
			
		}
		
		else if(res=="success") {
			String result = "success";
			request.setAttribute("signin",result);
			System.out.println(idInt + "/" + userName + "/" + password);
			return new ActionForward(false,"index.jsp");
		}
		
		
		return new ActionForward(false,"member/member_form.jsp");
		
	}
}
