package com.Jump_ControlStatements.Examples;

public class Break_Statement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a:for (int i = 1; i <= 5; i++) {
			b:for (int j = 1; j <= 15; j++) {
				c:for(int k = 1; k <= 20; k++) {
					if (k == 5) {
						break a;
					}
					
				}
				
			}
		}
	}

}
