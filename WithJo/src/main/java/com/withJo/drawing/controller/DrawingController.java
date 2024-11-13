package com.withJo.drawing.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.withJo.drawing.domain.DrawingVo;
import com.withJo.drawing.service.DrawingService;
import com.withJo.util.Paging;

import jakarta.servlet.ServletException;


@RequestMapping("/drawing")
@Controller
public class DrawingController {
	
	@Autowired
	private DrawingService drawingService;
	
	@GetMapping("/list")
	public String getDrawingList(@RequestParam(defaultValue = "all") String searchField,
			@RequestParam(defaultValue = "") String searchKeyword,
			@RequestParam(defaultValue = "1") int curPage,
			@RequestParam(required = false) Integer prevPage, Model model) {
		
	    if (prevPage != null) {
	        curPage = prevPage;
	    }
		
		int totalCount = drawingService.drawingTotalCount(searchField, searchKeyword);
		
		Paging pagingVo = new Paging(totalCount, curPage);
		
		int start = pagingVo.getPageBegin();
		int end = pagingVo.getPageEnd();		
		
		List<DrawingVo> drawingList = drawingService.drawingSelectList(start, end, searchField, searchKeyword);
		System.out.println(drawingList);
		model.addAttribute("drawingList", drawingList);
		
		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("pagingVo", pagingVo);
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchField", searchField);
		searchMap.put("searchKeyword", searchKeyword);
		
		model.addAttribute("pagingMap", pagingMap);
		model.addAttribute("searchMap", searchMap);
		model.addAttribute("curPage", curPage);
		
		return "drawing/DrawingListView";
		
	}
	
	@GetMapping("/add")
	public String drawingAdd(Model model) {

		return "drawing/DrawingFormView";
	}
	
	@PostMapping("/add")
	public String drawingAdd(@RequestBody DrawingVo drawingVo) {
	    
	    drawingService.drawingInsertOne(drawingVo);

	    return "redirect:/drawing/list";
	}
	
	@PostMapping("/make")
	@ResponseBody
	public ResponseEntity<?> drawingAdd(@RequestParam(required = true) String boardStartDate,
										@RequestParam(required = true) String boardEndDate, 
	                                    @RequestParam(required = true) Integer personnel) 
	                                    throws ServletException, IOException {
	     
	    List<Map<String, Object>> selectedMembers = drawingService.drawingSelect(boardStartDate, boardEndDate, personnel);

	    Map<String, Object> response = new HashMap<>();
	    response.put("selectedMembers", selectedMembers);
	    
	    return ResponseEntity.ok(response);
	}
	
	@GetMapping("/detail")
	public String drawingDetail(@RequestParam int drawingNo,
			@RequestParam(required = false) Integer prevPage, Model model) {
		
		DrawingVo drawingVo = drawingService.drawingSelectOne(drawingNo);
		
		model.addAttribute("drawingVo", drawingVo);
		model.addAttribute("prevPage", prevPage);
		
		return "drawing/DrawingDetailView";
	}
	
	@PostMapping("/emoney")
	public ResponseEntity<?> drawingEmoney(@RequestBody Map<String, Object> payload) {
	    
	    Map<String, String> resultMap = new HashMap<>();
	    
	    int eMoney = (int) payload.get("eMoney");
	    int round = (int) payload.get("round");
	    
	    String detail = round + "회차 게시판 이벤트 보상입니다.";
	    
	    ArrayList<Integer> memberNos = (ArrayList<Integer>) payload.get("memberNos");

	    for (Integer memberNo : memberNos) {
	    	drawingService.drawingInsertEMoney(eMoney, (int) memberNo , detail);
		}

	    return ResponseEntity.ok().body(resultMap);
	}

	@PostMapping("/delete")
	public String drawingDelete(@RequestParam int drawingNo) {
	    
	    drawingService.drawingDeleteOne(drawingNo);

	    return "redirect:/drawing/list"; 
	}
	
}
