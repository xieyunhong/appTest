package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class countCallable implements Callable<String> {
	private int count=5;
	private String name="";
	public countCallable(){
		super();
	}
	public countCallable(int count,String name) {
		super();
		this.count = count;
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return name+":"+this.count;
	}
	public static void main(String[] args) {
		ExecutorService exec=Executors.newCachedThreadPool();
		Future future1=exec.submit(new countCallable(8, "thread1"));
		Future future2=exec.submit(new countCallable(10, "thread2"));
		try {
//			if(future1.isDone()){
			System.out.println(future1.isDone());
			System.out.println(future1.get());
//			}
//			if(future2.isDone()){
			System.out.println(future2.get());
//			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			exec.shutdown();
		}

	}
}
