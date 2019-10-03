/**
 * 
 */
package julie.visual.windows.menuwindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import julie.visual.assets.buttons.WindowButton;
import julie.visual.assets.buttons.listeners.classes.AlphButtonListener;
import julie.visual.assets.buttons.listeners.classes.ConfirmButtonListener;
import julie.visual.assets.buttons.listeners.classes.NumButtonListener;
import julie.visual.assets.buttons.listeners.classes.QuitButtonListener;
import julie.visual.assets.buttons.menuwindow.AlphNumButton;
import julie.visual.assets.buttons.menuwindow.ConfirmButton;
import julie.visual.assets.buttons.menuwindow.MenuWindowButton;
import julie.visual.assets.buttons.menuwindow.NumButton;
import julie.visual.assets.buttons.menuwindow.PerfMenuButton;
import julie.visual.assets.buttons.menuwindow.QuitMenuButton;
import julie.visual.assets.panes.TextFieldHint;
import julie.visual.windows.assets.AppWindow;
import julie.visual.windows.generatewindow.GenerateWindow;
import julie.visual.windows.performanceWindow.PerformanceWindow;

/**
 * @author julie
 *
 */
public class MenuWindow extends AppWindow {

	private static final long serialVersionUID = 1L;
	
	private final MenuWindowButton numButton = new NumButton("Numerical");
	private final MenuWindowButton alphButton = new AlphNumButton("Alphanumerical");
	private final MenuWindowButton quitButton = new QuitMenuButton("Quit & Reset", new Dimension(50, 50));
	private final MenuWindowButton perfMenuButton = new PerfMenuButton("Benchmark mode");
	
	private final MenuWindowButton confirmButton = new ConfirmButton("Confirm");
	
	private final JTextField textField = new JTextField();
	
	private final JLabel textFieldHint = new TextFieldHint("Enter number of codes to generate");
	
	private GenerateWindow generateWindow = null;
	
	
	public MenuWindow(String name, GenerateWindow generateWindow) {
		super(name);
		this.generateWindow = generateWindow;
		// window parameters
		setTitle("Parameters");
		setSize(new Dimension(450, 300));
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		numButton.isDynamic(false);
		alphButton.isDynamic(false);
		// buttons
		addActionListeners();
		addComponents();
		setup();
	}
	
	public void changeGeneratorMode(String mode) {
		generateWindow.setCodeGeneratorMode(mode);
	}
	
	public void canDispose() {
		if ((confirmButton.isPressed() & alphnum()) | quitButton.isPressed()) {
			dispose();
		}
	}
	
	private boolean alphnum() {
		boolean b = false;
		if (numButton.isPressed() | alphButton.isPressed())
			b = true;
		return b;
	}
	
	public GenerateWindow getGenerateWindow() {
		return this.generateWindow;
	}
	
	public JTextField getTextField() {
		return textField;
	}
	
	// getters for JButtons
	public WindowButton getNumButton() {
		return this.numButton;
	}
	
	public WindowButton getAlphButton() {
		return this.alphButton;
	}
	
	public void setup() {
		if (generateWindow.getGeneratorType().equalsIgnoreCase("numerical")) {
			numButton.setEnabled(false);
			alphButton.setEnabled(true);
		}
		else if (generateWindow.getGeneratorType().equalsIgnoreCase("alphanumerical")) {
			numButton.setEnabled(true);
			alphButton.setEnabled(false);
		}
		else {
			numButton.setEnabled(true);
			alphButton.setEnabled(true);
		}
		if (GenerateWindow.getCodeGenerationNumber() != 10) {
			textField.setText(""+GenerateWindow.getCodeGenerationNumber());
		}
		textField.setPreferredSize(new Dimension(0, 50));
		pack();
		centerOnScreen(getBounds());
		setVisible(true);
	}
	
	private void addComponents() {
		perfMenuButton.addActionListener(new ButtonListener());
		//
		GridBagConstraints gbcHigh = new GridBagConstraints();
		GridBagConstraints gbcCenter = new GridBagConstraints();
		GridBagConstraints gbcLow = new GridBagConstraints();
		GridBagLayout layout = new GridBagLayout();
		JPanel pane = new JPanel();
		setContentPane(pane);
		pane.setBackground(Color.white);
		pane.setLayout(layout);
		// numButton
		gbcHigh.fill = GridBagConstraints.HORIZONTAL;
		gbcHigh.weightx = 0.0;
		gbcHigh.weighty = 1.0;
		gbcHigh.anchor = GridBagConstraints.PAGE_START;
		gbcHigh.ipadx = 200;
		gbcHigh.gridx = 0;
		gbcHigh.gridy = 0;
		pane.add(numButton, gbcHigh);
		// alphButton
		gbcHigh.fill = GridBagConstraints.HORIZONTAL;
		gbcHigh.weightx = 0.0;
		gbcHigh.ipadx = 200;
		gbcHigh.gridx = 1;
		gbcHigh.gridy = 0;
		pane.add(alphButton, gbcHigh);
		// text field hint
		gbcCenter.fill = GridBagConstraints.HORIZONTAL;
		gbcCenter.weighty = 1.0;
		gbcCenter.anchor = GridBagConstraints.CENTER;
		gbcCenter.gridx = 0;
		gbcCenter.gridy = 2;
		setInsets(gbcCenter, 40, 10, 40, 0);
		pane.add(textFieldHint, gbcCenter);
		// text field
		gbcCenter.fill = GridBagConstraints.HORIZONTAL;
		gbcCenter.weighty = 1.0;
		gbcCenter.gridx = 1;
		gbcCenter.gridy = 2;
		setInsets(gbcCenter, 20, 0, 0, 0);
		pane.add(textField, gbcCenter);
//		confirm button
		gbcCenter.fill = GridBagConstraints.HORIZONTAL;
		gbcCenter.weighty = 1.0;
		gbcCenter.gridx = 1;
		gbcCenter.gridy = 3;
		setInsets(gbcCenter, 0, 90, 50, 90);
		pane.add(confirmButton, gbcCenter);
//		quit button
		gbcLow.fill = GridBagConstraints.HORIZONTAL;
		gbcLow.weightx = 0.5;
		gbcLow.weighty = 1.0;
		gbcLow.gridwidth = 1;
		gbcLow.anchor = GridBagConstraints.LAST_LINE_START;
		gbcLow.gridx = 0;
		gbcLow.gridy = 5;
		pane.add(quitButton, gbcLow);
//		performance menu
		gbcLow.gridx = 1;
		gbcLow.gridy = 5;
		pane.add(perfMenuButton, gbcLow);
	}
	
	private final void setInsets(GridBagConstraints gbc, int x1, int y1, int x2, int y2) {
		gbc.insets = new Insets(x1, y1, x2, y2);
	}
	
	private void addActionListeners() {
		numButton.addActionListener(new NumButtonListener(this));
		alphButton.addActionListener(new AlphButtonListener(this));
		quitButton.addActionListener(new QuitButtonListener(this));
		confirmButton.addActionListener(new ConfirmButtonListener(this));
	}	
	
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new PerformanceWindow("Performance Window");
		}
		
	}

}
