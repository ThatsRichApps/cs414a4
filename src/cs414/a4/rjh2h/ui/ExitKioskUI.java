package cs414.a4.rjh2h.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ExitKioskUI extends JFrame {

	private String title;
	private String message;
    private JLabel messageLabel;
    private JButton exitButton;
    private JFormattedTextField enterTicketField;
    
    private String topMessage;
    private JLabel topMessageLabel;
    
    private String bottomMessage;
    private JLabel bottomMessageLabel;
    
	public ExitKioskUI() {
		initUI();
	}
	
    private void initUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        title = "Exit Kiosk";
        setTitle(title);
        
        message = "Enter Ticket Number";
        messageLabel = new JLabel(message, SwingConstants.CENTER);
        
        topMessage = "Top Message";
        topMessageLabel = new JLabel(topMessage, SwingConstants.CENTER);
        
        bottomMessage = "";
        bottomMessageLabel = new JLabel(bottomMessage, SwingConstants.CENTER);
        
        exitButton = new JButton("Exit Garage");
        
        JPanel pane = new JPanel(new GridLayout(5, 1));
        
        // create enter ticket field with integer as input   
        enterTicketField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        enterTicketField.setFocusLostBehavior(JFormattedTextField.PERSIST);
        enterTicketField.setActionCommand("TicketField");
        
        enterTicketField.setText("1");
        
        try {
			enterTicketField.commitEdit();
		} catch (ParseException e) {
			// catch block
			e.printStackTrace();
		}
        
        pane.add(topMessageLabel);
        pane.add(enterTicketField);
        pane.add(exitButton);
        pane.add(messageLabel);
        pane.add(bottomMessageLabel);
        
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
        setVisible(true);
    }
	
	public void setMessage(String message) {
		this.message = message;
		messageLabel.setText(message);
	}

	public void setBottomMessage(String message) {
		this.bottomMessage = message;
		bottomMessageLabel.setText(message);
	}
	

	public int getTicketNumber () {
		
		int ticketNumber = Integer.parseInt(enterTicketField.getText());
		
		return ticketNumber;
		
	}

	
	public void addButtonActionListener(ActionListener listener) {
	    exitButton.addActionListener(listener);
	}
	
	public void addTicketFieldActionListener(ActionListener listener) {
	    enterTicketField.addActionListener(listener);
	}

	
	
}
