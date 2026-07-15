package filesinjava;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
public class WriteFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File myObj=new File("C:/Applications/Files/G1.txt");
			while(true)
			{
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the data to write in the file");
				String data=sc.nextLine();
				FileWriter myWriter=new FileWriter(myObj,true);
				myWriter.write(data+"\n");
				myWriter.close();
				sc.close();
				System.out.println("Successfully wrote to the file");
			}
		}catch(IOException e)
		{
			System.out.println("An error occurred. - File not found");
			e.printStackTrace();
		}
	}

}


