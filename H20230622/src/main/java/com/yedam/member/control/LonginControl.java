package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Controller;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class LonginControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String id = req.getParameter("uid");
		String pw = req.getParameter("upw");
		MemberService service = new MemberServiceImpl();
		MemberVO member = service.login(id, pw);
		if(member != null) { // 로그인 성공
			session.setAttribute("loginId", member.getUserId()); // 로그인 아이디
			session.setAttribute("loginName", member.getUserName()); // 로그인 사용자 이름 페이지 넘어가도 그대로 유지
			resp.sendRedirect("boardList.do"); // 게시판 목록
		} else {
			resp.sendRedirect("memberloginForm.do"); // 로그인 화면.
		}
		
	}

}
