package com.withJo.member.controller;

// test

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.withJo.member.domain.MemberVo;
import com.withJo.member.service.MemberService;
import com.withJo.util.Paging;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/member")
@Controller
public class MemberController {
	
	private Logger log = LoggerFactory.getLogger(MemberController.class);
	private final String logTitleMsg = "==MemberController==";
	
	@Autowired
	private MemberService memberService;
	
	// 회원 리스트
	@GetMapping("/list")
	public String getMemberList(@RequestParam(defaultValue = "all") String searchField, 
			@RequestParam(defaultValue = "") String searchKeyword,
			@RequestParam(defaultValue = "1") int curPage, Model model, HttpSession session) {
		
		// 세션에서 로그인한 사용자 정보 가져오기
	    MemberVo loggedInMember = (MemberVo) session.getAttribute("memberVo");
	    
	    // 로그인 상태 및 관리자 권한 확인
	    if (loggedInMember == null || loggedInMember.getAuthority() != 1) {
	        // 로그인하지 않았거나 관리자가 아닌 경우
	        return "redirect:/member/login"; // 로그인 페이지로 리다이렉트
	    }
		
		log.info(logTitleMsg);
		log.info("getMemberList");
		log.info("searchField: {}", searchField);
		log.info("searchKeyword: {}", searchKeyword);
		
		int totalCount = memberService.memberTotalCount(searchField, searchKeyword);
		
		log.info("totalCount: {}", totalCount);
		Paging pagingVo = new Paging(totalCount, curPage);
		
		int start = pagingVo.getPageBegin();
		int end = pagingVo.getPageEnd();
		
		List<MemberVo> memberList = memberService.memberSelectList(start, end, searchField, searchKeyword);
		System.out.println(memberList);
		model.addAttribute("memberList", memberList);
		
		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("pagingVo", pagingVo);
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchField", searchField);
		searchMap.put("searchKeyword", searchKeyword);
		
		model.addAttribute("pagingMap", pagingMap);
		model.addAttribute("searchMap", searchMap);
		
		log.info("searchMap: {}", searchMap);
		return "member/MemberListView";					
	}
	
	// 회원 상세 페이지
	@GetMapping("/detail")
	public String memberDetail(@RequestParam int memberNo, Model model) {
		log.info(logTitleMsg);
		log.info("@GetMapping memberDetail memberNo: {}", memberNo);
		
		MemberVo memberVo = memberService.memberSelectOne(memberNo);
		
		model.addAttribute("memberVo", memberVo);
		
		return "member/MemberDetailView";
	}
	
	// 회원 정보 수정
	@PostMapping("/detail")
	@ResponseBody
	public ResponseEntity<?> memberDetail(@RequestBody MemberVo memberVo) {
	    log.info(logTitleMsg);
	    log.info("@PostMapping memberDetail memberVo: {}", memberVo);
	    log.info("memberNo: {}", memberVo.getMemberNo());

	    if (memberVo.getMemberNo() != 0) {
	        try {
	            memberService.memberUpdateOne(memberVo);
	            return ResponseEntity.ok().body("{\"message\": \"회원 정보가 성공적으로 업데이트되었습니다.\"}");
	        } catch (Exception e) {
	            log.error("Error updating member", e);
	            return ResponseEntity.badRequest().body("{\"error\": \"회원 정보 업데이트 중 오류가 발생했습니다.\"}");
	        }
	    } else {
	        log.error("Invalid memberNo: 0");
	        return ResponseEntity.badRequest().body("{\"error\": \"유효하지 않은 회원 번호입니다.\"}");
	    }
	}
	
	// (관리자) 회원 삭제
	@PostMapping("/delete")
	@ResponseBody
	public String memberDelete(@RequestParam int memberNo, HttpSession session) {
		MemberVo loggedInMember = (MemberVo) session.getAttribute("memberVo");
		
		if (loggedInMember == null || loggedInMember.getAuthority() != 1) {
	        return "unauthorized";
	    }
	    
	    try {
	        memberService.memberDeleteOne(memberNo);
	        return "success";
	    } catch (Exception e) {
	        return "fail";
	    }
	}
	
	// 로그인 화면
	@GetMapping("/login")
	public String login(HttpSession session, Model model) {
		log.info(logTitleMsg);
		log.info("login");
		
		return "member/MemberLoginView";		
	}	
	
	// 로그인 회원정보 조회 및 검증
	@PostMapping("/login")
	@ResponseBody
	public Map<String, Object> getLogin(@RequestBody MemberVo membervo, HttpSession session) {
	    log.info("MemberController getLogin" + membervo);        
	    
	    MemberVo memberVo = memberService.memberExist(membervo);
	    
	    Map<String, Object> response = new HashMap<>();
	    
	    if(memberVo != null) {
	        session.setAttribute("memberVo", memberVo);
	        response.put("success", true);
	    } else {
	        response.put("success", false);
	    }        
	    
	    return response;
	}
	
	// 로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session, Model model) {
		log.info(logTitleMsg);
		log.info("logout");
		
