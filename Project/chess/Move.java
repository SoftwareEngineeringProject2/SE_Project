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
	private Piece p;
	
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
		
		if(checkObstructed(name))
		{
			//Check for capture
		}
		else
		{
			new UpdatePieces(startX, startY, endX, endY, piece, game);
		}
		
		return true;
	}
	
	public boolean knightMove()
	{
		
		createMaxPath(name);
		boolean invalidMove = true;
		for (int i = 0; i < potentialX.size(); i++)
		{
			if(endX == potentialX.get(i) && endY == potentialY.get(i))
			{
				invalidMove = false;
				break;
			}
		}
		
		if(invalidMove)
		{
			return false;
		}
		
		if(checkObstructed(name))
		{
			//Check for capture
		}
		else
		{
			new UpdatePieces(startX, startY, endX, endY, piece, game);
		}
		
		return false;
	}
	
	public boolean bishopMove()
	{
		createMaxPath(name);
		boolean invalidMove = true;
		for (int i = 0; i < potentialX.size(); i++)
		{
			if(endX == potentialX.get(i) && endY == potentialY.get(i))
			{
				invalidMove = false;
				break;
			}
		}
		
		if(invalidMove)
		{
			return false;
		}
		
		if(checkObstructed(name))
		{
			//Check for capture
		}
		else
		{
			new UpdatePieces(startX, startY, endX, endY, piece, game);
		}
		
		return false;
	}
	
	public boolean kingMove()
	{
		createMaxPath(name);
		boolean invalidMove = true;
		for (int i = 0; i < potentialX.size(); i++)
		{
			if(endX == potentialX.get(i) && endY == potentialY.get(i))
			{
				invalidMove = false;
				break;
			}
		}
		
		if(invalidMove)
		{
			return false;
		}
		
		if(checkObstructed(name))
		{
			//Check for capture
		}
		else
		{

			new UpdatePieces(startX, startY, endX, endY, piece, game);
		}
		
		return false;
	}
	
	public boolean queenMove()
	{
		createMaxPath(name);
		boolean invalidMove = true;
		for (int i = 0; i < potentialX.size(); i++)
		{
			if(endX == potentialX.get(i) && endY == potentialY.get(i))
			{
				invalidMove = false;
				break;
			}
		}
		
		if(invalidMove)
		{
			return false;
		}
		
		if(checkObstructed(name))
		{
			//Check for capture
		}
		else
		{
			new UpdatePieces(startX, startY, endX, endY, piece, game);
		}
		
		return false;
	}
	
	private boolean checkObstructed(String name)
	{
		if(name.equals("pawn"))
		{
			for(int i = 0; i < piece.size(); i++)
			{
				p = piece.get(i);
				for (int j = 0; j < potentialX.size(); j++)
				{
					if (p.getX() == potentialX.get(j) && p.getY() == potentialY.get(j))
					{
						if (p.getX() == endX && p.getY() == endY)
						{
							if (p.getColor() == "white")
							{
								return true;
							}
							return false;
						}
						return true;
					}
				}
			}
		}
		else if(name.equals("rook"))
		{
			for(int i = 0; i < piece.size(); i++)
			{
				p = piece.get(i);
				if (p.getX() == endX && p.getY() == endY)
				{
					if(p.getColor() == "white")
					{
						return true;
					}
					return false;
				}
			}
		}
		else if (name.equals("knight"))
		{
			for(int i = 0; i < piece.size(); i++)
			{
				p = piece.get(i);
				if (p.getX() == endX && p.getY() == endY)
				{
					if(p.getColor() == "white")
					{
						return true;
					}
					return false;
				}
			}
		}
		else if (name.equals("bishop"))
		{
			for(int i = 0; i < piece.size(); i++)
			{
				p = piece.get(i);
				if (p.getX() == endX && p.getY() == endY)
				{
					if(p.getColor() == "white")
					{
						return true;
					}
					return false;
				}
			}
		}
		else if (name.equals("king"))
		{
			for(int i = 0; i < piece.size(); i++)
			{
				p = piece.get(i);
				if (p.getX() == endX && p.getY() == endY)
				{
					if(p.getColor() == "white")
					{
						return true;
					}
					return false;
				}
			}
		}
		else if (name.equals("queen"))
		{
			for(int i = 0; i < piece.size(); i++)
			{
				p = piece.get(i);
				if (p.getX() == endX && p.getY() == endY)
				{
					if(p.getColor() == "white")
					{
						return true;
					}
					return false;
				}
			}
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
				}
			}
			else
			{
				for (int i = 1; i <= 1; i++)
				{
					potentialY.add(startY - i);
					potentialX.add(startX);
				}
			}
		}
		else if (name.equals("rook"))
		{
			for (int i = 0; i <= 7; i++)
			{
				if(i == startX);
				else
				{
					potentialX.add(i);
					potentialY.add(startY);
				}
			}
			for (int i = 0; i <= 7; i++)
			{
				if(i == startY);
				else
				{
					potentialY.add(i);
					potentialX.add(startX);
				}
			}
		}
		else if (name.equals("knight"))
		{
			potentialX.add(startX + 2);
			potentialY.add(startY + 1);
			potentialX.add(startX + 2);
			potentialY.add(startY - 1);
			potentialX.add(startX - 2);
			potentialY.add(startY + 1);
			potentialX.add(startX - 2);
			potentialY.add(startY - 1);
			
			potentialY.add(startY + 2);
			potentialX.add(startX + 1);
			potentialY.add(startY + 2);
			potentialX.add(startX - 1);
			potentialY.add(startY - 2);
			potentialX.add(startX + 1);
			potentialY.add(startY - 2);
			potentialX.add(startX - 1);
		}
		else if (name.equals("bishop"))
		{
			potentialX.add(startX + 1);
			potentialY.add(startY + 1);
			potentialX.add(startX + 2);
			potentialY.add(startY + 2);
			potentialX.add(startX + 3);
			potentialY.add(startY + 3);
			potentialX.add(startX + 4);
			potentialY.add(startY + 4);
			potentialX.add(startX + 5);
			potentialY.add(startY + 5);
			potentialX.add(startX + 6);
			potentialY.add(startY + 6);
			potentialX.add(startX + 7);
			potentialY.add(startY + 7);
			potentialX.add(startX + 1);
			potentialY.add(startY - 1);
			potentialX.add(startX + 2);
			potentialY.add(startY - 2);
			potentialX.add(startX + 3);
			potentialY.add(startY - 3);
			potentialX.add(startX + 4);
			potentialY.add(startY - 4);
			potentialX.add(startX + 5);
			potentialY.add(startY - 5);
			potentialX.add(startX + 6);
			potentialY.add(startY - 6);
			potentialX.add(startX + 7);
			potentialY.add(startY - 7);
			potentialX.add(startX - 1);
			potentialY.add(startY - 1);
			potentialX.add(startX - 2);
			potentialY.add(startY - 2);
			potentialX.add(startX - 3);
			potentialY.add(startY - 3);
			potentialX.add(startX - 4);
			potentialY.add(startY - 4);
			potentialX.add(startX - 5);
			potentialY.add(startY - 5);
			potentialX.add(startX - 6);
			potentialY.add(startY - 6);
			potentialX.add(startX - 7);
			potentialY.add(startY - 7);
			potentialX.add(startX - 1);
			potentialY.add(startY + 1);
			potentialX.add(startX - 2);
			potentialY.add(startY + 2);
			potentialX.add(startX - 3);
			potentialY.add(startY + 3);
			potentialX.add(startX - 4);
			potentialY.add(startY + 4);
			potentialX.add(startX - 5);
			potentialY.add(startY + 5);
			potentialX.add(startX - 6);
			potentialY.add(startY + 6);
			potentialX.add(startX - 7);
			potentialY.add(startY + 7);
		}
		else if (name.equals("king"))
		{
			potentialX.add(startX + 1);
			potentialY.add(startY);
			potentialX.add(startX - 1);
			potentialY.add(startY);
			potentialX.add(startX);
			potentialY.add(startY + 1);
			potentialX.add(startX);
			potentialY.add(startY - 1);
			
			potentialX.add(startX + 1);
			potentialY.add(startY + 1);
			potentialX.add(startX - 1);
			potentialY.add(startY - 1);
			potentialX.add(startX + 1);
			potentialY.add(startY - 1);
			potentialX.add(startX - 1);
			potentialY.add(startY + 1);
		}
		else if (name.equals("queen"))
		{
			potentialX.add(startX + 1);
			potentialY.add(startY + 1);
			potentialX.add(startX + 2);
			potentialY.add(startY + 2);
			potentialX.add(startX + 3);
			potentialY.add(startY + 3);
			potentialX.add(startX + 4);
			potentialY.add(startY + 4);
			potentialX.add(startX + 5);
			potentialY.add(startY + 5);
			potentialX.add(startX + 6);
			potentialY.add(startY + 6);
			potentialX.add(startX + 7);
			potentialY.add(startY + 7);
			potentialX.add(startX + 1);
			potentialY.add(startY - 1);
			potentialX.add(startX + 2);
			potentialY.add(startY - 2);
			potentialX.add(startX + 3);
			potentialY.add(startY - 3);
			potentialX.add(startX + 4);
			potentialY.add(startY - 4);
			potentialX.add(startX + 5);
			potentialY.add(startY - 5);
			potentialX.add(startX + 6);
			potentialY.add(startY - 6);
			potentialX.add(startX + 7);
			potentialY.add(startY - 7);
			potentialX.add(startX - 1);
			potentialY.add(startY - 1);
			potentialX.add(startX - 2);
			potentialY.add(startY - 2);
			potentialX.add(startX - 3);
			potentialY.add(startY - 3);
			potentialX.add(startX - 4);
			potentialY.add(startY - 4);
			potentialX.add(startX - 5);
			potentialY.add(startY - 5);
			potentialX.add(startX - 6);
			potentialY.add(startY - 6);
			potentialX.add(startX - 7);
			potentialY.add(startY - 7);
			potentialX.add(startX - 1);
			potentialY.add(startY + 1);
			potentialX.add(startX - 2);
			potentialY.add(startY + 2);
			potentialX.add(startX - 3);
			potentialY.add(startY + 3);
			potentialX.add(startX - 4);
			potentialY.add(startY + 4);
			potentialX.add(startX - 5);
			potentialY.add(startY + 5);
			potentialX.add(startX - 6);
			potentialY.add(startY + 6);
			potentialX.add(startX - 7);
			potentialY.add(startY + 7);
			potentialX.add(startX + 1);
			potentialY.add(startY);
			potentialX.add(startX + 2);
			potentialY.add(startY);
			potentialX.add(startX + 3);
			potentialY.add(startY);
			potentialX.add(startX + 4);
			potentialY.add(startY);
			potentialX.add(startX + 5);
			potentialY.add(startY);
			potentialX.add(startX + 6);
			potentialY.add(startY);
			potentialX.add(startX + 7);
			potentialY.add(startY);
			potentialX.add(startX);
			potentialY.add(startY + 1);
			potentialX.add(startX);
			potentialY.add(startY + 2);
			potentialX.add(startX);
			potentialY.add(startY + 3);
			potentialX.add(startX);
			potentialY.add(startY + 4);
			potentialX.add(startX);
			potentialY.add(startY + 5);
			potentialX.add(startX);
			potentialY.add(startY + 6);
			potentialX.add(startX);
			potentialY.add(startY + 7);
			potentialX.add(startX - 1);
			potentialY.add(startY);
			potentialX.add(startX - 2);
			potentialY.add(startY);
			potentialX.add(startX - 3);
			potentialY.add(startY);
			potentialX.add(startX - 4);
			potentialY.add(startY);
			potentialX.add(startX - 5);
			potentialY.add(startY);
			potentialX.add(startX - 6);
			potentialY.add(startY);
			potentialX.add(startX - 7);
			potentialY.add(startY);
			potentialX.add(startX);
			potentialY.add(startY - 1);
			potentialX.add(startX);
			potentialY.add(startY - 2);
			potentialX.add(startX);
			potentialY.add(startY - 3);
			potentialX.add(startX);
			potentialY.add(startY - 4);
			potentialX.add(startX);
			potentialY.add(startY - 5);
			potentialX.add(startX);
			potentialY.add(startY - 6);
			potentialX.add(startX);
			potentialY.add(startY - 7);
		}
	}
	
}
