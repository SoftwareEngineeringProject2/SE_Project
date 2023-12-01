package chess;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Move {

	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private List<Piece> piece;
	private ArrayList<Integer> potentialY = new ArrayList<Integer>();
	private ArrayList<Integer> potentialX = new ArrayList<Integer>();
	JPanel section[][] = new JPanel[8][8];
	private String name;
	private JFrame game;
	
	Move(int startX, int startY, int endX, int endY, List<Piece> piece, String name, JFrame game)
	{
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.piece = piece;
		this.name = name;
		this.game = game;
	}
	
	public boolean pawnMove()
	{
		if (startY == 6)
		{
			if((endY == startY - 1 || endY == startY - 2) && (startX == endX))
			{
				createMaxPath(name);
				if(checkObstructed(name))
				{
					//Check for capture
				}
				else
				{
					new UpdatePieces(startX, startY, endX, endY, piece, game);
				}
			}
			else
			{
				//System.out.println("Invalid move");
			}
		}
		else
		{
			if((endY == startY -1) && (startX == endX))
			{
				createMaxPath(name);
				if(checkObstructed(name));
				else
				{
					new UpdatePieces(startX, startY, endX, endY, piece, game);
				}
			}
			else
			{
				//System.out.println("Invalid move");
			}
		}
		
		return true;
	}

	public boolean rookMove()
	{
		createMaxPath(name);
		boolean invalidMove = true;
		for (int i = 0; i < potentialX.size(); i++)
		{
			if (endX == potentialX.get(i) && endY == potentialY.get(i))
			{
				invalidMove = false;
				break;
			}
		}
		if(invalidMove)
		{
			return false;
		}
		checkObstructed(name);
		
		return true;
	}
	
	private boolean checkObstructed(String name)
	{
		if(name.equals("pawn"))
		{
			for(int i = 0; i < piece.size(); i++)
			{
				Piece p = piece.get(i);
				for (int j = 0; j < potentialX.size(); j++)
				{
					if (p.getX() == potentialX.get(j) && p.getY() == potentialY.get(j))
					{
						if (p.getX() == endX && p.getY() == endY)
						{
							//System.out.println("Valid");
							return false;
						}
						//System.out.println("Invalid");
						return true;
					}
				}
			}
		}
		else if (name.equals("rook"))
		{
			
		}
		return false;
	}
	
	private void createMaxPath(String name)
	{		
		if (name.equals("pawn"))
		{
			if (startY == 6)
			{
				for (int i = 1; i <= 2; i++)
				{
					potentialY.add(startY - i);
					potentialX.add(startX);
					//System.out.println("X: " + potentialX.get(i - 1));
					//System.out.println("Y: " + potentialY.get(i - 1));
				}
			}
			else
			{
				for (int i = 1; i <= 1; i++)
				{
					potentialY.add(startY - i);
					potentialX.add(startX);
					//System.out.println("X: " + potentialX.get(i - 1));
					//System.out.println("Y: " + potentialY.get(i - 1));
				}
			}
		}
		else if (name.equals("rook"))
		{
			for (int i = 0; i < 7; i++)
			{
				if(i == startX);
				else
				{
					potentialX.add(i);
					potentialY.add(startY);
				}
			}
			for (int i = 0; i < 7; i++)
			{
				if(i == startY);
				else
				{
					potentialY.add(i);
					potentialX.add(startX);
				}
			}
		}
	}
	
}
