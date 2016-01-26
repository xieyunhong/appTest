
public class ThreadTest {
	public static void main(String[] args) {  
        Runnable runnable = new Runnable() {  
            Count1 count = new Count1();  
            public void run() {  
                count.count();  
            }  
        };  
        for(int i = 0; i < 10; i++) {  
            new Thread(runnable).start();  
        }  
    }
}
