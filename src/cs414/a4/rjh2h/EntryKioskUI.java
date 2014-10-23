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
	JButton enterButton = new JButton("Press to Enter Garage");
	JButton dispenseTicketButton = new JButton ("Dispense Ticket");
	JButton virtualTicketButton = new JButton ("Virtual Ticket");
	
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
	    
	    messageLabel = new JLabel("Welcome to the Garage", SwingConstants.CENTER);
		enterButton = new JButton("Press to Enter Garage");
		dispenseTicketButton = new JButton ("Dispense Ticket");
		virtualTicketButton = new JButton ("Virtual Ticket");
		
		
	    message = "Press Top Button to Enter";
	    messageLabel.setText(message);
	
	    
	    
	    
	    
	    
	    
        JPanel pane = new JPanel(new GridLayout(4, 0));
        pane.add(enterButton);
        pane.add(dispenseTicketButton);
        pane.add(virtualTicketButton);
        
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
