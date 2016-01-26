package producerAndCustomer;

import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.management.timer.TimerMBean;

public class Plate<T> {
	private int size = 10;
	private List<T> plate = new ArrayList<T>();

	public Plate() {
		super();
	}

	public Plate(int size) {
		super();
		this.size = size;
	}

	public T getT() {
		if (plate.size() > 0) {
			System.out.println("从盘子取出1个！");
			return plate.get(plate.size() - 1);
		} else {
			System.out.println("盘子已经空了！");
			return null;
		}
	}
	public void putT(T tObject) {
		if (plate.size() <size){
			System.out.println("放入盘子1个！");
			plate.add(tObject);
		}else{
			System.out.println("盘子已满！");
		}
	}
	class PutThread implements Runnable{
		private Plate<Object> plate;
		
		public PutThread(Plate<Object> plate) {
			super();
			this.plate = plate;
		}

		@Override
		public void run() {
			while(true){
			plate.putT(new Object());
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		}
	}
	
	class GetThread implements Runnable{
		private Plate<Object> plate;
		
		public GetThread(Plate<Object> plate) {
			super();
			this.plate = plate;
		}

		@Override
		public void run() {
			while(true){
			plate.getT();
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		}
	}
	public static void main(String[] args) {
		Plate<Object> plate = new Plate<Object>();  
        new Thread(plate.new PutThread(plate)).start();  
        new Thread(plate.new GetThread(plate)).start();  
	}
}
