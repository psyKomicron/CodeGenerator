/**
 * 
 */
package julie.visual.windows;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import julie.alphaNumGen.AlphaNumGenerator;
import julie.codeGenerator.IGenerator;
import julie.codeGenerator.generators.NumGenerator;
import julie.visual.assets.buttons.ActionButton;
import julie.visual.assets.buttons.GenerateWindowButton;
import julie.visual.windows.menuwindow.MenuWindow;


/**
 * @author julie
 *
 */
public class GenerateWindow extends AppWindow implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	private IGenerator generator;
	
	private String generatorType = "";
	
	private ActionButton generateButton = new GenerateWindowButton("Generate");
	private ActionButton closeButton = new GenerateWindowButton("Menu");
	
	private JPanel buttonPane = new JPanel();
	private JPanel contentPane = new JPanel();
	
	private ArrayList<CodeWindow> codeWindows = new ArrayList<>();
	
	
	public GenerateWindow() {
		super("KeyGenerator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		closeButton.addActionListener(new OpenMenuButtListener(this));
		generateButton.addActionListener(new GenButtListener());
		//
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		buttonPane.setLayout(new GridBagLayout());
		//
		buttonPane.add(closeButton);
		buttonPane.add(generateButton);
		contentPane.add(buttonPane, BorderLayout.CENTER);
		AuthorLabel authorLabel = new AuthorLabel();
		contentPane.add(authorLabel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public void removeCodeWindow(CodeWindow codeWindow) {
		codeWindows.remove(codeWindow);
	}
	
	public void doGenerateAction() {
		if (generator != null) {
			codeWindows.add(new CodeWindow(codeWindows.size(), this));
		}
		else JOptionPane.showMessageDialog(this, "Choose a mode first (Menu button)");
	}
	
	@Override
	public void run() {
		System.out.println("GenerateWindow running");
		pack();
		centerOnScreen(getBounds());
	}
	
	public void setCodeGeneratorMode(String mode) {
		if (mode.equalsIgnoreCase("alphanumerical"))
			generator = new AlphaNumGenerator();
		else if (mode.equalsIgnoreCase("numerical"))
			generator = new NumGenerator();
		generatorType = mode;
	}
	
	public IGenerator getGenerator() {
		return generator;
	}
	
	public String getGeneratorType() {
		return generatorType;
	}
	
	protected final GenerateWindow getThis() {
		return this;
	}
	
/************************************************************
 * 
 * nested classes
 *
 ************************************************************/	
	
	class OpenMenuButtListener implements ActionListener {

		private GenerateWindow parent;
		@Override
		public void actionPerformed(ActionEvent e) {
			/*MenuWindow mw = */new MenuWindow("Menu", parent);
		}
		
		protected OpenMenuButtListener(GenerateWindow parent) {
			super();
			this.parent = parent;
		}
	}
	
	class GenButtListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			doGenerateAction();
		}
		
	}
	
	class AuthorLabel extends JLabel {
		private static final long serialVersionUID = 1L;
		
		private AuthorLabel() {
			super("<html><b>@author</b> <i>MonsieurJ</i></html>", JLabel.CENTER);
			setFont(new Font("Verdana", Font.ITALIC, 14));
		}
	}
	
}