package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	
	private TicTacToe t;
	
	@Test
	public void testInitialBoardIsEmpty() {
		TicTacToe t = new TicTacToe();
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j ++){
				assertEquals("#", t.getMark(i, j));
			}
		}
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		TicTacToe t = new TicTacToe();
		
		t.markLocation(0,2);
		
		assertEquals("X", t.getMark(0,2));
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		TicTacToe t = new TicTacToe();
		
		
		t.markLocation(0,2);
		t.markLocation(2,0);
		
		assertEquals("O", t.getMark(2,0));
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		TicTacToe t = new TicTacToe();
		
		t.markLocation(0,0);
		t.markLocation(0,0);
		
		assertEquals("X", t.getMark(0,0));
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		TicTacToe t = new TicTacToe();
		
		while(t.turnCounter < 9){
			t.markLocation(0, 0);
			t.turnCounter++;
			
			
		}
		
		assertFalse(t.turnCounter == 1);
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		TicTacToe t = new TicTacToe();
		
		t.markLocation(0,0);
		t.markLocation(1,0);
		t.markLocation(0,1);
		t.markLocation(1,1);
		t.markLocation(0,2);
		
		String winner = t.getWinner();
		
		assertEquals("X", winner);
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		TicTacToe t = new TicTacToe();
		
		String winner = "None";
		
		t.markLocation(0,0);		
		t.markLocation(1,0);
		t.markLocation(0,2);
		t.markLocation(0,1);
		t.markLocation(2,0);
		t.markLocation(2,2);
		t.markLocation(1,2);
		t.markLocation(1,1);
		t.markLocation(2,1);
		
		winner = t.getWinner();
		
		assertEquals("TIE", winner);
	}	
}
