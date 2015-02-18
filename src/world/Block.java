package world;

import java.awt.Color;

public class Block {

	private Color color;
	private String text;
	private boolean up = false;

	public Block(Color color, String text) {
		this.color = color;
		this.text = text;
	}

	public Color getColor() {
		if(up)
			return Color.BLACK;
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}
}
