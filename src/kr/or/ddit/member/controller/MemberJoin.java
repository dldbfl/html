package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class MemberJoin
 */
@WebServlet("/MemberJoin")
public class MemberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 클라이언트에서 요청 시 (전송) 전달값 받기

			/*String mid = request.getParameter("mem_id");
			String mpass = request.getParameter("mem_pass");
			String mname = request.getParameter("mem_name");
			String mbir = request.getParameter("mem_bir");
			String mzip = request.getParameter("mem_zip");
			String madd1 = request.getParameter("mem_add1");
			String madd2 = request.getParameter("mem_add2");
			String mhp = request.getParameter("mem_hp");
			String mmail = request.getParameter("mem_mail");
			
			//vo에 저장하기
			MemberVO vo = new MemberVO();
			vo.setMem_id(mid);
			vo.setMem_pass(mpass);
			vo.setMem_name(mname);
			vo.setMem_bir(mbir);
			vo.setMem_zip(mzip);
			vo.setMem_add1(madd1);
			vo.setMem_add2(madd2);
			vo.setMem_hp(mhp);
			vo.setMem_mail(mmail);*/
		
		
		MemberVO vo = new MemberVO();
		
		try {
			
			BeanUtils.populate(vo, request.getParameterMap());
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
					
		//1. service 객체 얻기
			IMemberService service = MemberServiceImpl.getService();
						
		//2. service 메소드 호출 하기 - 파라미터 : vo,
			//	결과값 받기 : 저장 성공 : 저장한 id , 저장실패 : null.
			String resid = service.insertMember(vo);
			
		//3. 결과값을 request에 저장
			request.setAttribute("resid", resid);
			request.setAttribute("mid", vo.getMem_id());
		
		//4. 출력을 위해 view 페이지(jsp)로 이동한다.
		// redirect : 한번 서버 밖으로 응답한 후 새로운 request로 재요청하기 때문에  controller, view가 request, response를 공유하지 못한다.
		
		// forword : controller, view가 request, response를 공유한다.
		//request에 저장된 결과값을 jsp페이지로 넘겨준다.
			RequestDispatcher disp =  request.getRequestDispatcher("0226/insert.jsp");
			
			disp.forward(request, response);
		
	}

}
