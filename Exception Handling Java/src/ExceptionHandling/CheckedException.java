package ExceptionHandling;
import java.util.*;
import java.io.*;
public class CheckedException {
	int x,y;
	public void accept()throws IOException {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter two values: ");
		x=sc.nextInt();
		y=sc.nextInt();
		sc.close();
	}
	public void display() {
		int result=x+y;
		System.out.println("Addition = "+result);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckedException ce =new CheckedException();
		try {
			ce.accept();
			
		}
		catch(IOException e) {
			System.out.println(e);
		}
		ce.display();
	}

}
