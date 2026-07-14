package filesinjava;
import java.io.*;
public class CreateFileDir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File myObj=new File("C:/Applications/Files/G1.txt");
			if(myObj.createNewFile())
			{
				System.out.println("File Created:" +myObj.getName());
				System.out.println("Get file path:"+ myObj.getAbsolutePath());
				
			}
			else {
				System.out.println("File already exists");
			}
		}catch(IOException e) {
			System.out.println("An error occurred");
			e.printStackTrace();
			
		}
	}

}
