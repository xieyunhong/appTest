package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class countThread implements Runnable {
	private int count=5;
	private String name="";
	public countThread(){
		super();
	}
	public countThread(int count,String name) {
		super();
		this.count = count;
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=count;i++){
			System.out.println(name+":"+i);		
			try {
				TimeUnit.MILLISECONDS.sleep((long) (1000*Math.random()));
//				Thread.sleep((long) (1000*Math.random()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	public static void main(String[] args) {
//		System.out.println("Executor1 start");
//		ExecutorService exec=Executors.newCachedThreadPool();
//		exec.execute(new countThread(8, "thread1"));
//		exec.execute(new countThread(10, "thread2"));
//		exec.shutdown();
		System.out.println("Executor2 start");
		ExecutorService exec2=Executors.newSingleThreadExecutor();
		exec2.execute(new countThread(8, "thread3"));
		exec2.execute(new countThread(10, "thread4"));
		exec2.shutdown();
	}
}
