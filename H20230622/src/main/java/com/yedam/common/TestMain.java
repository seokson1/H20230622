package com.yedam.common;

import java.util.List;

import com.yedam.board.persistence.BoardDAO;
import com.yedam.board.vo.BoardVO;

public class TestMain {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		
		BoardVO brd = new BoardVO();
		brd.setBrdContent("내용테스트입니다.21");
		brd.setBrdWriter("작성자");
		brd.setBrdTitle("제목테스트21");
		brd.setBrdNo(29);
		
		if(dao.selectBoard(brd.getBrdNo()) != null) {
			System.out.println(brd.toString());
		} else {
			System.out.println("조회 실패");
		}
		
//		if(dao.daleteBoard(brd.getBrdNo())) {
//			System.out.println("삭제성공");
//		}
//		
//		if(dao.updateBoard(brd)) {
//			System.out.println("입력성공");
//		} else {
//			System.out.println("입력 실패");
//		}
		
		List<BoardVO> list = dao.boardList();
		for(BoardVO vo : list) {
			System.out.println(vo.toString());
		}
	}

}
