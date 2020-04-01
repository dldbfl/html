package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

/**
 * Servlet implementation class ProdList
 */
@WebServlet("/p.do")
public class ProdList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 클라이언트 요청 시 전달되는 값을 받는다. - 없다.
		String lgu = request.getParameter("lprod_gu");
		//1. service객체를 얻는다.
		IProdService service = ProdServiceImpl.getService();
		//2. service메소드를 호출한다. - 결과값을 받는다.
		List<ProdVO>	 list = service.prodNames(lgu);
		//3. 결과값을 request에 저장
		request.setAttribute("list", list);
		
		//4. 출력을 위해 view페이지(jsp)페이지로 이동한다. - 
		// redirect : 한번 서버 밖으로 응답한 후 새로운 request로 재요청하기 때문에  controller, view가 request, response를 공유하지 못한다.
				
		// forword : controller, view가 request, response를 공유한다.
			//request에 저장된 결과값을 jsp페이지로 넘겨준다.
		
		RequestDispatcher disp =  request.getRequestDispatcher("0225/prodNoNames.jsp");
		
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 클라이언트 요청 시 전달되는 값을 받는다. - 없다.
		String pid = request.getParameter("prod_id");
		//1. service객체를 얻는다.
		IProdService service = ProdServiceImpl.getService();
		//2. service메소드를 호출한다. - 결과값을 받는다.
		ProdVO vo = service.prodDetail(pid);
		//3. 결과값을 request에 저장
		request.setAttribute("prodVo", vo);
		
		//4. 출력을 위해 view페이지(jsp)페이지로 이동한다. - 
		// redirect : 한번 서버 밖으로 응답한 후 새로운 request로 재요청하기 때문에  controller, view가 request, response를 공유하지 못한다.
				
		// forword : controller, view가 request, response를 공유한다.
			//request에 저장된 결과값을 jsp페이지로 넘겨준다.
		
		RequestDispatcher disp =  request.getRequestDispatcher("0226/prodDetail.jsp");
		
		disp.forward(request, response);
		
		
		
	}

}
