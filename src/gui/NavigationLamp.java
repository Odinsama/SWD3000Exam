package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class NavigationLamp extends JLabel {
	private boolean isGreen = true;

	public NavigationLamp() {
		super("•");
		setFont(new Font("Serif", Font.BOLD, 62));
		updateColor();
	}

	public void toggle() {
		isGreen = !isGreen;
		updateColor();
	}

	private void updateColor() {
		setForeground(isGreen ? Color.GREEN : Color.RED);
	}
}
