package com.yedam.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.board.persistence.BoardMapper;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.DataSource;

public class BoardServiceMybatis implements BoardService{

	// SqlSessionFactory 객체
	SqlSession session = DataSource.getInstance().openSession();
	BoardMapper mapper = session.getMapper(BoardMapper.class);
	
	@Override
	public boolean addBoard(BoardVO vo) {
		return false;
	}

	@Override
	public BoardVO getBoard(long brdNo) {
		return mapper.selectBoard(brdNo);
	}

	@Override
	public boolean editBoard(BoardVO vo) {
		return false;
	}

	@Override
	public boolean delBoard(long brdNo) {
		return false;
	}

	@Override
	public List<BoardVO> list(int page) {
//		return session.selectList("com.yedam.board.persistence.BoardMapper.boardList"); //mappe.id
		return mapper.boardList(page);
	}

	@Override
	public int totalCnt() {
		return 0;
	}

}
