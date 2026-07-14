package filesinjava;
import java.io.File;
public class GetFileInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File myObj=new File("C:/Applications/Files/G1.txt");
		if(myObj.exists())
		{
			System.out.println("File Name: "+myObj.getName());
			System.out.println("Absolute Path: "+myObj.getAbsolutePath());
			System.out.println("Writeable: "+myObj.canWrite());
			System.out.println("Readable: "+myObj.canRead());
			System.out.println("File Size in Bytes: "+myObj.length());
		}
		else
		{
			System.out.println("The file does not exist");
		}

	}

}
