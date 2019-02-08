package action;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TodoDao;
import db.JdbcUtil;
import vo.TodoVo;

public class LoadTodoActionAjax {
	
	public String getJSON(HttpServletRequest request, HttpServletResponse response, boolean isDone) {
		HttpSession sess = request.getSession();
		int userid = (int)sess.getAttribute("userId");
		Connection conn = JdbcUtil.getConnection();
		
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		TodoDao tododao = new TodoDao();
		tododao.setConnection(conn);
		ArrayList<TodoVo> todoList = tododao.select(userid);
		for(int i =0; i < todoList.size(); i++) {
			result.append("[{\"value\": \""+ todoList.get(i).getDate() + "\"},");
			result.append("{\"value\": \""+ todoList.get(i).getTodo() + "\"},");
			result.append("{\"value\": \""+ todoList.get(i).getDone() + "\"}],");
		}
		result.append("]}");
		return result.toString();
	}
}
