package com.withJo.notice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/list")
	public String getNoticeList(@RequestParam(defaultValue = "all") String searchField,
			@RequestParam(defaultValue = "") String searchKeyword,
			@RequestParam(defaultValue = "1") int curPage, 
			@RequestParam(required = false) Integer prevPage, Model model) {
		
	    if (prevPage != null) {
	        curPage = prevPage;
	    }
		
		int totalCount = noticeService.noticeTotalCount(searchField, searchKeyword);
		
		Paging pagingVo = new Paging(totalCount, curPage);
		
		int start = pagingVo.getPageBegin();
		int end = pagingVo.getPageEnd();
		
		
		List<NoticeVo> noticeList = noticeService.noticeSelectList(start, end, searchField, searchKeyword);
		model.addAttribute("noticeList", noticeList);
		
		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("pagingVo", pagingVo);
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchField", searchField);
		searchMap.put("searchKeyword", searchKeyword);
		
		model.addAttribute("pagingMap", pagingMap);
		model.addAttribute("searchMap", searchMap);
		model.addAttribute("curPage", curPage);
		
		return "notice/NoticeListView";
		
	}
	
	@GetMapping("/add")
	public String noticeAdd(Model model) {

		return "notice/NoticeFormView";
	}
	
	@PostMapping("/add")
	public String noticeAdd(HttpServletRequest request, Model model) throws ServletException, IOException{

	    try {

	    	Part filePart1;
	    	filePart1 = request.getPart("noticeImg");
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
	public String noticeDetail(@RequestParam int noticeNo,
			@RequestParam(required = false) Integer prevPage, Model model) {
		
		NoticeVo noticeVo = noticeService.noticeSelectOne(noticeNo);
		
		model.addAttribute("noticeVo", noticeVo);
		model.addAttribute("prevPage", prevPage);
		
		return "notice/NoticeDetailView";
	}
	
	@GetMapping("/update")
	public String noticeUpdate(@RequestParam int noticeNo, Model model) {
		
		NoticeVo noticeVo =noticeService.noticeSelectOne(noticeNo);
		
		model.addAttribute("noticeVo", noticeVo);
		
		return "notice/NoticeUpdateView";
	}
	
	@PostMapping("/update")
	public String noticeUpdate(HttpServletRequest request, Model model) throws ServletException, IOException {

	    String noticeNo = null; // noticeNo 변수를 메서드 시작 부분에서 선언

	    try {
	        // noticeNo 값을 요청에서 가져오기
	        noticeNo = request.getParameter("noticeNo");
	        if (noticeNo == null || noticeNo.isEmpty()) {
	            return "redirect:/notice/list"; // 예외 발생 시 리다이렉트
	        }

	        Part filePart1 = request.getPart("noticeImg");

	        String noticeImg = "";
	        String noticeImgName = request.getParameter("noticeImgName");
	        String noticeTitle = request.getParameter("noticeTitle");
	        String noticeContent = request.getParameter("noticeContent");
	        String noticeImgDelete = request.getParameter("noticeImgDelete");


	        if (filePart1.getSize() > 0) {
	            FileUpload fileUpload = new FileUpload();
	            noticeImg = fileUpload.getFileUpload(filePart1, noticeImgName);
	        } else {
	            if (Integer.parseInt(noticeImgDelete) == 0) {
	                noticeImg = noticeImgName;
	            } else {
	                FileUpload fileUpload = new FileUpload();
	                noticeImg = fileUpload.getFileDelete(noticeImgName);
	            }
	        }

	        NoticeVo noticeVo = new NoticeVo();
	        noticeVo.setNoticeNo(Integer.parseInt(noticeNo));
	        noticeVo.setNoticeTitle(noticeTitle);
	        noticeVo.setNoticeContent(noticeContent);
	        noticeVo.setNoticeImg(noticeImg);

	        noticeService.noticeUpdateOne(noticeVo);

	    } catch (Exception e) {

	        return "redirect:/notice/list"; // 예외 발생 시 리다이렉트
	    }

	    return "redirect:/notice/detail?noticeNo=" + noticeNo; // 여기서 noticeNo를 사용
	}
	
	@PostMapping("/delete")
	public String noticeDelete(@RequestParam int noticeNo) {
	    
	    noticeService.noticeDeleteOne(noticeNo);

	    return "redirect:/notice/list"; 
	}
	
}
