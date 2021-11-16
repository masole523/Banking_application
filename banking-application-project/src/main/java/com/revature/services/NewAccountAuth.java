package com.revature.services;


public class NewAccountAuth {


	public boolean startBalance(double amount) {

		if (amount > 0.0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean passwordVerification(String pass, String passV) {
		
		if (pass.equals(passV)) {
			return true;
		}else {
			return false;
		}
		
	}
}
