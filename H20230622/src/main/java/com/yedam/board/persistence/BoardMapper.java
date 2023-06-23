package com.yedam.board.persistence;

import java.util.List;

import com.yedam.board.vo.BoardVO;

public interface BoardMapper {
	public List<BoardVO> boardList(int page);
	
	public BoardVO selectBoard(long bno);
}
