package cn.huhu.web.controller;

import javax.servlet.http.HttpServletRequest;

import cn.huhu.web.service.RetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {

	@Autowired
	private RetryService retryService;

	@RequestMapping("/index")
	public String list(HttpServletRequest request){
		return "index";
	}

    @RequestMapping("/retry")
	public void retry(HttpServletRequest request){
		retryService.doRetry(true);
	}
	
}