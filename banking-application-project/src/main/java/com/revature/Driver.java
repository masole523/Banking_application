package com.revature;

import org.apache.logging.log4j.*;

import com.revature.controllers.*;

public class Driver {

	public static void main(String[] args) {
		MenuController start = new MenuController();
		
		start.startMenu();
		
	}
}
