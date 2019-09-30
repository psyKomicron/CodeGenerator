/**
 * 
 */
package julie.visual.assets.abstractions.classes;

import java.awt.GridBagConstraints;

import julie.visual.assets.abstractions.interpretors.IGridConstraints;

/**
 * @author julie
 *
 */
public class GridConstraints extends GridBagConstraints implements IGridConstraints{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void fill(String str) {
		if (str == "vertical" | str == "VERTICAL")
			this.fill = GridBagConstraints.VERTICAL;
		else 
			this.fill = GridBagConstraints.HORIZONTAL;
	}

	@Override
	public void weightx(int n) {
		this.weightx = n;
	}

	@Override
	public void weighty(int n) {
		this.weighty = n;
	}

	@Override
	public void anchor(String str) {
		this.anchor = GridBagConstraints.CENTER;
	}

	@Override
	public void ipadx(int n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gridx(int n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gridy(int n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insets(int a, int b, int c, int d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gridwith(int n) {
		// TODO Auto-generated method stub
		
	}

}
