package kr.or.ddit.ibatis.config;

import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * 
 *  Mapper(member.xml)파일을 sql문을 수행하기 위해서
 *  SqlMapClient 객체를 생성한다.
 *
 * 환경설정파일(SqlMapConfig.xml)을 재료로 한다.
 */




public class SqlMapClientFactory {
	
	private static SqlMapClient smc;
		
	static{
		
		try {
			//1-1. xml문서 읽어오기
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/ibatis/config/SqlMapConfig.xml");
			
			//1-2위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체 생성
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	public static SqlMapClient getSMClient(){
		return smc;
		
	}
}