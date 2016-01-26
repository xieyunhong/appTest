package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataExternalizeTest {
	public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
		ExternalizableData data=new ExternalizableData(1,2);
		try {
			System.out.println(data.getX()+":"+data.getY());
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("ExternalizableData.out"));
			out.writeObject(data);
			out.close();
//			System.gc();
//			Thread.sleep(10000);
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("ExternalizableData.out"));
			ExternalizableData readData=(ExternalizableData) in.readObject();
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
