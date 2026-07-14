package filesinjava;
import java.io.*;
public class DeleteFIles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File myObj=new File("C:/Applications/Files/G1.txt");
			if(myObj.delete())
			{
				System.out.println("Deleted the File");
			}
			else
			{
				System.out.println("Failed TO delete the file");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
