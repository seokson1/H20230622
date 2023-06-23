package com.yedam.common;

import java.util.List;

import com.yedam.board.persistence.BoardDAO;
import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;

public class TestMain {

	public static void main(String[] args) {
		BoardService service = new BoardServiceMybatis();
		BoardVO vo = new BoardVO();
		
	
		vo.setBrdTitle("fljslfsklfjs");
		vo.setBrdWriter("fsffsadfsf");
		vo.setBrdContent("afdsfsfdsfsafddsfasf 추가한 내용.");
		
		System.out.println(service.addBoard(vo));
		
	}

}
