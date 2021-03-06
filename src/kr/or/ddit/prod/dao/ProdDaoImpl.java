package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.prod.vo.ProdVO;

import com.ibatis.sqlmap.client.SqlMapClient;

public class ProdDaoImpl implements IProdDao {

	private SqlMapClient client;
	private static IProdDao dao;
	
	private ProdDaoImpl(){
		client = SqlMapClientFactory.getSMClient();
	}
	
	public static IProdDao getDao(){
		if(dao == null)dao = new ProdDaoImpl();
		
		return dao;
	}
	
	
	@Override
	public List<ProdVO> prodNames(String lprod_gu) throws SQLException {
	
		return client.queryForList("prod.prodNames",lprod_gu);
	}

	@Override
	public ProdVO prodDetail(String prod_id) throws SQLException {
		
		return (ProdVO) client.queryForObject("prod.prodDetail",prod_id);
	}

}
