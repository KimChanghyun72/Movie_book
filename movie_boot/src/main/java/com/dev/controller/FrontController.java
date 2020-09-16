package com.dev.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet(name="front",
			urlPatterns = "*.do", 
			initParams = 
			{
				@WebInitParam(name = "charset", value="UTF-8")
			})
*/

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String charset = null;
	HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		list.put("/memberInsert.do", new MemberInsertController()); //등록처리
		list.put("/memberInsertForm.do", new MemberInsertFormController());//회원가입 페이지로 가는
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/memberUpdateForm.do", new MemberUpdateFormController());
		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/login.do", new LoginController());
		list.put("/loginForm.do", new LoginFormController());
		list.put("/logout.do", new LogoutController());
		
		
		list.put("/movieSelectAll.do", new MovieSelectController());
		list.put("/movieSelectAll_sec.do", new MovieSelect_secController());
		list.put("/theaterSelectAll.do", new TheaterSelectController());
		list.put("/movieBookInsert.do", new MovieBookInsertController());
		list.put("/movieSelectAll_pre.do", new MovieSelect_preController());
		list.put("/movieBookingCk.do", new MovieBookingCkController());
		list.put("/movieInfo.do", new MovieInfoController());

		
	}
	
	public FrontController() {
        super();
      
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(charset);
		String uri = request.getRequestURI(); 		   		// frontWeb/memberInsert.do
		String contextPath = request.getContextPath(); 		// frontWeb
		String path = uri.substring(contextPath.length());  // /memberInsert.do
		Controller subController = list.get(path);
		subController.execute(request, response);
	}

}
