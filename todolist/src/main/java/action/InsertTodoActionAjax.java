package action;

import java.sql.Connection;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TodoDao;
import db.JdbcUtil;
import vo.TodoVo;

public class InsertTodoActionAjax {
	public void insertComponent(HttpServletRequest request, HttpServletResponse response){
		Connection conn = JdbcUtil.getConnection();
		TodoDao todo = TodoDao.getInstance();
		todo.setConnection(conn);
		
		HttpSession sess = null;
		sess = request.getSession();
		
		TodoVo tdv = new TodoVo();
		System.out.println(request.getQueryString());
		int userid = (int)sess.getAttribute("userId");
		Date date = Date.valueOf(request.getParameter("date"));
		String td = (String)request.getParameter("todo");
		
		tdv.setUserid(userid);
		tdv.setDate(date);
		tdv.setTodo(td);
		
		int res = (int) todo.insert(tdv);
	}
}
