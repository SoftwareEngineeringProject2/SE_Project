package chess;

import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;

import teamProject.ChatClient;
import teamProject.ChatServer;

public class UpdatePieces {

	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private List<Piece> piece;
	private List<Piece> opponentPieces;
	private Piece p;
	private Piece p2;
	private Piece oP;
	private Piece t;
	private JFrame game;
	
	UpdatePieces(int startX, int startY, int endX, int endY, List<Piece> piece, JFrame game)
	{
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.piece = piece;
		this.game = game;
		opponentPieces = piece;
		movePiece();
		//opponentPiece();
		for (int i = 0; i < piece.size(); i++)
		{
			t = piece.get(i);
			if(t.getName() == "notAPiece")
			{
				break;
			}
		}
		new Play(this.piece, this.game);
		//new Update(this.piece, this.game, this.endX, this.endY, this.startX, this.startY, t);
		
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
						if(p2.getName() == "king")
						{
							System.exit(0);
						}
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
	
	public void opponentPiece()
	{
		for (int i = 0; i < opponentPieces.size(); i++)
		{
			oP = opponentPieces.get(i);
			if((oP.getX() - 7) < 0)
			{
				oP.setX((oP.getX() - 7) * -1);
			}
			else if(((oP.getX() - 7) >= 0))
			{
				oP.setX((oP.getX() - 7));
			}
			
			if((oP.getY() - 7) < 0)
			{
				oP.setY((oP.getY() - 7) * -1);
			}
			else if(((oP.getY() - 7) >= 0))
			{
				oP.setY((oP.getY() - 7));
			}

		}
	}
}
