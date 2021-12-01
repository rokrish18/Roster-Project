package com;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuWindow mw = new MenuWindow();
		 mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     mw.setSize(mw.getPreferredSize());
	     mw.setVisible(true);
	}

}
