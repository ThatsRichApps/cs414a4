package cs414.a4.rjh2h;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ExitKioskUI extends JFrame {

	// Sign should observe ParkingGarage for changes in occupancy.

	private String title;
	private String message;
    JLabel messageLabel = new JLabel("Hello", SwingConstants.CENTER);
	
	public void setMessage(String message) {
		this.message = message;
		messageLabel.setText(message);
	}

	public ExitKioskUI() {
		initUI();
	}
	
    private void initUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        title = "Exit Kiosk";
        setTitle(title);
        message = "Thanks for visiting the garage";
        // add a jLabel with the message
                
        messageLabel.setText(message);
        add(messageLabel);
       
        setSize(200, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
	
}
