package com.withJo.member.service;

import java.util.List;

import com.withJo.course.domain.CourseVo;
import com.withJo.member.domain.MemberVo;

public interface MemberService {
	
	List<MemberVo> memberSelectList(int start, int end, String searchField, String searchKeyword);
	public int memberTotalCount(String searchField, String searchKeyword); 
	public MemberVo memberExist(MemberVo memberVo);
	public int memberInsertOne(MemberVo memberVo);
	public MemberVo memberSelectOne(int no);
	public int memberUpdateOne(MemberVo memberVo);
	public boolean isDuplicateId(String memberId);
	public int memberDeleteOne(int memberNo);
	public String memberFindIdByName(String memberName);
	public String memberPwUpdate(String memberName, String memberId);
	List<MemberVo> memberReserveOne(int memberNo);	
	public int memberReserveCancel(int memberCourseReserveNo, int memberNo, int courseCost);	
	List<MemberVo> memberEMoneyDetail(int memberNo);
	List<String> memberReserveCourseDay(int courseNo);
	List<MemberVo> memberShoppingCartOne(int memberNo);
	public int membershoppingCartCancel(int memberNo, int memberShoppingCartNo);
	public MemberVo getMemberReserveOne(int memberNo, int memberCourseReserveNo);
}
