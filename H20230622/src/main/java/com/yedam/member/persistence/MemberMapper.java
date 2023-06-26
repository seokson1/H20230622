package com.yedam.member.persistence;

import org.apache.ibatis.annotations.Param;

import com.yedam.member.vo.MemberVO;

public interface MemberMapper {
	
	public MemberVO login(MemberVO member);
	
	//public MemberVO login1(@Param("id)") String id, @Param("pw") String pw); 따로 선언하지 않고 바로 됨.
	// ex)
	
	public int insert(MemberVO member);
	
	public MemberVO info(MemberVO member);
	
	public int update(MemberVO member);
}
