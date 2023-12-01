package chess;

import javax.swing.*;
import java.awt.*;

public class Piece extends JComponent{
	
	private int x;
	private int y;
	private String name;
	private String color;
	
	public Piece(int x, int y, String name, String color)
	{
		this.x = x;
		this.y = y;
		this.name = name;
		this.color = color;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
}
