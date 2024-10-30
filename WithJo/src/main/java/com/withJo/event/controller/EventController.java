package com.withJo.event.controller;

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


@RequestMapping("/event")
@Controller
public class EventController {

	private Logger log = LoggerFactory.getLogger(EventController.class);
	private final String logTitleMsg = "==LottoController==";
	
	@Autowired
	private LottoService lottoService;
	
	@GetMapping("/list")
	public String eventList() {
	    log.info("eventList");

	    return "/event/EventListView";
	}

}
