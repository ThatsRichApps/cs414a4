package cs414.a4.rjh2h;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class EntryKioskUI extends JFrame {	// Sign should observe ParkingGarage for changes in occupancy.

	/**
	 * 
	 */
	private static final long serialVersionUID = -5276264018987914144L;
	private String title;
	private String message;
	JLabel messageLabel = new JLabel("Welcome to the Garage", SwingConstants.CENTER);
	JButton enterButton = new JButton("Dispense Ticket");
	
	public EntryKioskUI() {
		initUI();
	}
	
	@Override
	public String toString() {
		return "EntryKioskUI [title=" + title + ", message=" + message + "]";
	}

	public void setMessage(String message) {
		this.message = message;
		messageLabel.setText(message);
	}
	
	public void setButtonEnabled(boolean buttonEnabled) {
		enterButton.setEnabled(buttonEnabled);
	}
	
	public void addButtonActionListener(ActionListener listener) {
	    enterButton.addActionListener(listener);
	}
	
	private void initUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    title = "Entry Kiosk";
	    setTitle(title);
	    message = "Please Take Your Ticket";
	    messageLabel.setText(message);
	        
        JPanel pane = new JPanel(new GridLayout(0, 1));
        pane.add(enterButton);
        pane.add(messageLabel);
        pane.setBorder(BorderFactory.createEmptyBorder(
                                        30, //top
                                        30, //left
                                        10, //bottom
                                        30) //right
                                        );

        getContentPane().add(pane, BorderLayout.CENTER);
	    
	    pack();
	    setSize(300, 300);
	    setLocationRelativeTo(null);
	    setLocation(400,400);
	    setVisible(true);
	}

}
