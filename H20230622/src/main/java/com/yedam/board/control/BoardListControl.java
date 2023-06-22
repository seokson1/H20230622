package com.yedam.board.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceImpl;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Controller;

public class BoardListControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BoardService service = new BoardServiceImpl();
		List<BoardVO> list = service.list();
		
		req.setAttribute("list", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp");
		rd.forward(req, resp);

	}

}
