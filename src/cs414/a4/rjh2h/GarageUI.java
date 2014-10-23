package cs414.a4.rjh2h;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GarageUI extends JFrame {

	private String message;
    JLabel messageLabel = new JLabel("", SwingConstants.CENTER);
	
	public GarageUI (){		
		initUI();
	}
	
	public void setMessage(String message) {
		this.message = message;
		messageLabel.setText(message);
	}

	private void initUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setTitle("Parking Garage");
    	
    	message = "Current Occupancy: 0";
        messageLabel.setText(message);
        add(messageLabel);
       
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
