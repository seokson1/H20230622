package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Controller;

public class LogoutControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
//		session.removeAttribute("login"); 
//		session.removeAttribute("loginName"); 
		session.invalidate(); // 세션객체 삭제.
		
		resp.sendRedirect("memberloginForm.do");
		
	}

}
