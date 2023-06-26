package com.yedam.member.control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Controller;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class AddMemberControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 생성자: 1) 요청정보 2) 저장경로 3) 최대파일크기 4)인코딩 5) 리네임정책.
		String savePath = req.getServletContext().getRealPath("/images");
		int maxSize = 1024 * 1024 * 10;
		String enc = "UTF-8";
		
		MultipartRequest multi = 
				new MultipartRequest(req, savePath, maxSize, enc, new DefaultFileRenamePolicy());
		
		String id = multi.getParameter("uid");
		String pw = multi.getParameter("upw");
		String nm = multi.getParameter("uname");
		String bth = multi.getParameter("ubirth");
		String img = multi.getFilesystemName("img");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		MemberVO vo = new MemberVO();
		vo.setUserId(id);
		vo.setUserPw(pw);
		vo.setUserName(nm);
		try {
			vo.setUserBirth(sdf.parse(bth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		vo.setUserImg(img);
		
		// service > serviceImpl
		// mapper, mapper.xml
		MemberService service = new MemberServiceImpl();
		
		if(service.addMember(vo)) {
			resp.sendRedirect("boardList.do");
		} else {
			resp.sendRedirect("memberJoinForm.do");
		}
		
	}

}
