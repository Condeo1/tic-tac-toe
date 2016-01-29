package edu.jsu.mcis;

import javax.swing.*;

public class MyDialog implements Runnable {
	private String message;
	private String title;
	
	public MyDialog(String s, String ttl){
		message = s;
		title = ttl;
	}
	
	public void run(){
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
}