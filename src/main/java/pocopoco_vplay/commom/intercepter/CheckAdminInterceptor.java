package pocopoco_vplay.commom.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pocopoco_vplay.users.model.vo.Users;

public class CheckAdminInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Users loginUser = (Users)request.getSession().getAttribute("loginUser");
		if(loginUser == null || loginUser.getIsAdmin().equals("N")) {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().write("<script>alert('접근 권한이 없습니다'); location.href='/';</script>");
			return false;
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
