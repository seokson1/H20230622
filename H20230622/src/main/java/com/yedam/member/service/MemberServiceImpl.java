package com.yedam.member.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.member.persistence.MemberMapper;
import com.yedam.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	SqlSession session = DataSource.getInstance().openSession(true);
	MemberMapper mapper = session.getMapper(MemberMapper.class);
	
	@Override
	public MemberVO login(String id, String pw) {
		MemberVO vo = new MemberVO();
		vo.setUserId(id);
		vo.setUserPw(pw);
		System.out.println(vo);
		return mapper.login(vo);
	}

	@Override
	public boolean addMember(MemberVO member) {
		return mapper.insert(member) == 1;
	}

	@Override
	public MemberVO info(String id) {
		MemberVO vo = new MemberVO();
		vo.setUserId(id);
		
		return mapper.info(vo);
	}

	@Override
	public boolean update(MemberVO member) {
		
		return mapper.update(member) ==1 ;
	}

}
