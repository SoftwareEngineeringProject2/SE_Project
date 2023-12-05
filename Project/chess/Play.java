package chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class Play extends JPanel implements MouseListener {
	
	JFrame game;
	JPanel[][] section =  new JPanel[8][8];
	
	private int startX;
	private int startY;
	private String startColor;
	private String startName;
	
	private List<Piece> piece;
	private Piece p;
	
	public Play(List<Piece> piece, JFrame g)
	{
		this.game = g;
		game.getContentPane().removeAll();
		this.piece = piece;
		
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				section[j][i] = new JPanel();
				
				if((i + j) % 2 != 0)
				{
					section[j][i].setBackground(new Color(66, 40, 14));
				}
				else
				{
					section[j][i].setBackground(new Color(210, 180, 140));
				}
				game.add(section[j][i]);
			}
		}
		
		for(int i = 0; i < piece.size(); i++)
		{
			p = (Piece) piece.get(i);
			section[p.getX()][p.getY()].add(new JLabel(new ImageIcon(p.getName())));
		}
		
		game.addMouseListener(this);
	    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    game.setVisible(true);
	    
	}

	private int xIndex(int x)
	{
		int index = -1;
		
		if(x < 125)
		{
			index = 0;
		}
		else if(x >= 126 && x <= 250)
		{
			index = 1;
		}
		else if(x >= 251 && x <= 375)
		{
			index = 2;
		}
		else if(x >= 376 && x <= 500)
		{
			index = 3;
		}
		else if(x >= 501 && x <= 625)
		{
			index = 4;
		}
		else if(x >= 626 && x <= 750)
		{
			index = 5;
		}
		else if(x >= 751 && x <= 875)
		{
			index = 6;
		}
		else if(x > 876)
		{
			index = 7;
		}
		
		return index;
	}
	
	private int yIndex(int y)
	{
		int index = -1;
		
		if(y < 125)
		{
			index = 0;
		}
		else if(y >= 126 && y <= 250)
		{
			index = 1;
		}
		else if(y >= 251 && y <= 375)
		{
			index = 2;
		}
		else if(y >= 376 && y <= 500)
		{
			index = 3;
		}
		else if(y >= 501 && y <= 625)
		{
			index = 4;
		}
		else if(y >= 626 && y <= 750)
		{
			index = 5;
		}
		else if(y >= 751 && y <= 875)
		{
			index = 6;
		}
		else if(y > 876)
		{
			index = 7;
		}
		
		return index;
	}
	
	private String cutName(String longName)
	{
		String name = longName;
		name = name.replaceAll("White.png", "");
		
		return name;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		startX = xIndex(e.getX());
		startY = yIndex(e.getY());
		for (int i = 0; i < piece.size(); i++)
		{
	    	p = (Piece) piece.get(i);
			if(p.getX() == startX && p.getY() == startY)
			{
				if (p.getColor() == "white")
				{
					startColor = p.getColor();
					startName = cutName(p.getName());
				}
				break;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int endX = xIndex(e.getX());
		int endY = yIndex(e.getY());
		boolean confirmMove = false;

			Move m = new Move(startX, startY, endX, endY, piece, startName, game);
			if(startColor == "white")
			{
				if(startName.equals("pawn"))
				{
					confirmMove = m.pawnMove();
				}
				else if(startName.equals("rook"))
				{
					confirmMove = m.rookMove();
				}
				else if (startName.equals("knight"))
				{
					confirmMove = m.knightMove();
				}
				else if (startName.equals("bishop"))
				{
					confirmMove = m.bishopMove();
				}
				else if (startName.equals("king"))
				{
					confirmMove = m.kingMove();
				}
				else if (startName.equals("queen"))
				{
					confirmMove = m.queenMove();
				}
			}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

	}
	
}

