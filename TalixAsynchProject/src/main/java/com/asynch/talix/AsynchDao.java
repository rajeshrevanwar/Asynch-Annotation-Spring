package com.asynch.talix;

import org.springframework.stereotype.Repository;

@Repository
public class AsynchDao {

	public void temp() {
		for(int i=0;i<4;i++){
			if(i==2){
				try{
				i=i/0;}
				catch(Exception e){
					System.out.println("Exp occured at i==2");
				}
			}
			System.out.print("hello temp + "+i);
		}
	}

	public void test() {
		for(int i=0;i<3;i++){
			System.out.print("hi test");
		}
	}

	public void onlyasync() {
		for(int i=0;i<3;i++){
			System.out.print(" only async ");
		}
	}

}