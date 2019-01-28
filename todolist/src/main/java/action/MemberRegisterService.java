package action;

import java.sql.Connection;

import dao.MemberDao;
import db.JdbcUtil;
import vo.MemberVo;

public class MemberRegisterService {
	public void insert(MemberVo vo) {
		Connection conn = JdbcUtil.getConnection();
		MemberDao dao = MemberDao.getInstance();
		dao.setConnection(conn);
		
		if(dao.selectById(vo.getUserName()) == null) {
			dao.insert(vo);
		}else {
			System.out.println("아이디가 중복되었습니다.");
		}
		
		JdbcUtil.close(conn);
	}
}