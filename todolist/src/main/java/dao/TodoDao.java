package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import vo.TodoVo;

public class TodoDao {
	private Connection conn;
	private static TodoDao instance;
	public TodoDao(){}
	
	public static TodoDao getInstance() {
		if(instance == null) {
			instance = new TodoDao();
		}
		return instance;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int insert(TodoVo todo) {
		String sql = "INSERT INTO TODO(USERID, DATE, TODO) VALUES(?, ?, ?)";
		PreparedStatement pstmt;
		 
		int userid = todo.getUserid();
		Date date = todo.getDate();
		String td = todo.getTodo();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userid);
			pstmt.setDate(2, date);
			pstmt.setString(3, td);
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<TodoVo> select(int userid){
		String sql = "SELECT * FROM TODO WHERE USERID = ?";
		ArrayList<TodoVo> list = new ArrayList<TodoVo>();
		PreparedStatement pstmt;
		ResultSet rs;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,userid);
			//pstmt.setBoolean(2, isdnoe);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TodoVo td = new TodoVo();
				td.setUserid(rs.getInt(1));
				td.setDate(rs.getDate(2));
				td.setTodo(rs.getString(3));
				td.setDone(rs.getBoolean(4));
				list.add(td);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	};
	
	public void changeStatus(String todo) {
		String sql = "UPDATE TODO SET DONE = true WHERE TODO = ?";
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, todo);
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
