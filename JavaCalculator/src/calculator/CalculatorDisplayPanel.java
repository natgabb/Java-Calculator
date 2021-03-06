// Natacha Gabbamonte
// 0932340
// CalculatorDisplayPanel.java

package calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Defines the DisplayPanel for the calculator. It is an observer of the Model
 * and is the View part of the Model-View-Controller model.
 * 
 * @author Natacha Gabbamonte - 0932340
 * 
 */
public class CalculatorDisplayPanel extends JPanel implements Observer {

	private static final long serialVersionUID = -1048744463855396416L;
	private static final int FONT_SIZE = 24;
	private int currentFontSize = FONT_SIZE;
	private Font font;

	private JTextField allValues = null;
	private JTextField currentValue = null;
	private CalculatorModel model = null;

	/**
	 * Constructor for the DisplayPanel of the Calculator.
	 * 
	 * @param model
	 *            A reference to the Calculator's Model.
	 */
	public CalculatorDisplayPanel(CalculatorModel model) {
		super();

		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		font = new Font(Font.DIALOG, Font.PLAIN, 18);
		this.model = model;

		initialize();
	}

	/*
	 * Adds the text fields to the layout and configures them.
	 */
	private void initialize() {

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.BOTH;

		allValues = new JTextField();
		allValues.setHorizontalAlignment(JTextField.RIGHT);
		allValues.setFont(font);
		allValues.setEditable(false);
		allValues.setBackground(Color.WHITE);
		allValues.setPreferredSize(new Dimension(0, 50));
		allValues.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		add(allValues, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.BOTH;

		currentValue = new JTextField();
		currentValue.setHorizontalAlignment(JTextField.RIGHT);
		currentValue.setFont(font);
		currentValue.setEditable(false);
		currentValue.setBackground(Color.WHITE);
		currentValue.setPreferredSize(new Dimension(0, 50));
		currentValue.setText("0");
		currentValue.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		add(currentValue, constraints);

	}

	/**
	 * This is called when the Model changes.
	 */
	@Override
	public void update(Observable o, Object arg) {
		String text = "";
		for (String s : model.getAllValues())
			text += s;
		allValues.setText(text);
		currentValue.setText(model.getCurrentValue());
	}

	/**
	 * This changes the font size depending on a percentage.
	 * 
	 * @param percentage
	 *            the percentage
	 */
	public void setDisplayFontSize(double percentage) {
		currentFontSize = (int) (FONT_SIZE * percentage);
		font = font.deriveFont(Font.PLAIN, currentFontSize);
		currentValue.setFont(font);
		allValues.setFont(font);
	}

}
