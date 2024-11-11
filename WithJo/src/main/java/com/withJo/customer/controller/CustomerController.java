package com.withJo.customer.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.withJo.customer.domain.CustomerVo;
import com.withJo.customer.service.CustomerService;
import com.withJo.member.domain.MemberVo;
import com.withJo.notice.domain.NoticeVo;
import com.withJo.util.FileUpload;
import com.withJo.util.Paging;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;


@RequestMapping("/customer")
@Controller
public class CustomerController {

	private Logger log = LoggerFactory.getLogger(CustomerController.class);
	private final String logTitleMsg = "==CustomerController==";
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String getCustomerList(@RequestParam(defaultValue = "all") String searchField,
			@RequestParam(defaultValue = "") String searchKeyword,
			@RequestParam(defaultValue = "1") int curPage, Model model) {
		log.info(logTitleMsg);
		log.info("getCustomerList");
		log.info("searchField: {}", searchField);
		log.info("searchKeyword: {}", searchKeyword);
		
		int totalCount = customerService.customerTotalCount(searchField, searchKeyword);
		
		log.info("totalCount: {}", totalCount);
		Paging pagingVo = new Paging(totalCount, curPage);
		
		int start = pagingVo.getPageBegin();
		int end = pagingVo.getPageEnd();		
		
		List<CustomerVo> customerList = customerService.customerSelectList(start, end, searchField, searchKeyword);
		System.out.println(customerList);
		model.addAttribute("customerList", customerList);
		
		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("pagingVo", pagingVo);
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchField", searchField);
		searchMap.put("searchKeyword", searchKeyword);
		
		model.addAttribute("pagingMap", pagingMap);
		model.addAttribute("searchMap", searchMap);
		
		log.info("searchMap: {}", searchMap);
		return "customer/CustomerListView";
		
	}
	
	@GetMapping("/add")
	public String customerAdd(Model model) {
		log.info(logTitleMsg);
		log.info("@GetMapping customerAdd");

		return "customer/CustomerFormView";
	}
	
	@PostMapping("/add")
	public String customerAdd(HttpServletRequest request, Model model) throws ServletException, IOException{
	    log.info(logTitleMsg);

    	String memberQNo = request.getParameter("memberQNo");
    	String customerTitle = request.getParameter("customerTitle");
    	String customerQue = request.getParameter("customerQue");
    	
    	CustomerVo customerVo = new CustomerVo();
    	
    	customerVo.setMemberQNo(Integer.parseInt(memberQNo));
    	customerVo.setCustomerTitle(customerTitle);
    	customerVo.setCustomerQue(customerQue);	
    		  
		customerService.customerInsertOne(customerVo);
	    
	    return "redirect:/customer/list";
	}
	
	@GetMapping("/detail")
	public String customerDetail(@RequestParam int customerNo, Model model, HttpSession session) {
		log.info(logTitleMsg);
		log.info("@GetMapping customerDetail customerNo: {}", customerNo);
		
		CustomerVo customerVo = customerService.customerSelectOne(customerNo);
		
	    MemberVo loggedInMember = (MemberVo) session.getAttribute("memberVo");
	    
	    if (customerVo.getMemberQNo() != loggedInMember.getMemberNo()) {
	        // 로그인하지 않았거나 관리자가 아닌 경우
	        return "redirect:/member/login"; // 로그인 페이지로 리다이렉트
	    }
		
		
		model.addAttribute("customerVo", customerVo);
		
		return "customer/CustomerDetailView";
	}

	@GetMapping("/update")
	public String customerUpdate(@RequestParam int customerNo, Model model) {
		log.info(logTitleMsg);
		log.info("@GetMapping noticeUpdate noticeNo: {}", customerNo);
		
		CustomerVo customerVo =customerService.customerSelectOne(customerNo);
		
		model.addAttribute("customerVo", customerVo);
		
		return "customer/CustomerUpdateView";
	}
	
	@PostMapping("/update")
	public String customerUpdate(HttpServletRequest request, Model model) throws ServletException, IOException {
	    log.info(logTitleMsg);
	    log.info("@GetMapping 체크11: {}");

	    String customerNo = null; 

	    try {	        
	    	customerNo = request.getParameter("customerNo");
	        String customerAns = request.getParameter("customerAns");
	        String memberANo = request.getParameter("memberANo");
	        String customerCheck = request.getParameter("customerCheck");
	        
//	        log.info("@GetMapping 업데이트 체크: {}", customerNo, customerAns, memberANo, customerCheck);
	        log.info("@GetMapping 업데이트 체크: {}", customerAns);

	        CustomerVo customerVo = new CustomerVo();
	        
	        customerVo.setCustomerNo(Integer.parseInt(customerNo));
	        customerVo.setCustomerAns(customerAns);
	        customerVo.setMemberANo(Integer.parseInt(memberANo));
	        customerVo.setCustomerCheck(customerCheck);
	        
	        customerService.customerUpdateOne(customerVo);

	    } catch (Exception e) {
	        log.error("업데이트 중 오류 발생", e);
	        return "redirect:/customer/list"; 
	    }

	    return "redirect:/customer/detail?customerNo=" + customerNo; 
	}
	
	@PostMapping("/delete")
	public String customerDelete(@RequestParam int customerNo) {
	    log.info("Deleting customer with ID: {}", customerNo);
	    
	    customerService.customerDeleteOne(customerNo);

	    return "redirect:/customer/list"; 
	}
	
}
