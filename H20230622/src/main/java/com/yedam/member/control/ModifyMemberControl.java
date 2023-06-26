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

public class ModifyMemberControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String id = req.getParameter("id");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");
		// 아이디 주소 연락처 파라미터 넘기 이쪽으로 / 받아 db 업데이트 기능

		// service / mapper / jsp 전송
		// modifyMembe / update /게시글 목록. 이동 -> 보여지는 페이지

		MemberService service = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		member.setUserId(id);
		member.setUserPhone(phone);
		member.setUserAddr(addr);
		System.out.println(id + " " + phone + " " + addr);
		System.out.println(member);
//		
		
		//service.update(member);

		if (service.update(member) ) {
			resp.sendRedirect("boardList.do");
		}else {
			
		}
	}

}
