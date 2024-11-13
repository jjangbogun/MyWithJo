package com.withJo.comments.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.withJo.comments.domain.CommentsVo;
import com.withJo.comments.service.CommentsService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/comments")
@Controller // @Controller 대신 @RestController 사용
public class CommentsController {

	@Autowired
	private CommentsService commentsService;

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<Map<String, Object>> commentList(@RequestParam int boardNo) {

	    List<CommentsVo> commentsList = commentsService.commentsSelectList(boardNo);

	    // 날짜 포맷 설정
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    for (CommentsVo comment : commentsList) {
	        String formattedDate = sdf.format(comment.getCommentsCredate());
	        comment.setFormattedCDate(formattedDate); // 포맷된 날짜를 새로운 필드에 저장
	    }

	    Map<String, Object> resultMap = new HashMap<>();
	    resultMap.put("commentsList", commentsList);

	    return new ResponseEntity<>(resultMap, HttpStatus.OK);
	}

	@PostMapping("/add")
	public String commentsAdd(HttpServletRequest request, Model model) throws ServletException, IOException {

		String boardNo = null;

		String memberNo = request.getParameter("memberNo");
		boardNo = request.getParameter("boardNo");
		String commentsContent = request.getParameter("commentsContent");

		CommentsVo commentsVo = new CommentsVo();
		commentsVo.setMemberNo(Integer.parseInt(memberNo));
		commentsVo.setBoardNo(Integer.parseInt(boardNo));
		commentsVo.setCommentsContent(commentsContent);

		commentsService.commentsInsertOne(commentsVo);

		return "redirect:/board/detail?boardNo=" + boardNo;
	}

	@PostMapping("/update")
	public ResponseEntity<Void> commentsUpdate(@RequestBody CommentsVo commentsVo) {
	    
	    commentsService.commentsUpdateOne(commentsVo);

	    return ResponseEntity.ok().build();
	}
	
	@PostMapping("/delete")
	public ResponseEntity<Void> commentsDelete(@RequestParam int commentsNo) {
	    
	    commentsService.commentsDeleteOne(commentsNo);

	    return ResponseEntity.noContent().build();
	}
	 

}