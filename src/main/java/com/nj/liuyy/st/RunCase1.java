package com.nj.liuyy.st;

import java.util.concurrent.Callable;

public class RunCase1 implements Callable<String> {

	public String call() throws Exception {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
			Thread.sleep(1000);
		}
		return Thread.currentThread().getName();
	}

}
