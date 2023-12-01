package chess;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;

public class InitializePieces extends JPanel {

	private Piece piece;
	private List<Piece> p = new ArrayList<Piece>();
	
	public InitializePieces()
	{	
		piece = new Piece(0, 0, "rookBlack.png", "black");
		p.add(piece);
		piece = new Piece(1, 0, "knightBlack.png", "black");
		p.add(piece);
		piece = new Piece(2, 0, "bishopBlack.png", "black");
		p.add(piece);
		piece = new Piece(3, 0, "queenBlack.png", "black");
		p.add(piece);
		piece = new Piece(4, 0, "kingBlack.png", "black");
		p.add(piece);
		piece = new Piece(5, 0, "bishopBlack.png", "black");
		p.add(piece);
		piece = new Piece(6, 0, "knightBlack.png", "black");
		p.add(piece);
		piece = new Piece(7, 0, "rookBlack.png", "black");
		p.add(piece);
		for (int i = 0; i < 8; i++)
		{
			piece = new Piece(i, 1, "pawnBlack.png", "black");
			p.add(piece);
		}
		
		piece = new Piece(0, 7, "rookWhite.png", "white");
		p.add(piece);
		piece = new Piece(1, 7, "knightWhite.png", "white");
		p.add(piece);
		piece = new Piece(2, 7, "bishopWhite.png", "white");
		p.add(piece);
		piece = new Piece(3, 7, "queenWhite.png", "white");
		p.add(piece);
		piece = new Piece(4, 7, "kingWhite.png", "white");
		p.add(piece);
		piece = new Piece(5, 7, "bishopWhite.png", "white");
		p.add(piece);
		piece = new Piece(6, 7, "knightWhite.png", "white");
		p.add(piece);
		piece = new Piece(7, 5, "rookWhite.png", "white");
		p.add(piece);

		for (int i = 0; i < 8; i++)
		{
			piece = new Piece(i, 6, "pawnWhite.png", "white");
			p.add(piece);
		}
		
		new InitializeBoard(p);
	}
	
}