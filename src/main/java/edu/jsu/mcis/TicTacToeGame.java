package edu.jsu.mcis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGame extends JPanel implements ActionListener{
	
	private TicTacToe model;
	private JButton[][] button;
	
	public TicTacToeGame(){
		model = new TicTacToe();
		button = new JButton[3][3];
		setLayout(new GridLayout(3,3));
		for(int i = 0; i < button.length; i++){
			for(int j = 0; j < button[i].length; j++){
				button[i][j] = new JButton();
				button[i][j].setPreferredSize(new Dimension(100,100));
				button[i][j].addActionListener(this);
				button[i][j].setName("Location" + i + "" + j);
				add(button[i][j]);
			}
		}
	}
	
	public void actionPerformed(ActionEvent event){
		JButton b = (JButton)event.getSource();
		String loc = b.getName().substring(8);
		int r = Integer.parseInt(loc.substring(0,1));
		int c = Integer.parseInt(loc.substring(1,2));
		model.markLocation(r, c);
		String m = model.getMark(r,c);
		b.setText(m);
		checkForWin();
	}
	
	private void checkForWin(){
		String winner = model.getWinner();
		JOptionPane p = new JOptionPane();
		p.setName("Game Over");
		if(winner == "X"){
			
			p.showMessageDialog(this, "Game Over", "The Winner is X", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(winner == "O"){
			p.showMessageDialog(this, "Game Over", "The Winner is O", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(winner == "TIE"){
			p.showMessageDialog(this, "Game Over", "The Winner is TIE", JOptionPane.INFORMATION_MESSAGE);
		}
	
	}
	
	public static void main(String[] args){
		JFrame win = new JFrame("Tic Tac Toe");
		win.add(new TicTacToeGame());
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.pack();
		win.setVisible(true);
	}
}