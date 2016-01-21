import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	private TicTacToe t;
	
	public void startNewGame() {
		t = new TicTacToe();
	}
	
	public void markLocation(int row, int col) {
		t.markLocation(row, col);
	}
	
	public String getMark(int row, int col) {
		String m = t.getMark(row, col);
		return m;
	}
    
	public String getWinner() {
		String w = t.getWinner();
		return w;
	}
}
