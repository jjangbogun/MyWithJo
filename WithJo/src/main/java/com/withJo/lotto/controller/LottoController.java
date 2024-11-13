package com.withJo.lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.withJo.lotto.domain.LottoVo;
import com.withJo.lotto.service.LottoService;
import com.withJo.util.Paging;


@RequestMapping("/lotto")
@Controller
public class LottoController {
	
	@Autowired
	private LottoService lottoService;
	
	@GetMapping("/list")
	public String getLottoList(@RequestParam(defaultValue = "all") String searchField,
			@RequestParam(defaultValue = "") String searchKeyword,
			@RequestParam(defaultValue = "1") int curPage, Model model) {
		
		int totalCount = lottoService.lottoTotalCount(searchField, searchKeyword);
		
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
		
		return "lotto/LottoListView";
		
	}
	
	@GetMapping("/add")
	public String lottoAdd(Model model) {

		return "lotto/LottoFormView";
	}
	
	
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
	    
	    lottoService.lottoInsertOne(lottoVo);

	    return "redirect:/lotto/list";
	}
	
	@PostMapping("/add2")
	@ResponseBody
	public String lottoAdd2(@RequestBody LottoVo lottoVo) {
	    
	    lottoService.lottoInsertOne2(lottoVo);

	    return "redirect:/lotto/list";
	}
	
	@PostMapping("/emoney")
	public String lottoEmoney(@RequestBody Map<String, Object> payload) {
	    
	    int eMoney = (Integer) payload.get("eMoney");
	    int memberNo = (Integer) payload.get("memberNo");
	    int round = (int) payload.get("round");
	    
	    String detail = round + "회차 로또 이벤트 보상입니다.";

	    lottoService.lottoInsertEMoney(eMoney, memberNo, detail);

	    return "redirect:/lotto/detail";
	}
	
	
	@GetMapping("/detail")
	public String lottoDetail(Model model) {
		
		LottoVo lottoVo = lottoService.lottoSelectOne();
		
		model.addAttribute("lottoVo", lottoVo);
		
		return "lotto/LottoDetailView";
	}
	
	@PostMapping("/check")
	public ResponseEntity<Map<String, Object>> lottoCheck(@RequestBody LottoVo lottoVo, Model model) {
		
		int lottoCount = lottoService.lottoCountCheck(lottoVo);
		
		Map<String, Object> countMap = new HashMap<>();
		countMap.put("lottoCount", lottoCount);
		
		model.addAttribute("lottoCount", lottoCount);
		
		return ResponseEntity.ok(countMap);
	}
	
	@PostMapping("/delete")
	public String lottoDelete(@RequestParam int lottoNo) {
	    
	    lottoService.lottoDeleteOne(lottoNo);

	    return "redirect:/lotto/list"; 
	}
}
