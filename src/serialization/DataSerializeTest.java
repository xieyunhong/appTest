package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataSerializeTest {
	public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
		Data data=new Data(1,2);
		try {
			System.out.println(data.getX()+":"+data.getY());
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("data.out"));
			out.writeObject(data);
			out.close();
//			System.gc();
//			Thread.sleep(10000);
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("data.out"));
			Data readData=(Data) in.readObject();
			System.out.println(readData.getX()+":"+readData.getY());
			in.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
