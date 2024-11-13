package com.withJo.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.withJo.event.domain.EventVo;
import com.withJo.event.service.EventService;


@RequestMapping("/event")
@Controller
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/list")
	public ModelAndView eventList() {
	    
	    List<EventVo> eventList = eventService.eventSelectList();
	    
	    ModelAndView mav = new ModelAndView("event/EventListView");
	    
	    System.out.println("eventList" + eventList);
	    
		mav.addObject("eventList", eventList);
	    return mav;
	}
	
	@PostMapping("/update1")
	public String eventHideLotto(@RequestBody EventVo eventVo) {
	    
	    eventService.eventUpdateLotto(eventVo);

	    return "redirect:/event/list";
	}
	
	@PostMapping("/update2")
	public String eventHideDrawing(@RequestBody EventVo eventVo) {

	    eventService.eventUpdateDrawing(eventVo);

	    return "redirect:/event/list";
	}
	
}
