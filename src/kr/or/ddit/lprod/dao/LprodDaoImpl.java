package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.lprod.vo.LprodVO;

public class LprodDaoImpl implements ILprodDao {

	private SqlMapClient client;
	private static ILprodDao dao;
	
	//생성자 - client 얻기
	private LprodDaoImpl(){
		client = SqlMapClientFactory.getSMClient();
	}
	
	//dao객체 생성 , 리턴 - getDao()
	public static ILprodDao getDao(){
		if(dao == null) dao = new LprodDaoImpl();
		
		return dao;
	}
	
	
	@Override
	public List<LprodVO> listLprod() throws SQLException {
		return client.queryForList("lprod.listLprod");
		
	}

}
