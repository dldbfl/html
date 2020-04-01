package kr.or.ddit.prod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService {

	private static IProdService service;
	private IProdDao dao;
	
	private ProdServiceImpl(){
		dao = ProdDaoImpl.getDao();
	}
	
	public static IProdService getService(){
		if(service == null)service = new ProdServiceImpl();
		
		return service;
	}
	
	@Override
	public List<ProdVO> prodNames(String lprod_gu) {
		//1. 변수 선언
				List<ProdVO> list = null;
				try{
					//2. dao 메소드 실행
					list = dao.prodNames(lprod_gu);
				}catch(SQLException e){
					e.printStackTrace();
				}
				return list;
				//3. 리턴
	}

	@Override
	public ProdVO prodDetail(String prod_id) {
		ProdVO vo = null;
		
		try {
			vo = dao.prodDetail(prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

}
