/**
 * 
 */
package julie.visual.windows.performanceWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import julie.alphaNumGen.AlphaNumGenerator;
import julie.app.performance.CodeGeneratorPerformanceTester;
import julie.codeGenerator.IGenerator;
import julie.codeGenerator.generators.NumGenerator;
import julie.visual.windows.assets.AppWindow;

/**
 * @author julie
 *
 */
public class PerformanceWindow extends AppWindow implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox comboBoxGenerator;
	private JComboBox comboBox;
	
	private JTextField textField = new JTextField();
	
	private JLabel label = new JLabel();
	
	/**
	 * @param _name
	 */
	public PerformanceWindow(String _name) {
		super(_name);
		setup();
		addComponents();
		pack();
		setVisible(true);
	}

	@Override
	public void run() {
		
	}
	
	private void setup() {
		setSize(new Dimension(400, 300));
		centerOnScreen(getBounds());
	}
	
	private void addComponents() {
		JPanel pane = new JPanel();
		JButton button = new JButton("Launch");
		button.addActionListener(new ButtonListener());
		button.setPreferredSize(new Dimension(50, 50));
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout layout = new GridBagLayout();
		pane.setLayout(layout);
		pane.setBackground(Color.LIGHT_GRAY);
		this.setContentPane(pane);
//		combo box
		String[] content = { "Alphanumerical", "Numerical" };
		comboBoxGenerator = new JComboBox(content);
		String[] type = { "with array", "without array" };
		comboBox = new JComboBox(type);
//		grid
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbc.ipadx = 200;
		gbc.gridx = 0;
		gbc.gridy = 0;
//		combo box 1
		pane.add(comboBoxGenerator, gbc);
//		combo box 2
		gbc.gridx = 1;
		pane.add(comboBox, gbc);
//		text field
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(20, 0, 20, 0);
		pane.add(textField, gbc);
//		label
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 20, 0, 0);
		pane.add(label ,gbc);
//		button
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 0, 0, 0);
		pane.add(button, gbc);
	}
	
	public void launchBenchmark() {
		CodeGeneratorPerformanceTester benchmark = new CodeGeneratorPerformanceTester(getGeneratorFromCBox());
		benchmark.withArray(getModeFromCBox());
		long l = 0L;
		if (!"".equals(textField.getText())) {
			l = Long.parseLong(textField.getText());
			l *= 1000000000L;
		}
		else {
			JOptionPane.showMessageDialog(this, "No generation max time");
		}
		long[] n = benchmark.getGenerationTimePerformance(l);
		String text = "";
		if (benchmark.isUsingArray())
			text = "<html><p>generated codes (using array) : " + n[0] + "</p><p> in : " + (long)n[1]/1000000000L + " seconds</p></html>";
		else
			text = "<html><p>generated codes (no array): " + n[0] + "</p><p> in : " + (long)n[1]/1000000000L + " seconds</p></html>";
		this.label.setText(text);
	}
	
	private final IGenerator getGeneratorFromCBox() {
		IGenerator g;
		String s = (String)comboBoxGenerator.getSelectedItem();
		if (s == "Alphanumerical") {
			g = new AlphaNumGenerator();
		}
		else if (s == "Numerical") {
			g = new NumGenerator();
		}
		else {
			g = new NumGenerator();
		}
		return g;
	}
	
	private final boolean getModeFromCBox() {
		String s = (String)comboBox.getSelectedItem();
		if (s == "with array") {
			return true;
		}
		else {
			return false;
		}
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			launchBenchmark();
		}
		
	}

}
