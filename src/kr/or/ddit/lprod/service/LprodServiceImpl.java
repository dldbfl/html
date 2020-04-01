package kr.or.ddit.lprod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.LprodVO;

public class LprodServiceImpl implements ILprodService {
	private static ILprodService service;
	private ILprodDao dao;
	
	
	//생성자 - dao 객체 얻기
	private LprodServiceImpl(){
		dao = LprodDaoImpl.getDao();
	}
	
	//service 객체 생성, 리턴
	public static ILprodService getService(){
		if(service == null) service = new LprodServiceImpl();
		
		return service;
	}
	
	
	
	@Override
	public List<LprodVO> listLprod() {
		//1. 변수 선언
		List<LprodVO> list = null;
		try{
			//2. dao 메소드 실행
			list = dao.listLprod();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
		//3. 리턴

	}

}
