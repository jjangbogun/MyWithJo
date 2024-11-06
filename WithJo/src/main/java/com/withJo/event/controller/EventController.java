package com.withJo.event.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.withJo.event.domain.EventVo;
import com.withJo.event.service.EventService;
import com.withJo.lotto.domain.LottoVo;
import com.withJo.notice.domain.NoticeVo;
import com.withJo.util.FileUpload;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;


@RequestMapping("/event")
@Controller
public class EventController {

	private Logger log = LoggerFactory.getLogger(EventController.class);
	private final String logTitleMsg = "==EventController==";
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/list")
	public String eventList(Model model) {
		log.info(logTitleMsg);
	    log.info("eventList");
	    
	    List<EventVo> eventList = eventService.eventSelectList();
	    model.addAttribute("eventList", eventList);
	    return "/event/EventListView";
	}
	
	@PostMapping("/hide")
	public String eventHide(@RequestBody EventVo eventVo) {
	    log.info("lottoAdd");
	    
	    eventService.eventUpdateOne(eventVo);

	    return "redirect:/event/list";
	}
	


}
