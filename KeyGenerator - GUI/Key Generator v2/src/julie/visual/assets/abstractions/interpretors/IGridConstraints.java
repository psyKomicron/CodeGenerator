/**
 * 
 */
package julie.visual.assets.abstractions.interpretors;

/**
 * @author julie
 *
 */
public interface IGridConstraints {

	void fill(String str);
	
	void weightx(int n);
	
	void weighty(int n);
	
	void anchor(String str);
	
	void ipadx(int n);
	
	void gridx(int n);
	
	void gridy(int n);
	
	void insets(int a, int b, int c, int d);
	
	void gridwith(int n);
	
}