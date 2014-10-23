package cs414.a4.rjh2h;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class EntryUI extends JFrame {	// Sign should observe ParkingGarage for changes in occupancy.

	private String title;
	private String message;
	JLabel messageLabel = new JLabel("Hello", SwingConstants.CENTER);

	public void setMessage(String message) {
		this.message = message;
		messageLabel.setText(message);
	}

	public EntryUI() {
		initUI();
	}

	private void initUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    title = "Entry Kiosk";
	    setTitle(title);
	    message = "Please Take Your Ticket";
	    // add a jLabel with the message
	            
	    messageLabel.setText(message);
	    add(messageLabel);
	   
	    setSize(200, 200);
	    setLocationRelativeTo(null);
	    setVisible(true);
	}

}
