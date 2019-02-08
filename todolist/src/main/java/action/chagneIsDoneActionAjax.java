package action;

import java.sql.Connection;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TodoDao;
import db.JdbcUtil;
import vo.TodoVo;

public class chagneIsDoneActionAjax {
	public void changeIsDone(HttpServletRequest request, HttpServletResponse response){
		Connection conn = JdbcUtil.getConnection();
		TodoDao todo = TodoDao.getInstance();
		todo.setConnection(conn);
		
		String td = (String)request.getParameter("todo");
		todo.changeStatus(td);
		
	}
}
