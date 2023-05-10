package aufgabe4_start;

import javax.swing.*;
import java.awt.KeyboardFocusManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class SteuerungOptimiert2 extends JFrame {

	private GamePanelSimple gamePanel;
	private Timer timer;
	private double speed = 0.2; // [px/ms]
	private double distance;
	private int frameTime = 10; // [ms]

	private Set<Integer> statusTasten = new HashSet<Integer>();

	public SteuerungOptimiert2() {

		setBounds(100, 100, 450, 300);
		gamePanel = new GamePanelSimple(10, 10);

		add(gamePanel);
		add(new TextField(30), BorderLayout.PAGE_END);

		distance = speed * frameTime; // wie weit bewegen? => [px]

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN
						|| e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (e.getID() == KeyEvent.KEY_PRESSED)
						statusTasten.add(e.getKeyCode());
					else if (e.getID() == KeyEvent.KEY_RELEASED)
						statusTasten.remove(e.getKeyCode());
					return true;
				}
				return false;
			}

		});

		timer = new Timer(frameTime, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updatePanel();
				gamePanel.repaint();
			}

		});
		timer.start();

	}

	private void updatePanel() {
		if (statusTasten.contains(KeyEvent.VK_UP))
			gamePanel.incY(-distance);
		if (statusTasten.contains(KeyEvent.VK_DOWN))
			gamePanel.incY(+distance);
		if (statusTasten.contains(KeyEvent.VK_LEFT))
			gamePanel.incX(-distance);
		if (statusTasten.contains(KeyEvent.VK_RIGHT))
			gamePanel.incX(+distance);
	}

	public static void main(String[] args) {
		SteuerungOptimiert2 frame = new SteuerungOptimiert2();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
