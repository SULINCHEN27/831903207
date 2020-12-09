package 第二轮作业2;

import java.util.concurrent.CountDownLatch;

public class Test extends MyThread{
	
	private long start,end;
	long ans=0;
	private int x;
	private CountDownLatch cdl;
	
	Test(long start,long end,int x,CountDownLatch cdl){
		this.start=start;
		this.end=end;
		this.x=x;
		this.cdl=cdl;
	}
	
	
	private static boolean contain(long num, int x) {
			return String.valueOf(num).contains(String.valueOf(x));
		}
	
	public void run() {
		for (long i = start; i <=end; i++) {
			if (contain(i, x)) ans += i;
			}
		//当子线程结束后，线程数减1.
		cdl.countDown();
	}
}
