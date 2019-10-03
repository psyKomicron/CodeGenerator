/**
 * 
 */
package julie.visual.windows.performanceWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import julie.alphaNumGen.AlphaNumGenerator;
import julie.codeGenerator.IGenerator;
import julie.codeGenerator.generators.NumGenerator;
import julie.visual.windows.assets.AppWindow;
import julie.visual.windows.assets.performance.CodeGeneratorPerformanceTester;

/**
 * @author julie
 *
 */
public class PerformanceWindow extends AppWindow implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
		pane.setBackground(Color.WHITE);
		this.setContentPane(pane);
//		combo box
		String[] content = { "Alphanumerical", "Numerical" };
		comboBox = new JComboBox(content);
//		grid
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbc.ipadx = 200;
		gbc.gridx = 0;
		gbc.gridy = 0;
		pane.add(comboBox, gbc);
//		text field
		gbc.gridx = 0;
		gbc.gridy = 1;
		pane.add(textField, gbc);
//		label
		gbc.gridx = 1;
		gbc.gridy = 0;
		pane.add(label ,gbc);
//		button
		gbc.gridx = 0;
		gbc.gridy = 2;
		pane.add(button, gbc);
	}
	
	public void launchBenchmark() {
		IGenerator g;
		String s = (String)comboBox.getSelectedItem();
		if (s == "Alphanumerical") {
			g = new AlphaNumGenerator();
		}
		else if (s == "Numerical") {
			g = new NumGenerator();
		}
		else {
			g = new NumGenerator();
		}
		CodeGeneratorPerformanceTester benchmark = new CodeGeneratorPerformanceTester(g);
		long l = 0L;
		if (!"".equals(textField.getText())) {
			l = Long.parseLong(textField.getText());
			l *= 1000000000L;
		}
		else {
			JOptionPane.showMessageDialog(this, "No generation max time");
		}
		long[] n = benchmark.getGenerationTimePerformance(l);
		System.out.println(l);
		this.label.setText("generated codes : " + n[0] + " in seconds : " + (long)n[1]/1000000000L);
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			launchBenchmark();
		}
		
	}

}
