package cs414.a4.rjh2h;

import javax.swing.JFrame;

public class EntrySign extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntrySign() {
		initUI();
	}
	
    private void initUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setTitle("Entry Sign");
        setSize(200, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
	
}
