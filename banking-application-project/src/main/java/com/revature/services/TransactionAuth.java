package com.revature.services;

import com.revature.models.*;

public class TransactionAuth {


	public boolean withdrawVerify(Account account, double amount) {
		if (account.getAmount() - amount > 0.0) {
			return true;
		}else {
			return false;
		}
	}

	public boolean depositVerify(double amount) {
		if (amount > 0.0) {
			return true;
		}else {
			return false;
		}

	}

}
