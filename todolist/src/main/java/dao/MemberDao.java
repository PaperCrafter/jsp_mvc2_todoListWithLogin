package dao;

import java.sql.*;

import vo.MemberVo;

public class MemberDao {
	private Connection conn;
	private static MemberDao instance;
	private MemberDao() {}
	public static MemberDao getInstance() {
		if(instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	public void setConnection(Connection conn){
		this.conn = conn;
	}
	
	public void insert(MemberVo vo) {
		String sql = "INSERT INTO USERINFO (USERNAME, PASSWORD) VALUES(?, ?)";
		String userName = vo.getUserName();
		String password = vo.getPassword();
		PreparedStatement pstmt = null;
		int rs = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			
			rs = pstmt.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MemberVo selectById(String username) {
		MemberVo member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM USERINFO WHERE userName=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int id1 = rs.getInt("id");
				String userName = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				member = new MemberVo(id1, userName,password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
}
