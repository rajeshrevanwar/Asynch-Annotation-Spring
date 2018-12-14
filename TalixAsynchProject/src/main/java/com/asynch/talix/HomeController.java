package com.asynch.talix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}*/
	
	@Autowired
	AsynchService asynchService;
	
	@RequestMapping(value = "/callAsynch", method = RequestMethod.GET)
	public void callAsynch() {
		//System.out.println("Before asynch");
		System.out.println(Thread.currentThread().getName());
		asynchService.temp();
		asynchService.test();
		asynchService.onlyasync();
		//System.out.println("After asynch");
		System.out.println(Thread.currentThread().getName());
	}
}