package com.withJo.member.service;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withJo.member.dao.MemberDao;
import com.withJo.member.domain.MemberVo;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	public MemberDao memberDao;

	@Override
	public List<MemberVo> memberSelectList(int start, int end, String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		return memberDao.memberSelectList(start, end, searchField, searchKeyword);
	}

	@Override
	public int memberTotalCount(String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		return memberDao.memberTotalCount(searchField, searchKeyword);
	}

	@Override
	public MemberVo memberExist(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return memberDao.memberExist(memberVo);
	}

	@Override
	public int memberInsertOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return memberDao.memberInsertOne(memberVo);
	}

	@Override
	public MemberVo memberSelectOne(int no) {
		// TODO Auto-generated method stub
		return memberDao.memberSelectOne(no);
	}

	@Override
	public int memberUpdateOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return memberDao.memberUpdateOne(memberVo);
	}

	@Override
	public boolean isDuplicateId(String memberId) {
		// TODO Auto-generated method stub
		return memberDao.countByMemberId(memberId) > 0;
	}

	@Override
	public int memberDeleteOne(int memberNo) {
		// TODO Auto-generated method stub
		
        return memberDao.memberDeleteOne(memberNo);
    }

	@Override
	public String memberFindIdByName(String memberName) {
		// TODO Auto-generated method stub
		return memberDao.memberFindIdByName(memberName);
	}

	@Override
    public String memberPwUpdate(String memberName, String memberId) {
        MemberVo member = memberDao.memberFindByNameAndId(memberName, memberId);
        if (member != null) {
            String newPassword = memberNewPw(8);
            int result = memberDao.memberPwUpdate(memberId, newPassword, memberName);
            if (result > 0) {
                return newPassword;
            }
        }
        return null;
    }
	
	// 비밀번호 찾기 시 랜덤 비밀번호 증정
	private String memberNewPw(int length) {
		String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String combineChar = upperLetters + lowerLetters + numbers;
		
		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder(length);
		
		password.append(upperLetters.charAt(random.nextInt(upperLetters.length())));
	    password.append(lowerLetters.charAt(random.nextInt(lowerLetters.length())));
	    password.append(numbers.charAt(random.nextInt(numbers.length())));

	    // 나머지 문자 생성
	    for (int i = 3; i < length; i++) {
	        password.append(combineChar.charAt(random.nextInt(combineChar.length())));
	    }

	    // 문자열 섞기
	    char[] passwordArray = password.toString().toCharArray();
	    for (int i = passwordArray.length - 1; i > 0; i--) {
	        int index = random.nextInt(i + 1);
	        char temp = passwordArray[index];
	        passwordArray[index] = passwordArray[i];
	        passwordArray[i] = temp;
	    }

	    return new String(passwordArray);
	}
	

}
