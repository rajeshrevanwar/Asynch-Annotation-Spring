package com.asynch.talix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsynchService {

	@Autowired
	AsynchDao asynchDao;
	
	@Async("asynchExecutor")
	public void temp() {
		System.out.println(" temp thread "+Thread.currentThread().getName());
		asynchDao.temp();
	}
	
	@Async
	public void test() {
		System.out.println(" test thread "+Thread.currentThread().getName());
		asynchDao.test();
	}
	
	@Async
	public void onlyasync(){
		System.out.println(" onlyasync thread "+Thread.currentThread().getName());
		asynchDao.onlyasync();
	}

}
