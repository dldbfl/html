package kr.or.ddit.buyer.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDaoImpl;
import kr.or.ddit.buyer.dao.IBuyerDao;
import kr.or.ddit.buyer.vo.BuyerVO;
/**
 * 
 * service 객체 생성
 * get() - return service 객체
 * 
 * dao 객체를 얻어
 * dao의 메소드 호출
 * 
 */
public class BuyerServiceImpl implements IBuyerService {
	private static  IBuyerService service;
	private IBuyerDao dao;
	
	private BuyerServiceImpl(){
		dao = BuyerDaoImpl.getDao(); 
	}
	
	public static IBuyerService getService(){
		if(service == null) service = new BuyerServiceImpl();
		
		return service;
	}

	@Override
	public List<BuyerVO> nameList() {
		List<BuyerVO> list = null ;
		
		try {
			list = dao.nameList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public BuyerVO buyerDetail(String id) {
		BuyerVO vo = null;
		   
		try {
			vo = dao.buyerDetail(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

}
