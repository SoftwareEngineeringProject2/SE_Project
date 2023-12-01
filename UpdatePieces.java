package chess;

import java.util.List;

import javax.swing.JFrame;

public class UpdatePieces {

	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private List<Piece> piece;
	private Piece p;
	private Piece p2;
	private JFrame game;
	
	UpdatePieces(int startX, int startY, int endX, int endY, List<Piece> piece, JFrame game)
	{
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.piece = piece;
		this.game = game;
		movePiece();
		new Play(this.piece, this.game);
	}
	
	public void movePiece()
	{
		for (int i = 0; i < piece.size(); i++)
		{
			p = piece.get(i);
			
			if (p.getX() == startX && p.getY() == startY)
			{
				for (int j = 0; j < piece.size(); j++)
				{
					p2 = piece.get(j);
					if (p2.getX() == endX && p2.getY() == endY)
					{
						piece.remove(p2);
					}
				}
				piece.remove(p);
				p.setX(endX);
				p.setY(endY);
				piece.add(p);
				break;
			}
		}
	}
}
