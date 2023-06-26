package com.yedam;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.control.BoardAddControl;
import com.yedam.board.control.BoardFormControl;
import com.yedam.board.control.BoardListControl;
import com.yedam.board.control.BoardModifyControl;
import com.yedam.board.control.BoardModifyFormControl;
import com.yedam.board.control.BoardRemoveControl;
import com.yedam.board.control.BoardSerarchContorl;
import com.yedam.common.Controller;
import com.yedam.member.control.AddMemberControl;
import com.yedam.member.control.LoginFormControl;
import com.yedam.member.control.LogoutControl;
import com.yedam.member.control.LonginControl;
import com.yedam.member.control.MemberInfoControl;
import com.yedam.member.control.MemberJoinForm;
import com.yedam.member.control.ModifyMemberControl;

public class FrontContrller extends HttpServlet {
	String enc;
	HashMap<String, Controller> menu;
	
	public FrontContrller() {
		menu = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		enc = config.getInitParameter("charset"); // UTF-8 web-xml. 가져오기.
		
		//게시판
		System.out.println("init.");
		menu.put("/main.do", new MainControl());
		menu.put("/boardList.do", new BoardListControl());
		menu.put("/boardForm.do", new BoardFormControl());
		menu.put("/addBoard.do", new BoardAddControl());
		menu.put("/getBoard.do",new BoardSerarchContorl());
		menu.put("/modifyForm.do", new BoardModifyFormControl());
		menu.put("/boardModify.do", new BoardModifyControl());
		menu.put("/boardRemove.do", new BoardRemoveControl());
		
		//회원관리
		menu.put("/memberloginForm.do", new LoginFormControl());
		menu.put("/memberlogin.do", new LonginControl()); // 로그인 화면
		menu.put("/memberlogout.do", new LogoutControl()); // 로그인 처리
		menu.put("/membre.do", new MemberControl()); //로그아웃 처리
		menu.put("/memberJoinForm.do", new MemberJoinForm());
		menu.put("/addMember.do", new AddMemberControl());
		menu.put("/memberInfo.do", new MemberInfoControl());
		menu.put("/modifyMember.do", new ModifyMemberControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding(enc);
		
		String uri = req.getRequestURI();
		String cpath = req.getContextPath(); // application 이름.
		String path = uri.substring(cpath.length());
		System.out.println("uri: " + uri);
		System.out.println("cpath: " + cpath);
		System.out.println("path: " + path);
		
		Controller msg = menu.get(path); // url pattern - 실행. 연결 시키는 기능 여기서 시작.
		msg.exec(req, resp);
		
	}

}
