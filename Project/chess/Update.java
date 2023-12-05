package chess;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import teamProject.ChatClient;
import teamProject.ChatServer;

public class Update {

	private List<Piece> piece;
	private List<Piece> opponentPiece = new ArrayList<Piece>();
	private JFrame game;
	private Piece p;
	private int endX;
	private int endY;
	private int startX;
	private int startY;
	private ChatClient client;
	
	Update(List<Piece> piece, JFrame game, int endX, int endY, int startX, int startY, Piece t)
	{
		client = new ChatClient();
		client.setHost("localhost");
		client.setPort(8300);
		
		this.piece = piece;
		this.game = game;
		this.endX = endX;
		this.endY = endY;
		this.startX = startX;
		this.startY = startY;
		opponentView();
		opponentPiece.add(t);
		try {
			client.openConnection();
			client.sendToServer(opponentPiece);
			client.closeConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void opponentView()
	{
		if((startX - 7) < 0)
		{
			startX = ((startX - 7) * -1);
		}
		else if(((startX - 7) >= 0))
		{
			startX = ((startX - 7));
		}
		
		if((startY - 7) < 0)
		{
			startY = ((startY - 7) * -1);
		}
		else if(((startY - 7) >= 0))
		{
			startY = ((startY - 7));
		}
		
		if((endX - 7) < 0)
		{
			endX = ((endX - 7) * -1);
		}
		else if(((endX - 7) >= 0))
		{
			endX = ((endX - 7));
		}
		
		if((endY - 7) < 0)
		{
			endY = ((endY - 7) * -1);
		}
		else if(((endY - 7) >= 0))
		{
			endY = ((endY - 7));
		}
		
		for (int i = 0; i < piece.size(); i++)
		{
			p = piece.get(i);
			if (p.getX() == startX && p.getY() == startY)
			{
				p.setX(endX);
				p.setY(endY);
				opponentPiece.add(p);
			}
			else
			{
				opponentPiece.add(p);
			}
		}
	}
}
