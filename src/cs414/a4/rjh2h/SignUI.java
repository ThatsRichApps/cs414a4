package cs414.a4.rjh2h;

import javax.swing.JFrame;

public class SignUI extends JFrame {
	
	// Sign should observe ParkingGarage for changes in occupancy.
	
	private String title;
	private String message;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SignUI() {
		initUI();
	}
	
    private void initUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        title = "Entry Sign";
        setTitle(title);
        message = "Welcome to the Garage";
        // add a jLabel with the message
        setSize(200, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
	
}
