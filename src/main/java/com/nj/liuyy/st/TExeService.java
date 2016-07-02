package com.nj.liuyy.st;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TExeService {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		Future<String> result = executorService.submit(new RunCase1());
		
		//executorService.shutdown();
		
		System.out.println(result.get());
		
		Future<String> result2 = executorService.submit(new RunCase1());
		
		System.out.println(result2.get());
	}
	
}
