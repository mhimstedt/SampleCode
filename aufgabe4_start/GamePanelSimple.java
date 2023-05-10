package aufgabe4_start;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class GamePanelSimple extends JPanel {

	private int x;
	private int y;
	private int w = 40;
	private int h = 30;

	public GamePanelSimple(int x, int y) {
		this.x = x;
		this.y = y;
		setBackground(Color.blue);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.red);
		g.fillRect(this.x, this.y, w, h);
	}

	public void incX(double d) {
		x += d;
	}

	public void incY(double d) {
		y += d;
	}

}
