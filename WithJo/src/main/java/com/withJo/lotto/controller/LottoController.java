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
	    tempSetStr = tempSet.toString();
	    Collections.sort(tempSet);		
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
//	
//	@GetMapping("/update")
//	public String boardUpdate(@RequestParam int boardNo, Model model) {
//		log.info(logTitleMsg);
//		log.info("@GetMapping boardUpdate boardNo: {}", boardNo);
//		
//		BoardVo boardVo = boardService.boardSelectOne(boardNo);
//		
//		model.addAttribute("boardVo", boardVo);
//		
//		return "board/BoardUpdateView";
//	}
//	
//	@PostMapping("/update")
//	public String boardUpdate(HttpServletRequest request, Model model) throws ServletException, IOException {
//	    log.info(logTitleMsg);
//
//	    String boardNo = null; // boardNo 변수를 메서드 시작 부분에서 선언
//
//	    try {
//	        Part filePart1 = request.getPart("boardImg");
//
//	        String boardImg = "";
//	        String boardImgName = request.getParameter("boardImgName");
//	        boardNo = request.getParameter("boardNo"); // boardNo 값을 요청에서 가져오기
//	        String boardTitle = request.getParameter("boardTitle");
//	        String boardContent = request.getParameter("boardContent");
//	        String boardImgDelete = request.getParameter("boardImgDelete");
//
//	        log.info("@GetMapping boardImgName: {}", boardImgName);
//
//	        if (filePart1.getSize() > 0) {
//	            FileUpload fileUpload = new FileUpload();
//	            boardImg = fileUpload.getFileUpload(filePart1, boardImgName);
//	        } else {
//	            if (Integer.parseInt(boardImgDelete) == 0) {
//	                boardImg = boardImgName;
//	            } else {
//	                FileUpload fileUpload = new FileUpload();
//	                boardImg = fileUpload.getFileDelete(boardImgName);
//	            }
//	        }
//
//	        BoardVo boardVo = new BoardVo();
//	        boardVo.setBoardNo(Integer.parseInt(boardNo));
//	        boardVo.setBoardTitle(boardTitle);
//	        boardVo.setBoardContent(boardContent);
//	        boardVo.setBoardImg(boardImg);
//	        log.info("@GetMapping boardVo: {}", boardVo);
//
//	        boardService.boardUpdateOne(boardVo);
//
//	    } catch (Exception e) {
//	        log.error("업데이트 중 오류 발생", e);
//	        return "redirect:/board/list"; // 예외 발생 시 리다이렉트
//	    }
//
//	    return "redirect:/board/detail?boardNo=" + boardNo; // boardNo를 사용하여 리다이렉트
//	}
//	
//	@PostMapping("/delete")
//	public String boardDelete(@RequestParam int boardNo) {
//	    log.info("Deleting board with ID: {}", boardNo);
//	    
//	    boardService.boardDeleteOne(boardNo);
//
//	    return "redirect:/board/list"; 
//	}
}
