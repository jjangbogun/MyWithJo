package com.withJo.notice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.withJo.board.domain.BoardVo;
import com.withJo.notice.domain.NoticeVo;
import com.withJo.notice.service.NoticeService;
import com.withJo.util.FileUpload;
import com.withJo.util.Paging;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;


@RequestMapping("/notice")
@Controller
public class NoticeController {

	private Logger log = LoggerFactory.getLogger(NoticeController.class);
	private final String logTitleMsg = "==NoticeController==";
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/list")
	public String getNoticeList(@RequestParam(defaultValue = "all") String searchField,
			@RequestParam(defaultValue = "") String searchKeyword,
			@RequestParam(defaultValue = "1") int curPage, Model model) {
		log.info(logTitleMsg);
		log.info("getNoticeList");
		log.info("searchField: {}", searchField);
		log.info("searchKeyword: {}", searchKeyword);
		
		int totalCount = noticeService.noticeTotalCount(searchField, searchKeyword);
		
		log.info("totalCount: {}", totalCount);
		Paging pagingVo = new Paging(totalCount, curPage);
		
		int start = pagingVo.getPageBegin();
		int end = pagingVo.getPageEnd();
		
		
		List<NoticeVo> noticeList = noticeService.noticeSelectList(start, end, searchField, searchKeyword);
		System.out.println(noticeList);
		model.addAttribute("noticeList", noticeList);
		
		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("pagingVo", pagingVo);
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchField", searchField);
		searchMap.put("searchKeyword", searchKeyword);
		
		model.addAttribute("pagingMap", pagingMap);
		model.addAttribute("searchMap", searchMap);
		
		log.info("searchMap: {}", searchMap);
		return "notice/NoticeListView";
		
	}
	
	@GetMapping("/add")
	public String noticeAdd(Model model) {
		log.info(logTitleMsg);
		log.info("@GetMapping noticeAdd");

		return "notice/NoticeFormView";
	}
	
	@PostMapping("/add")
	public String noticeAdd(HttpServletRequest request, Model model) throws ServletException, IOException{
	    log.info(logTitleMsg);

	    try {

	    	Part filePart1;
	    	filePart1 = request.getPart("noticeImg");
			log.info("이거임filePart1: {}", filePart1.getSize());
	    	String noticeImg = "";
	    	String noticeImgName = "";
			if (filePart1.getSize() > 0) {
		    	FileUpload fileUpload = new FileUpload();
		    	noticeImg = fileUpload.getFileUpload(filePart1, noticeImgName);
			}

	    	String memberNo = request.getParameter("memberNo");
	    	String noticeTitle = request.getParameter("noticeTitle");
	    	String noticeContent = request.getParameter("noticeContent");
	    	
	    	NoticeVo noticeVo = new NoticeVo();
	    	
	    	noticeVo.setMemberNo(Integer.parseInt(memberNo));
	    	noticeVo.setNoticeTitle(noticeTitle);
	    	noticeVo.setNoticeContent(noticeContent);
	    	noticeVo.setNoticeImg(noticeImg);	
	    		  
			noticeService.noticeInsertOne(noticeVo);
	    	
		} catch (Exception e) {
			// TODO: handle exception
		}
	    
	    return "redirect:/notice/list";
	}
	
	@GetMapping("/detail")
	public String noticeDetail(@RequestParam int noticeNo, Model model) {
		log.info(logTitleMsg);
		log.info("@GetMapping noticeDetail noticeNo: {}", noticeNo);
		
		NoticeVo noticeVo = noticeService.noticeSelectOne(noticeNo);
		
		model.addAttribute("noticeVo", noticeVo);
		
		return "notice/NoticeDetailView";
	}
	
	@GetMapping("/update")
	public String noticeUpdate(@RequestParam int noticeNo, Model model) {
		log.info(logTitleMsg);
		log.info("@GetMapping noticeUpdate noticeNo: {}", noticeNo);
		
		NoticeVo noticeVo =noticeService.noticeSelectOne(noticeNo);
		
		model.addAttribute("noticeVo", noticeVo);
		
		return "notice/NoticeUpdateView";
	}
	
	@PostMapping("/update")
	public String noticeUpdate(HttpServletRequest request, Model model) throws ServletException, IOException {
	    log.info(logTitleMsg);
	    log.info("@GetMapping 체크11: {}");

	    String noticeNo = null; // noticeNo 변수를 메서드 시작 부분에서 선언

	    try {
	        // noticeNo 값을 요청에서 가져오기
	        noticeNo = request.getParameter("noticeNo");
	        if (noticeNo == null || noticeNo.isEmpty()) {
	            log.error("noticeNo가 null 또는 비어있음");
	            return "redirect:/notice/list"; // 예외 발생 시 리다이렉트
	        }

	        Part filePart1 = request.getPart("noticeImg");

	        String noticeImg = "";
	        String noticeImgName = request.getParameter("noticeImgName");
	        String noticeTitle = request.getParameter("noticeTitle");
	        String noticeContent = request.getParameter("noticeContent");
	        String noticeImgDelete = request.getParameter("noticeImgDelete");

	        log.info("@GetMapping noticeImgName: {}", noticeImgName);

	        if (filePart1.getSize() > 0) {
	            FileUpload fileUpload = new FileUpload();
	            noticeImg = fileUpload.getFileUpload(filePart1, noticeImgName);
	        } else {
	            if (Integer.parseInt(noticeImgDelete) == 0) {
	                noticeImg = noticeImgName;
	            } else {
	                log.info("noticeImgDelete: {}", noticeImgDelete);
	                FileUpload fileUpload = new FileUpload();
	                noticeImg = fileUpload.getFileDelete(noticeImgName);
	            }
	        }

	        NoticeVo noticeVo = new NoticeVo();
	        noticeVo.setNoticeNo(Integer.parseInt(noticeNo));
	        noticeVo.setNoticeTitle(noticeTitle);
	        noticeVo.setNoticeContent(noticeContent);
	        noticeVo.setNoticeImg(noticeImg);
	        log.info("@GetMapping 체크: {}", noticeVo);
	        noticeService.noticeUpdateOne(noticeVo);

	    } catch (Exception e) {
	        log.error("업데이트 중 오류 발생", e);
	        return "redirect:/notice/list"; // 예외 발생 시 리다이렉트
	    }

	    return "redirect:/notice/detail?noticeNo=" + noticeNo; // 여기서 noticeNo를 사용
	}
	
	@PostMapping("/delete")
	public String noticeDelete(@RequestParam int noticeNo) {
	    log.info("Deleting notice with ID: {}", noticeNo);
	    
	    noticeService.noticeDeleteOne(noticeNo);

	    return "redirect:/notice/list"; 
	}
	
}
