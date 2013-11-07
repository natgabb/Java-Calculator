// Natacha Gabbamonte
// 0932340
// CalculatorApp.java

package calculator;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * This application display a Calculator that does the the basic arithmetic (+,
 * - , / , *) and parenthesis using the correct mathematical precedence. This
 * app uses the Model-View-Controller model.
 * 
 * @author Natacha Gabbamonte - 0932340
 * 
 */
public class CalculatorApp extends JFrame {

	private static final long serialVersionUID = -6691919724077994317L;

	// Panels
	CalculatorButtonPanel buttonPanel = null;
	CalculatorDisplayPanel displayPanel = null;
	CalculatorModel model = null;

	/**
	 * Constructor for the Calculator.
	 */
	public CalculatorApp() {
		super();

		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"The look and feel you selected is not supported.",
					"Look and Feel Error", JOptionPane.INFORMATION_MESSAGE);
		}

		model = new CalculatorModel();
		buttonPanel = new CalculatorButtonPanel(model);
		displayPanel = new CalculatorDisplayPanel(model);
		model.addObserver(displayPanel);

		initialize();
		setTitle("Calculator");
		pack();
		this.addComponentListener(new FrameSizeListener(this.getPreferredSize()));
		this.setVisible(true);
		buttonPanel.setFocusToButton();
	}

	/*
	 * Adds the display and button panels to the layout.
	 */
	private void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 0.15;
		constraints.weighty = 0.15;
		constraints.fill = GridBagConstraints.BOTH;
		add(displayPanel, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.weightx = 0.85;
		constraints.weighty = 0.85;
		constraints.fill = GridBagConstraints.BOTH;
		add(buttonPanel, constraints);

	}

	/*
	 * Defines the frame size listener for the component.
	 */
	private class FrameSizeListener extends ComponentAdapter {
		Dimension preferredFrameSize = null;

		/**
		 * Constructor for the FrameSizeListener.
		 * 
		 * @param preferredFrameSize
		 *            The frame's preferred size.
		 */
		public FrameSizeListener(Dimension preferredFrameSize) {
			super();
			this.preferredFrameSize = preferredFrameSize;
		}

		/**
		 * Sets the button and display font size depending of the size of the
		 * component.
		 */
		public void componentResized(ComponentEvent e) {
			if (e.getComponent() instanceof CalculatorApp) {
				CalculatorApp app = (CalculatorApp) e.getComponent();
				Dimension size = app.getSize();

				// If they are the same, nothing needs to be done.
				if (!preferredFrameSize.equals(size)) {
					double percentage = (double) size.height
							/ preferredFrameSize.height;
					buttonPanel.setButtonFontSize(percentage);
					displayPanel.setDisplayFontSize(percentage);
				}
			}
		}
	}

	/**
	 * Starts the Calculator app.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				CalculatorApp app = new CalculatorApp();
				app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}

		});
	}

}
