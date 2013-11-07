// Natacha Gabbamonte
// 0932340
// CalculatorButtonPanel.java

package calculator;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This defines the Calculator's Button Panel. This panel accepts input from the
 * user (keyboard and clicks) and sends the received input to the Model. It is
 * the Controller part of the Model-View-Controller model.
 * 
 * @author Natacha Gabbamonte - 0932340
 * 
 */
public class CalculatorButtonPanel extends JPanel {

	private static final long serialVersionUID = 4977980068953228250L;
	private static final int FONT_SIZE = 24;
	private int currentFontSize = FONT_SIZE;

	private JButton[] theButtons = null;
	private String[] keys = { "OFF", "CE", "C", "(", ")", "7", "8", "9", "/",
			"+/-", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "+", "=" };
	private GridBagLayout gridBagLayout = null;
	private CalculatorModel model = null;
	private CalculatorParser parser = null;
	private Font theFont;

	/**
	 * Constructor for the Calculator's button panel.
	 * 
	 * @param model
	 *            The model that the button will be sending information to.
	 */
	public CalculatorButtonPanel(CalculatorModel model) {
		super();
		theFont = new Font(Font.DIALOG, Font.PLAIN, 18);
		this.model = model;
		parser = new CalculatorParser(model);
		initialize();
	}

	/**
	 * Sets the focus to the first button.
	 */
	public void setFocusToButton() {
		theButtons[0].requestFocusInWindow();
	}

	/**
	 * Changes the font size when the window is resized.
	 * 
	 * @param size
	 */
	public void setButtonFontSize(double percentage) {
		currentFontSize = (int) (FONT_SIZE * percentage);
		theFont = theFont.deriveFont(Font.PLAIN, currentFontSize);
		for (int i = 0; i < keys.length; i++)
			theButtons[i].setFont(theFont);
	}

	/**
	 * Initializes the Button Panel.
	 */
	private void initialize() {
		gridBagLayout = new GridBagLayout();

		this.setLayout(gridBagLayout);

		// Creates the listeners that will be used by the buttons.
		MyKeyListener myKeyListener = new MyKeyListener();
		MyActionListener myActionListener = new MyActionListener();

		// Creates the buttons
		theButtons = new JButton[keys.length];
		for (int i = 0; i < keys.length; ++i) {
			theButtons[i] = new JButton(keys[i]);
			theButtons[i].setFont(theFont);
			theButtons[i].addKeyListener(myKeyListener);
			theButtons[i].addActionListener(myActionListener);
		}
		// Adds the buttons and sets their constraints
		int buttonCount = 0;

		// Adding the first 2 rows
		int rows = 2;
		int cols = 5;
		for (int y = 0; y < rows; y++)
			for (int x = 0; x < cols; x++) {
				add(theButtons[buttonCount++], makeConstraints(x, y, 1, 1));
			}

		// Adding row 3 and 4
		rows = 4;
		cols = 4;
		for (int y = 2; y < rows; y++)
			for (int x = 0; x < cols; x++) {
				add(theButtons[buttonCount++], makeConstraints(x, y, 1, 1));
			}

		// Adding the last row
		add(theButtons[buttonCount++], makeConstraints(0, 4, 2, 1));
		add(theButtons[buttonCount++], makeConstraints(2, 4, 1, 1));
		add(theButtons[buttonCount++], makeConstraints(3, 4, 1, 1));
		add(theButtons[buttonCount++], makeConstraints(4, 2, 1, 3));

		setButtonWidthAndHeight();
		this.setSize(gridBagLayout.preferredLayoutSize(this));
		theButtons[0].requestFocusInWindow();
	}

	/**
	 * Determines which button is the widest and sets the width and height of
	 * the other ones accordingly.
	 */
	private void setButtonWidthAndHeight() {
		Dimension newSize = new Dimension(0, 0);
		Dimension currentSize = new Dimension(0, 0);

		for (int i = 0; i < keys.length; i++) {
			currentSize = theButtons[i].getPreferredSize();
			if (currentSize.width > newSize.width)
				newSize.width = currentSize.width;
		}
		newSize.height = newSize.width;

		for (int i = 0; i < keys.length; i++) {
			theButtons[i].setPreferredSize(newSize);
		}
	}

	/**
	 * Creates a GridBagConstraints object with the sent in values.
	 * 
	 * @param gridx
	 *            The column
	 * @param gridy
	 *            The row
	 * @param gridwidth
	 *            The width
	 * @param gridheight
	 *            The height
	 * @return The GridBagConstraints object
	 */
	private GridBagConstraints makeConstraints(int gridx, int gridy,
			int gridwidth, int gridheight) {
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridheight = gridheight;
		constraints.gridwidth = gridwidth;
		constraints.gridx = gridx;
		constraints.gridy = gridy;

		// Default for all the components.
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;

		return constraints;
	}

	/*
	 * Defines the action listener for the button clicks.
	 */
	private class MyActionListener implements ActionListener {

		/**
		 * Overrides the default implementation of the button click.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof JButton) {
				JButton button = (JButton) e.getSource();
				String key = button.getText();
				if (key.equals(keys[0])) // if key is OFF
					System.exit(0);
				else if (key.equals("="))
					parser.processInputList();
				else
					model.updateValues(key);
			}

		}
	}

	/*
	 * Listener for key presses. Each button is assigned a certain key on the
	 * keyboard. +/- uses the n key.
	 */
	private class MyKeyListener extends KeyAdapter {
		public void keyTyped(KeyEvent evt) {
			char character = evt.getKeyChar();

			switch (character) {
			case 'o':
			case 'O':
			case KeyEvent.VK_ESCAPE:
				theButtons[0].doClick();
			case 'e':
			case 'E':
			case KeyEvent.VK_BACK_SPACE:
				theButtons[1].doClick();
				break;
			case 'c':
			case 'C':
			case KeyEvent.VK_DELETE:
				theButtons[2].doClick();
				break;
			case '(':
				theButtons[3].doClick();
				break;
			case ')':
				theButtons[4].doClick();
				break;
			case KeyEvent.VK_7:
				theButtons[5].doClick();
				break;
			case KeyEvent.VK_8:
				theButtons[6].doClick();
				break;
			case KeyEvent.VK_9:
				theButtons[7].doClick();
				break;
			case KeyEvent.VK_SLASH:
				theButtons[8].doClick();
				break;
			case 'n': // This is for the +/- button.
				theButtons[9].doClick();
				break;
			case KeyEvent.VK_4:
				theButtons[10].doClick();
				break;
			case KeyEvent.VK_5:
				theButtons[11].doClick();
				break;
			case KeyEvent.VK_6:
				theButtons[12].doClick();
				break;
			case '*':
				theButtons[13].doClick();
				break;
			case KeyEvent.VK_1:
				theButtons[14].doClick();
				break;
			case KeyEvent.VK_2:
				theButtons[15].doClick();
				break;
			case KeyEvent.VK_3:
				theButtons[16].doClick();
				break;
			case '-':
				theButtons[17].doClick();
				break;
			case KeyEvent.VK_0:
				theButtons[18].doClick();
				break;
			case KeyEvent.VK_PERIOD:
				theButtons[19].doClick();
				break;
			case '+':
				theButtons[20].doClick();
				break;
			case KeyEvent.VK_EQUALS:
			case KeyEvent.VK_ENTER:
				theButtons[21].doClick();
				break;
			}
		}
	}
}
