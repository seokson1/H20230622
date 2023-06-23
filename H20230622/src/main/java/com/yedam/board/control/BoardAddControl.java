package com.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceImpl;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Controller;

public class BoardAddControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String wr = req.getParameter("writer");
		String tl = req.getParameter("title");
		String ctn = req.getParameter("content");

		if (wr.isEmpty() || tl.isEmpty() || ctn.isEmpty()) {
			req.setAttribute("errorMsg", "필수 값을 입력하세요!!");
			req.getRequestDispatcher("WEB-INF/jsp/boardForm.jsp").forward(req, resp);
		} else {

			BoardVO vo = new BoardVO();
			vo.setBrdTitle(tl);
			vo.setBrdContent(ctn);
			vo.setBrdWriter(wr);

			BoardService service = new BoardServiceImpl();
			if (service.addBoard(vo)) {
				resp.sendRedirect("boardList.do");
			} else {
				resp.sendRedirect("addBoard.do");
			}
		}

	}
}
