/**
 * 
 */
package julie.visual.windows.performanceWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import julie.codeGenerator.generators.AlphaNumGenerator;
import julie.app.performance.CodeGeneratorPerformanceTester;
import julie.codeGenerator.IGenerator;
import julie.codeGenerator.generators.NumGenerator;
import julie.visual.windows.assets.AppWindow;

/**
 * @author julie
 *
 */
public class PerformanceWindow extends AppWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton button = new JButton("Launch");
	
	private JComboBox cBGenerator;
	private JComboBox cBMode;
	
	private JLabel label = new JLabel();
	
	private JTextField nbCodesField = new JTextField();
	private JTextField codeLengthField = new JTextField();
	
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
	
	private void setup() {
		setSize(new Dimension(400, 300));
		centerOnScreen(getBounds());
	}
	
	private void addComponents() {
		JPanel pane = new JPanel();
		button.addActionListener(new ButtonListener());
		button.setPreferredSize(new Dimension(50, 50));
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout layout = new GridBagLayout();
		pane.setLayout(layout);
		pane.setBackground(Color.LIGHT_GRAY);
		this.setContentPane(pane);
//		Combo Boxes
		String[] content = { 
				"Alphanumerical", 
				"Numerical" 
		};
		cBGenerator = new JComboBox(content);
//		-------------------------------------
		String[] type = { 
				"with array", 
				"without array" 
		};
		cBMode = new JComboBox(type);
//		Grid
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbc.ipadx = 200;
		gbc.gridx = 0;
		gbc.gridy = 0;
//		Combo Box 1
		pane.add(cBGenerator, gbc);
//		Combo Box 2
		gbc.gridx = 1;
		pane.add(cBMode, gbc);
//		Text Field 1 hint
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(20, 0, 0, 0);
		pane.add(new JLabel("Benchmark duration (seconds)"), gbc);
//		Text Field 1
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 0, 0, 0);
		pane.add(nbCodesField, gbc);
//		Text Field 2 hint
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(20, 0, 0, 0);
		pane.add(new JLabel("Code length"), gbc);
//		Text Field 2
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(0, 0, 20, 0);
		pane.add(codeLengthField, gbc);
//		Result label
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 20, 0, 0);
		pane.add(label ,gbc);
//		Button
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets = new Insets(0, 0, 0, 0);
		pane.add(button, gbc);
	}
	
	public void launchBenchmark() throws InterruptedException {
		long l = 0L;
		if (!"".equals(nbCodesField.getText())) {
			l = Long.parseLong(nbCodesField.getText());
			l *= 1000000000L;
		}
		else {
			JOptionPane.showMessageDialog(this, "No generation max time");
		}
		CodeGeneratorPerformanceTester benchmark = new CodeGeneratorPerformanceTester(getGeneratorFromCBox(), l);
		benchmark.withArray(getModeFromCBox());
		benchmark.setCodeLength(getLengthFromField());
//		Thread 1
		Thread benchThread = new Thread(new Runnable() {
			public void run() {
				benchmark.run();
				displayPerformance(benchmark);
			}
		});
//		Thread 2
		Thread displayThread = new Thread(new Runnable() {
			public void run() {
				while (benchThread.isAlive()) {
					String text =  "Generating";
					String s = "";
					for (int i = 0; i < text.length(); i++) {
						if (benchThread.isAlive()) {
							s += text.charAt(i);
							button.setText(s);
							try {
								Thread.sleep(300);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						else
							i = text.length();
					}
				}
				button.setText("Launch");
			}
		});
		displayThread.start();
		benchThread.start();
		System.gc();
	}
	
	private final void displayPerformance(CodeGeneratorPerformanceTester benchmark) {
		String text = "";
		String benchPerf = longFormatting(benchmark.getGenerationTimePerformance()[0]);
		if (benchmark.isUsingArray())
			text = 
			"<html><p>generated codes (using array) : " + 
			benchPerf + 
			"</p><p> in : " + 
			(long)benchmark.getGenerationTimePerformance()[1]/1000000000L + 
			" seconds</p>";
		else
			text = 
			"<html><p>generated codes (no array): " + 
			benchPerf + 
			"</p><p> in : " + 
			(long)benchmark.getGenerationTimePerformance()[1]/1000000000L + 
			" seconds</p>";
		
		text += "<p>for a total of : " + longFormatting(benchmark.getGenerationTimePerformance()[0]*(long)benchmark.getCodeLength()) + " char</p></html>";
		this.label.setText(text);
	}
	
	private final String longFormatting(long l) {
		String str = "" + l;
		String result = "";
		int n = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (n < 3) {
				result += str.charAt(i);
			}
			else {
				result += " " + str.charAt(i);
				n = 0;
			}
			n++;
		}
		StringBuilder builder = new StringBuilder();
		builder.append(result);
		builder.reverse();
		return new String(builder);
	}
	
	private final IGenerator getGeneratorFromCBox() {
		IGenerator g;
		String s = (String)cBGenerator.getSelectedItem();
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
		String s = (String)cBMode.getSelectedItem();
		if (s == "with array") {
			return true;
		}
		else {
			return false;
		}
	}
	
	private final int getLengthFromField() {
		int n = Integer.parseInt(codeLengthField.getText());
		return n;
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				launchBenchmark();
			} catch(Exception e) {
			}
		}
		
	}
	
	static class WaitWindow extends AppWindow {		
		
		private static final long serialVersionUID = 1L;
	
		public static ArrayList<WaitWindow> instances = new ArrayList<>();
	
		public WaitWindow() {
			super("Wait Window");
			JPanel p = new JPanel();
			this.setContentPane(p);
			p.setLayout(new BorderLayout());
			p.add(new JLabel("Generating"), BorderLayout.CENTER);
			p.add(new JButton("OK"), BorderLayout.SOUTH);
			this.pack();
			this.centerOnScreen(getBounds());
			this.setVisible(true);
			instances.add(this);
		}
		
		public static void closeInstances() {
			for (WaitWindow w : instances) {
				w.dispose();
			}
		}
		
	}

}
