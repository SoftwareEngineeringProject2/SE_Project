package chess;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;

public class InitializeBoard {
	
	JFrame game;
	
	InitializeBoard(List<Piece> piece)
	{
		game = new JFrame("Match");
		game.setSize(1000, 1000);
		game.setLayout(new GridLayout(8, 8));
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setVisible(true);
		
		new Play(piece, game);
	}
}