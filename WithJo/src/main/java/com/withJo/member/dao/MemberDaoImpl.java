package com.withJo.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;
import org.aspectj.weaver.IntMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.withJo.course.domain.CourseVo;
import com.withJo.member.domain.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	String namespace = "com.withJo.member.";

	@Override
	public List<MemberVo> memberSelectList(int start, int end, String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("searchField", searchField);
		map.put("searchKeyword", searchKeyword);
		return sqlSession.selectList(namespace + "memberSelectList", map) ;
	}

	@Override
	public int memberTotalCount(String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("searchField", searchField);
		map.put("searchKeyword", searchKeyword);
		return sqlSession.selectOne(namespace + "memberTotalCount", map);
	}

	@Override
	public MemberVo memberExist(MemberVo memberVo) {
		// TODO Auto-generated method stub		
		
		return sqlSession.selectOne(namespace + "memberExist", memberVo);
	}

	@Override
	public int memberInsertOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "memberInsertOne", memberVo);
	}

	@Override
	public MemberVo memberSelectOne(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "memberSelectOne", no);
	}

	@Override
	public int memberUpdateOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "memberUpdateOne", memberVo);
	}

	@Override
	public int countByMemberId(String memberId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "countByMemberId", memberId);
	}

	@Override
	public int memberDeleteOne(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + "memberDeleteOne", memberNo);
	}

	@Override
	public String memberFindIdByName(String memberName) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "memberFindIdByName", memberName);
	}

	@Override
    public MemberVo memberFindByNameAndId(String memberName, String memberId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("memberName", memberName);
        paramMap.put("memberId", memberId);
        return sqlSession.selectOne(namespace + "memberFindByNameAndId", paramMap);
    }

    @Override
    public int memberPwUpdate(String memberId, String newPassword, String memberName) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("memberId", memberId != null ? memberId : "");
        paramMap.put("memberPw", newPassword != null ? newPassword : "");
        paramMap.put("memberName", memberName != null ? memberName : "");
        return sqlSession.update(namespace + "memberPwUpdate", paramMap);
    }

	@Override
	public List<MemberVo> memberReserveOne(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "memberReserveOne", memberNo);
	}

	@Override
	public int memberCourseReserveNo(int memberCourseReserveNo, int memberNo) {
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("memberCourseReserveNo", memberCourseReserveNo);
	    paramMap.put("memberNo", memberNo);
	    
	    return sqlSession.delete(namespace + "memberCourseReserveNo", paramMap);
	}

	@Override
	public int memberRefund(Map<String, Object> refundParams) {
	    return sqlSession.insert(namespace + "memberRefund", refundParams);
	}

	@Override
	public List<MemberVo> memberEMoneyDetail(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "memberEMoneyDetail", memberNo);
	}

	@Override
	public List<String> memberReserveCourseDay(int courseNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "memberReserveCourseDay", courseNo);
	}
	

	@Override
	public List<MemberVo> memberShoppingCartOne(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "memberShoppingCartOne", memberNo);
	}

	@Override
	public int membershoppingCartCancel(int memberNo, int memberShoppingCartNo) {
		// TODO Auto-generated method stub
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("memberNo", memberNo);
		paramMap.put("memberShoppingCartNo", memberShoppingCartNo);
		
		
		return sqlSession.delete(namespace + "membershoppingCartCancel", paramMap);
	}

	@Override
	public MemberVo getMemberReserveOne(int memberNo, int memberCourseReserveNo) {
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("memberNo", memberNo);
	    paramMap.put("memberCourseReserveNo", memberCourseReserveNo);
	    List<MemberVo> results = sqlSession.selectList(namespace + "memberReserveOne", paramMap);
	    if (results.isEmpty()) {
	        return null;
	    } else if (results.size() > 1) {	       
	    }
	    return results.get(0);
	}

}
