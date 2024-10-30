package com.withJo.lotto.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.withJo.board.domain.BoardVo;
import com.withJo.board.service.BoardService;
import com.withJo.comments.domain.CommentsVo;
import com.withJo.lotto.domain.LottoVo;
import com.withJo.lotto.service.LottoService;
import com.withJo.util.FileUpload;
import com.withJo.util.Paging;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;


@RequestMapping("/lotto")
@Controller
public class LottoController {

	private Logger log = LoggerFactory.getLogger(LottoController.class);
	private final String logTitleMsg = "==LottoController==";
	
	@Autowired
	private LottoService lottoService;
	
	@GetMapping("/list")
	public String getLottoList(@RequestParam(defaultValue = "all") String searchField,
			@RequestParam(defaultValue = "") String searchKeyword,
			@RequestParam(defaultValue = "1") int curPage, Model model) {
		log.info(logTitleMsg);
		log.info("getLottoList");
		log.info("searchField: {}", searchField);
		log.info("searchKeyword: {}", searchKeyword);
		
		int totalCount = lottoService.lottoTotalCount(searchField, searchKeyword);
		
		log.info("totalCount: {}", totalCount);
		Paging pagingVo = new Paging(totalCount, curPage);
		
		int start = pagingVo.getPageBegin();
		int end = pagingVo.getPageEnd();
		
		
		List<LottoVo> lottoList = lottoService.lottoSelectList(start, end, searchField, searchKeyword);
		model.addAttribute("lottoList", lottoList);
		
		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("pagingVo", pagingVo);
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchField", searchField);
		searchMap.put("searchKeyword", searchKeyword);
		
		model.addAttribute("pagingMap", pagingMap);
		model.addAttribute("searchMap", searchMap);
		
		log.info("searchMap: {}", searchMap);
		return "lotto/LottoListView";
		
	}
	
	@GetMapping("/add")
	public String lottoAdd(Model model) {
		log.info(logTitleMsg);
		log.info("@GetMapping lottoAdd");

		return "lotto/LottoFormView";
	}
	
//	@RequestMapping(value = "/make", method = { RequestMethod.GET, RequestMethod.POST })
//	public ResponseEntity<String> lottoSelect() {
//	    Set<Integer> lottoNum = lottoService.lottoNum();
//	    List<Integer> tempSet = new ArrayList<>(lottoNum);
//	    Collections.sort(tempSet);
//	    
//	    String tempSetStr = "[" + tempSet.stream()
//	                                     .map(String::valueOf)
//	                                     .collect(Collectors.joining(", ")) + "]";
//	    
//	    return ResponseEntity.ok(tempSetStr);
//	}
	
	@RequestMapping(value = "/make", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<String> lottoSelect() {
	    Set<Integer> lottoNum = lottoService.lottoNum();
	    List<Integer> tempSet = new ArrayList<>(lottoNum);
	    String tempSetStr = "";
	    Collections.sort(tempSet);	
	    tempSetStr = tempSet.toString();	
	    return ResponseEntity.ok(tempSetStr);
	}
	
	@PostMapping("/add")
	public String lottoAdd(@RequestBody LottoVo lottoVo) {
	    log.info("lottoAdd");
	    
	    lottoService.lottoInsertOne(lottoVo);

	    return "redirect:/lotto/list";
	}
	
	@PostMapping("/add2")
	public String lottoAdd2(@RequestBody LottoVo lottoVo) {
	    log.info("lottoAdd2");
	    
	    lottoService.lottoInsertOne2(lottoVo);

	    return "redirect:/lotto/list";
	}
	
	@GetMapping("/test")
	public String eventList() {
	    log.info("eventList");

	    return "/EventListView";
	}
//	@PostMapping("/add")
//	public String lottoAdd(HttpServletRequest request, Model model) throws ServletException, IOException {
//		log.info("lottoAdd");
//		
//		String memberNo = request.getParameter("memberNo");
//		String lottoMode = request.getParameter("lottoMode");
//		String lottoRound = request.getParameter("lottoRound");
//		String lottoStartDate = request.getParameter("lottoStartDate");
//		String lottoEndDate = request.getParameter("lottoEndDate");
//		String lottoSelNo = request.getParameter("lottoSelNo");
//
//		LottoVo lottoVo = new LottoVo();
//		lottoVo.setMemberNo(Integer.parseInt(memberNo));
//		lottoVo.setLottoMode(Integer.parseInt(lottoMode));
//		lottoVo.setLottoRound(Integer.parseInt(lottoRound));
//		lottoVo.setLottoStartDate(lottoStartDate);
//		lottoVo.setLottoEndDate(lottoEndDate);
//		lottoVo.setLottoSelNo(lottoSelNo);
//
//		lottoService.lottoInsertOne(lottoVo);
//
//		return "redirect:/lotto/list";
//	}
	
	@GetMapping("/detail")
	public String lottoDetail(Model model) {
		log.info(logTitleMsg);
		log.info("@GetMapping lottoDetail today: {}");
		
		LottoVo lottoVo = lottoService.lottoSelectOne();
		
		model.addAttribute("lottoVo", lottoVo);
		
		return "lotto/LottoDetailView";
	}
	
	@PostMapping("/check")
	public ResponseEntity<Map<String, Object>> lottoCheck(@RequestBody LottoVo lottoVo, Model model) {
		log.info(logTitleMsg);
		log.info("@GetMapping lottoDetail today: {}");
		
		int lottoCount = lottoService.lottoCountCheck(lottoVo);
		
		Map<String, Object> countMap = new HashMap<>();
		countMap.put("lottoCount", lottoCount);
		log.info("로또카운트: {}", lottoCount);
		
		model.addAttribute("lottoCount", lottoCount);
		
		return ResponseEntity.ok(countMap);
	}
	
	@PostMapping("/delete")
	public String lottoDelete(@RequestParam int lottoNo) {
	    log.info("Deleting lotto with ID: {}", lottoNo);
	    
	    lottoService.lottoDeleteOne(lottoNo);

	    return "redirect:/lotto/list"; 
	}
}
