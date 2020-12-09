package 第二轮作业2;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
public class MyThread extends Thread{

	private static Scanner sc;

	public static void main(String[] args) {
		
		int ThreadNumber=10;//线程个数，数组长度
		
		//创建一个CountDownLatch对象，并调用构造器将计数器的个数设置为线程个数
		final CountDownLatch cdl = new CountDownLatch(ThreadNumber);
		//开始记录时间
		long startTime = System.currentTimeMillis();
		//键盘输入数字
		sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		long sum =0;
		
		//设置线程
		Test[] t = new Test[ThreadNumber];
		for(int i =0;i<ThreadNumber;i++) {
		long start = 1+i*100000000;
		long end =  (i+1)*100000000;
		t[i] = new Test(start,end,x,cdl);
		t[i].start();
		}

		try {
		//调用await()方法，阻塞主线程，当子线程全部执行完以后，主线程才被执行
		cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//求和
		for(int j=0;j<ThreadNumber;j++) {
			sum=sum+t[j].ans;
		}
		//记录结束时间
		Long endTime = System.currentTimeMillis();
		System.out.println(sum);
		System.out.println("消耗的时间为："+(endTime-startTime)+"毫秒");
	}

}
