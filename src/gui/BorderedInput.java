package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class BorderedInput extends JPanel {
	
	private JFormattedTextField inputField;
	/** 
	 * @param format - The format for the input. The same as JFormattedTextField.
	 * @param title - The name of the input field.
	 * @param cols - The number of colums on the input field. Width.
	 */
	public BorderedInput(Object format, String title, int cols) {
		inputField = new JFormattedTextField(format);
		inputField.setColumns(cols);
		setBorder(new TitledBorder(title));
		add(inputField, BorderLayout.CENTER);
	}

	public int getValue() {
		return (Integer) inputField.getValue();
	}
	
	public void disableInput() {
		inputField.setBackground(Color.LIGHT_GRAY);
		inputField.setEditable(false);
	}
	
	public void enableInput() {
		inputField.setBackground(Color.WHITE);
		inputField.setEditable(true);
	}
}
