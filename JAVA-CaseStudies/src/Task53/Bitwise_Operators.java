package Task53;

public class Bitwise_Operators {
	public static void main(String args[])
	{
		int RED=1;
		int YELLOW=2;
		int GREEN=4;	
		//Current state: Red+Yellow
		int currentState=RED|YELLOW;
		//check if Red is ON using AND
		boolean isRedOn=(currentState&RED)!=0;
		System.out.println("Is Red ON? "+isRedOn);
		
		//Toggle Green using XOR
		currentState=currentState^GREEN; //011^100=111
		System.out.println("Current State after toggling Green: "+currentState);
		
		//Turn off Yellow using AND with NOT (complement)
		currentState=currentState&(~YELLOW); //111&011=101
		System.out.println("Current State after turning off Yellow: "+currentState);
		//Shift operations (simulate cycling lights)
		int cycleLeft=RED<<1;
		int cycleRight=GREEN>>1;
		System.out.println("Cycle Left (Red shifted left): "+cycleLeft);
		System.out.println("Cycle Right (Green shifted right): "+cycleRight);
	}
}