		session.invalidate();
		
		String viewUrl = "redirect:/";
		
		return viewUrl;
		
	}
	
	// 회원가입 페이지
	@GetMapping("/add")
	public String memberAdd(Model model) {
		log.info(logTitleMsg);
		log.info("@GetMapping memberAdd");
		
		return "member/MemberAddView";
	}
	
	
	// 회원가입 DB 연동
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<?> memberAdd(@RequestBody MemberVo memberVo) {
	    log.info(logTitleMsg);
	    log.info("@PostMapping memberAdd: {}", memberVo);

	    String birthDateStr = memberVo.getMemberBirthDate();
	    
	    // 성별 유효성 검사
	    if (memberVo.getMemberGender() != 1 && memberVo.getMemberGender() != 2) {
	        return ResponseEntity.badRequest().body("{\"error\": \"올바른 성별을 선택해주세요.\"}");
	    }

	    if (birthDateStr != null && birthDateStr.length() == 8) {
	        try {
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	            dateFormat.setLenient(false);
	            dateFormat.parse(birthDateStr);
	        } catch (ParseException e) {
	            log.error("Error parsing birth date", e);
	            return ResponseEntity.badRequest().body("{\"error\": \"생년월일 형식이 올바르지 않습니다.\"}");
	        }
	    } else if (birthDateStr != null) {
	        return ResponseEntity.badRequest().body("{\"error\": \"생년월일 형식이 올바르지 않습니다.\"}");
	    }
	    
	    

	    try {
	        memberService.memberInsertOne(memberVo);
	        return ResponseEntity.ok().body("{\"message\": \"회원가입이 완료되었습니다.\"}");
	    } catch (Exception e) {
	        log.error("Error during member registration", e);
	        return ResponseEntity.badRequest().body("{\"error\": \"회원가입 중 오류가 발생했습니다.\"}");
	    }
	}
	
	// ID 중복검사
	@PostMapping("/checkId")
	@ResponseBody
	public Map<String, Boolean> checkId(@RequestParam String memberId) {
	    boolean isDuplicate = memberService.isDuplicateId(memberId); // 서비스에서 중복 검사 로직 수행
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("isDuplicate", isDuplicate);
	    return response;
	}
	
	// 마이페이지 수정
	@GetMapping("/update")
	public String showUpdateForm(@RequestParam("memberNo") int memberNo, Model model) {
	    log.info(logTitleMsg);
	    log.info("GetMapping showUpdateForm memberNo: {}", memberNo);
	    
	    if (memberNo != 0) {
	        MemberVo memberVo = memberService.memberSelectOne(memberNo);
	        if (memberVo != null) {
	            model.addAttribute("memberVo", memberVo);
	        } else {
	            log.error("Member not found for memberNo: {}", memberNo);
	            return "redirect:/error";
	        }
	    } else {
	        log.error("Invalid memberNo: 0");
	        return "redirect:/error";
	    }
	    
	    return "member/MemberUpdateView";
	}
	
	// 마에페이지 수정
	@PostMapping(value = "/update")
	@ResponseBody
	public ResponseEntity<?> memberMyPage(@RequestBody MemberVo memberVo) {
	    log.info(logTitleMsg);
	    log.info("@PostMapping memberMyPage memberVo: {}", memberVo);
	    log.info("memberNo: {}", memberVo.getMemberNo());

	    if (memberVo.getMemberNo() != 0) {
	        try {
	            memberService.memberUpdateOne(memberVo);
	            return ResponseEntity.ok().body("{\"message\": \"회원 정보가 성공적으로 업데이트되었습니다.\"}");
	        } catch (Exception e) {
	            log.error("Error updating member", e);
	            return ResponseEntity.badRequest().body("{\"error\": \"회원 정보 업데이트 중 오류가 발생했습니다.\"}");
	        }
	    } else {
	        log.error("Invalid memberNo: 0");
	        return ResponseEntity.badRequest().body("{\"error\": \"유효하지 않은 회원 번호입니다.\"}");
	    }
	}
	
	// 아이디 찾기
	@PostMapping("/findId")
	@ResponseBody
	public ResponseEntity<?> memberIdFind(@RequestBody Map<String, String> payload){
		String memberName = payload.get("memberName");
		
		if (memberName == null || memberName.trim().isEmpty()) {
	        return ResponseEntity.badRequest().body("{\"error\": \"이름을 입력해주세요.\"}");
	    }

	    try {
	        String foundId = memberService.memberFindIdByName(memberName);
	        if (foundId != null) {
	            return ResponseEntity.ok().body("{\"success\": true, \"memberId\": \"" + foundId + "\"}");
	        } else {
	            return ResponseEntity.ok().body("{\"success\": false, \"message\": \"일치하는 정보가 없습니다.\"}");
	        }
	    } catch (Exception e) {
	        log.error("Error finding ID", e);
	        return ResponseEntity.badRequest().body("{\"error\": \"아이디 찾기 중 오류가 발생했습니다.\"}");
	    }
	}

	}
	
	
	
	
	


