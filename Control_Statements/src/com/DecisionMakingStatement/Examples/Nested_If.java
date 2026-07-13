package com.DecisionMakingStatement.Examples;

public class Nested_If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String address="Mathura,  India";
		if(address.endsWith("India"))
		{
			if(address.contains("Meerut"))
			{
				System.out.println("Your city is Meerut");
			}
			else if(address.contains("Noida"))
			{
				System.out.println("Your city is Noida");
			}
			else if(address.contains("Agra"))
			{
				System.out.println("Your city is Agra");
			}
			else
			{
				System.out.println(address.split(",")[1].trim());
			}
		}
		else
		{
			System.out.println("You are not living in India");
		}
	}

}
