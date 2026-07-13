package Task53;

public class Increament_Decrement_Operators {
	public static void main(String args[])
	{
		int score =0;
		int lives=3;
		//Player earns points -> increament
		score++; //+1 point
		score+=5; // another 5 points
		System.out.println("Score: "+score);
		// Player loses a life -> decrement
		lives--; //-1 life
		System.out.println("Lives: "+lives);
		
	}

}
