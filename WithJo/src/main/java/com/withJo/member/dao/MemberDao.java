package com.withJo.member.dao;

import java.util.List;
import java.util.Map;

import com.withJo.course.domain.CourseVo;
import com.withJo.member.domain.MemberVo;

public interface MemberDao {
	
	List<MemberVo> memberSelectList(int start, int end, String searchField, String searchKeyword);
	public int memberTotalCount(String searchField, String searchKeyword);	
	
	public MemberVo memberExist(MemberVo memberVo);
	public abstract int memberInsertOne(MemberVo memberVo);
	public MemberVo memberSelectOne(int no);
	public int memberUpdateOne(MemberVo memberVo);
	
	public int countByMemberId(String memberId);
	public int memberDeleteOne(int memberNo);
	
	public String memberFindIdByName(String memberName);
	public MemberVo memberFindByNameAndId(String memberName, String memberId);
    public int memberPwUpdate(String memberId, String newPassword, String memberName);
    
    List<MemberVo> memberReserveOne(int memberNo);
    List<String> memberReserveCourseDay(int courseNo);
    
    public int memberCourseReserveNo(int memberCourseReserveNo, int memberNo);    
    public int memberRefund(Map<String, Object> refundParams);
	List<MemberVo> memberEMoneyDetail(int memberNo);
	
	List<MemberVo> memberShoppingCartOne(int memberNo);
	public int membershoppingCartCancel(int memberNo, int memberShoppingCartNo);
	public MemberVo getMemberReserveOne(int memberNo, int memberCourseReserveNo);

	
}
