package com.withJo.comments.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RestController;

import com.withJo.board.domain.BoardVo;
import com.withJo.comments.domain.CommentsVo;
import com.withJo.comments.service.CommentsService;
import com.withJo.util.FileUpload;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

@RequestMapping("/comments")
@Controller // @Controller 대신 @RestController 사용
public class CommentsController {

	private Logger log = LoggerFactory.getLogger(CommentsController.class);

	@Autowired
	private CommentsService commentsService;

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity commentList(@RequestParam int boardNo) {

		log.info("commentList");

		List<CommentsVo> commentsList = commentsService.commentsSelectList(boardNo);
		log.info("commentList : {}", commentsList);

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
		log.info("commentsAdd");

		String boardNo = null;

		String memberNo = request.getParameter("memberNo");
		boardNo = request.getParameter("boardNo");
		String commentsContent = request.getParameter("commentsContent");

		CommentsVo commentsVo = new CommentsVo();
		commentsVo.setMemberNo(Integer.parseInt(memberNo));
		commentsVo.setBoardNo(Integer.parseInt(boardNo));
		commentsVo.setCommentsContent(commentsContent);

		commentsService.commentsInsertOne(commentsVo);
		log.info("memberNo: {}, boardNo: {}, commentsContent: {}", memberNo, boardNo, commentsContent);

		return "redirect:/board/detail?boardNo=" + boardNo;
	}

	@PostMapping("/update")
	public ResponseEntity<Void> commentsUpdate(@RequestBody CommentsVo commentsVo) {
	    log.info("Updating comment with ID: {}", commentsVo.getCommentsNo());
	    
	    commentsService.commentsUpdateOne(commentsVo);

	    return ResponseEntity.ok().build();
	}
	
	@PostMapping("/delete")
	public ResponseEntity<Void> commentsDelete(@RequestParam int commentsNo) {
	    log.info("Deleting commentsNo with ID: {}", commentsNo);
	    
	    commentsService.commentsDeleteOne(commentsNo);

	    return ResponseEntity.noContent().build();
	}
	 

}