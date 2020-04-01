package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVO;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

/**
 * Servlet implementation class ZipCode
 */
@WebServlet("/ZipCode")
public class ZipCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZipCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0
		request.setCharacterEncoding("UTF-8");
		String dong = request.getParameter("dong");
		
		//1. service객체를 얻는다.
		IMemberService service = MemberServiceImpl.getService();
		
		//2. service메소드를 호출한다. - 결과값을 받는다.
		List<ZipVO> list = service.selectByDong(dong);
		//3. 결과값을 request에 저장
		request.setAttribute("list", list);
		
		//4. 출력을 위해 view페이지(jsp)페이지로 이동한다. - 
		// redirect : 한번 서버 밖으로 응답한 후 새로운 request로 재요청하기 때문에  controller, view가 request, response를 공유하지 못한다.
				
		// forword : controller, view가 request, response를 공유한다.
			//request에 저장된 결과값을 jsp페이지로 넘겨준다.
		
		request.getRequestDispatcher("0226/zipsearch.jsp").forward(request, response);
		
	}

}
