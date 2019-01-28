package action;

import java.sql.Connection;

import dao.MemberDao;
import db.JdbcUtil;
import vo.MemberVo;

public class MemberLoginService {
	
	public MemberVo getMember(String userName) {
		MemberVo member = null;
		
		Connection conn = JdbcUtil.getConnection();
		MemberDao dao = MemberDao.getInstance();
		dao.setConnection(conn);
		member = dao.selectById(userName);
		JdbcUtil.close(conn);
		
		return member;
	}
}
