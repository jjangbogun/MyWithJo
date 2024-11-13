package com.withJo.board.controller;

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

import com.withJo.board.domain.BoardVo;
import com.withJo.board.service.BoardService;
import com.withJo.util.FileUpload;
import com.withJo.util.Paging;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;


@RequestMapping("/board")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public String getBoardList(@RequestParam(defaultValue = "all") String searchField,
	        @RequestParam(defaultValue = "") String searchKeyword,
	        @RequestParam(defaultValue = "1") int curPage,
	        @RequestParam(required = false) Integer prevPage, Model model) {
		
	    if (prevPage != null) {
	        curPage = prevPage;
	    }
		
		int totalCount = boardService.boardTotalCount(searchField, searchKeyword);
		
		Paging pagingVo = new Paging(totalCount, curPage);
		
		int start = pagingVo.getPageBegin();
		int end = pagingVo.getPageEnd();	
		
		List<BoardVo> boardList = boardService.boardSelectList(start, end, searchField, searchKeyword);
		model.addAttribute("boardList", boardList);
		
		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("pagingVo", pagingVo);
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchField", searchField);
		searchMap.put("searchKeyword", searchKeyword);
		
		model.addAttribute("pagingMap", pagingMap);
		model.addAttribute("searchMap", searchMap);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("curPage", curPage);
		
		return "board/BoardListView";
		
	}
	
	@GetMapping("/add")
	public String boardAdd(Model model) {

		return "board/BoardFormView";
	}
	
	@PostMapping("/add")
	public String boardAdd(HttpServletRequest request, Model model) throws ServletException, IOException{

	    try {

	    	Part filePart1;
	    	filePart1 = request.getPart("boardImg");

	    	String boardImg = "";
	    	String boardImgName = "";
			if (filePart1.getSize() > 0) {
		    	FileUpload fileUpload = new FileUpload();
		    	boardImg = fileUpload.getFileUpload(filePart1, boardImgName);
			}

	    	String memberNo = request.getParameter("memberNo");
	    	String boardTitle = request.getParameter("boardTitle");
	    	String boardContent = request.getParameter("boardContent");
	    	
	    	BoardVo boardVo = new BoardVo();
	    	
	    	boardVo.setMemberNo(Integer.parseInt(memberNo));
	    	boardVo.setBoardTitle(boardTitle);
	    	boardVo.setBoardContent(boardContent);
	    	boardVo.setBoardImg(boardImg);
	    		  
			boardService.boardInsertOne(boardVo);
	    	
		} catch (Exception e) {
			// TODO: handle exception
		}
	    
	    return "redirect:/board/list";
	}
	
	@GetMapping("/detail")
	public String boardDetail(@RequestParam int boardNo,
			@RequestParam(required = false) Integer prevPage, Model model) {
		
		BoardVo boardVo = boardService.boardSelectOne(boardNo);
		
		model.addAttribute("boardVo", boardVo);
		model.addAttribute("prevPage", prevPage);
		
		return "board/BoardDetailView";
	}
	
	@GetMapping("/update")
	public String boardUpdate(@RequestParam int boardNo, Model model) {
		
		BoardVo boardVo = boardService.boardSelectOne(boardNo);
		
		model.addAttribute("boardVo", boardVo);
		
		return "board/BoardUpdateView";
	}
	
	@PostMapping("/update")
	public String boardUpdate(HttpServletRequest request, Model model) throws ServletException, IOException {

	    String boardNo = null; // boardNo 변수를 메서드 시작 부분에서 선언

	    try {
	        Part filePart1 = request.getPart("boardImg");

	        String boardImg = "";
	        String boardImgName = request.getParameter("boardImgName");
	        boardNo = request.getParameter("boardNo"); // boardNo 값을 요청에서 가져오기
	        String boardTitle = request.getParameter("boardTitle");
	        String boardContent = request.getParameter("boardContent");
	        String boardImgDelete = request.getParameter("boardImgDelete");

	        if (filePart1.getSize() > 0) {
	            FileUpload fileUpload = new FileUpload();
	            boardImg = fileUpload.getFileUpload(filePart1, boardImgName);
	        } else {
	            if (Integer.parseInt(boardImgDelete) == 0) {
	                boardImg = boardImgName;
	            } else {
	                FileUpload fileUpload = new FileUpload();
	                boardImg = fileUpload.getFileDelete(boardImgName);
	            }
	        }

	        BoardVo boardVo = new BoardVo();
	        boardVo.setBoardNo(Integer.parseInt(boardNo));
	        boardVo.setBoardTitle(boardTitle);
	        boardVo.setBoardContent(boardContent);
	        boardVo.setBoardImg(boardImg);

	        boardService.boardUpdateOne(boardVo);

	    } catch (Exception e) {
	        return "redirect:/board/list"; // 예외 발생 시 리다이렉트
	    }
	    return "redirect:/board/detail?boardNo=" + boardNo; // boardNo를 사용하여 리다이렉트
	}
	
	@PostMapping("/delete")
	public String boardDelete(@RequestParam int boardNo) {
	    
	    boardService.boardDeleteOne(boardNo);

	    return "redirect:/board/list"; 
	}
	
}
