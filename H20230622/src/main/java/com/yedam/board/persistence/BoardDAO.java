package com.yedam.board.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.board.vo.BoardVO;
import com.yedam.common.DAO;

public class BoardDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	private void close() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 목록, 단건조회, 등록, 수정, 삭제
	public List<BoardVO> boardList() {
		List<BoardVO> list = new ArrayList();
		conn = DAO.getConnect();
		sql = "select * from tbl_board order by brd_no desc";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBrdTitle(rs.getString("brd_title"));
				vo.setBrdNo(rs.getInt("brd_no"));
				vo.setBrdWriter(rs.getString("brd_writer"));
				vo.setBrdContent(rs.getString("brd_content"));
				vo.setCreateDate(rs.getDate("create_date"));
				vo.setClickCnt(rs.getInt("click_cnt"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}

	// 등록
	public boolean insertBoard(BoardVO vo) {
		conn = DAO.getConnect();
		sql = "insert into tbl_board (brd_no, brd_title, brd_writer, brd_content)" + " values(board_seq.nextval,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			// psmt.setLong(1, vo.getBrdNo());
			psmt.setString(1, vo.getBrdTitle());
			psmt.setString(2, vo.getBrdWriter());
			psmt.setString(3, vo.getBrdContent());

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	// 수정
	public boolean updateBoard(BoardVO vo) {
		conn = DAO.getConnect();
		sql = "update tbl_board set brd_title=? , brd_content=? where brd_no = ?";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getBrdTitle());
			psmt.setString(2, vo.getBrdContent());
			psmt.setLong(3, vo.getBrdNo());
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	public boolean deleteBoard(long brdNo) {
		conn = DAO.getConnect();
		sql = "delete from tbl_board  where brd_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, brdNo);

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	// 단건조회
	public BoardVO selectBoard(long brdNo) {
		List<BoardVO> list = new ArrayList();
		conn = DAO.getConnect();
		sql = "select * from tbl_board where brd_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, brdNo);
			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBrdTitle(rs.getString("brd_title"));
				vo.setBrdNo(rs.getInt("brd_no"));
				vo.setBrdWriter(rs.getString("brd_writer"));
				vo.setBrdContent(rs.getString("brd_content"));
				vo.setCreateDate(rs.getDate("create_date"));
				vo.setClickCnt(rs.getInt("click_cnt"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	// 조회수 증가
	public void clickCount(long brdNo) {
		sql = "update tbl_board set click_cnt=click_cnt+1 where brd_no = ?";
		conn = DAO.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, brdNo);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public List<BoardVO> boardListPaging(int page) {
		List<BoardVO> list = new ArrayList();
		conn = DAO.getConnect();
		sql = "select *\r\n" + "from(\r\n" + "    select rownum rn, a.*\r\n" + "    from(\r\n" + "         select *\r\n"
				+ "         from tbl_board order by brd_no desc\r\n" + "            ) a\r\n" + "         )b\r\n"
				+ "where b.rn > (? -1 ) * 10\r\n" + "and b.rn <=  ? * 10";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, page);
			psmt.setInt(2, page);

			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBrdTitle(rs.getString("brd_title"));
				vo.setBrdNo(rs.getInt("brd_no"));
				vo.setBrdWriter(rs.getString("brd_writer"));
				vo.setBrdContent(rs.getString("brd_content"));
				vo.setCreateDate(rs.getDate("create_date"));
				vo.setClickCnt(rs.getInt("click_cnt"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}

	// 전체건수 계산
	public int getTotalCnt() {
		conn = DAO.getConnect();
		sql = "select count(1) from tbl_board";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			int cnt = rs.getInt(1);
			return cnt;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}
}
