package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;
import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class MemberServiceImpl implements IMemberService {

	private static IMemberService service;
	private IMemberDao dao;
	
	private MemberServiceImpl(){
		dao = MemberDaoImpl.getDao();
	}
	
	public static IMemberService getService(){
		if(service == null)service = new MemberServiceImpl();
		
		return service;
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		//1. 변수 선언
		List<ZipVO> list = null;
		try{
			//2. dao 메소드 실행
			list = dao.selectByDong(dong);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
		//3. 리턴
	}

	@Override
	public String insertMember(MemberVO vo) {
		String memId= null;
		
		
		try {
			memId = dao.insertMember(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memId;
		
	}

	@Override
	public String checkById(String id) {
		//1. 변수 선언
				String memId= null;
				try{
					//2. dao 메소드 실행
					memId = dao.checkById(id);
				}catch(SQLException e){
					e.printStackTrace();
				}
				return memId;
				//3. 리턴
	}

}
