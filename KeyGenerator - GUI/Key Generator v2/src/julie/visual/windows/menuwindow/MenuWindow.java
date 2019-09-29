/**
 * 
 */
package julie.visual.windows.menuwindow;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
import julie.visual.assets.buttons.menuwindow.QuitMenuButton;
import julie.visual.assets.panes.TextFieldHint;
import julie.visual.windows.AppWindow;
import julie.visual.windows.GenerateWindow;

/**
 * @author julie
 *
 */
public class MenuWindow extends AppWindow {

	private static final long serialVersionUID = 1L;
	
	private final MenuWindowButton numButton = new NumButton("Numerical");
	private final MenuWindowButton alphButton = new AlphNumButton("Alphanumerical");
	private final MenuWindowButton quitButton = new QuitMenuButton("Quit & Reset", new Dimension(50, 50));
	
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
		// buttons
		addActionListeners();
		addComponents();
		setup();
	}
	
	public void changeGeneratorMode(String mode) {
		generateWindow.setCodeGeneratorMode(mode);
	}
	
	public void canDispose() {
		if (confirmButton.isPressed() & alphnum()) {
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
		pack();
		centerOnScreen(getBounds());
		setVisible(true);
	}
	
	private void addComponents() {
		//
		GridBagConstraints gbcHigh = new GridBagConstraints();
		GridBagConstraints gbcCenter = new GridBagConstraints();
		GridBagConstraints gbcLow = new GridBagConstraints();
		GridBagLayout layout = new GridBagLayout();
		JPanel pane = new JPanel();
		setContentPane(pane);
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
		pane.add(textFieldHint, gbcCenter);
		// text field
		gbcCenter.fill = GridBagConstraints.HORIZONTAL;
		gbcCenter.weighty = 1.0;
		gbcCenter.gridx = 1;
		gbcCenter.gridy = 2;
		pane.add(textField, gbcCenter);
		// confirm button
		gbcCenter.fill = GridBagConstraints.HORIZONTAL;
		gbcCenter.weighty = 1.0;
		gbcCenter.gridx = 1;
		gbcCenter.gridy = 3;
		pane.add(confirmButton, gbcCenter);
		
		// quit button
		gbcLow.fill = GridBagConstraints.HORIZONTAL;
		gbcLow.weightx = 0.5;
		gbcLow.weighty = 1.0;
		gbcLow.gridwidth = 1;
		gbcLow.anchor = GridBagConstraints.LAST_LINE_START;
		gbcLow.gridx = 0;
		gbcLow.gridy = 4;
		pane.add(quitButton, gbcLow);
	}
	
	private void addActionListeners() {
		numButton.addActionListener(new NumButtonListener(this));
		alphButton.addActionListener(new AlphButtonListener(this));
		quitButton.addActionListener(new QuitButtonListener(this));
		confirmButton.addActionListener(new ConfirmButtonListener(this));
	}	

}
