package cs414.a4.rjh2h.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class ExitKioskUI extends JFrame {

	private String title;
	private String message;
    private JLabel messageLabel;
    private JButton exitButton;
    
    private JFormattedTextField enterTicketField;
    private JFormattedTextField licensePlateField;
    
    private String topMessage;
    private JLabel topMessageLabel;
    
    private String bottomMessage;
    private JLabel bottomMessageLabel;
    
    private JLabel gateStatusLabel;
	
    
	public ExitKioskUI() {
		initUI();
	}
	
    private void initUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        title = "Exit Kiosk";
        setTitle(title);
        
        message = "";
        messageLabel = new JLabel(message, SwingConstants.CENTER);
        
        topMessage = "Enter Ticket Num or License Plate";
        topMessageLabel = new JLabel(topMessage, SwingConstants.CENTER);
        
        bottomMessage = "";
        bottomMessageLabel = new JLabel(bottomMessage, SwingConstants.CENTER);
        
        exitButton = new JButton("Determine Fees");
        exitButton.setActionCommand("DetermineFees");
        
        JPanel pane = new JPanel(new GridLayout(7, 1));
        
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
    
        // create enter license plate field   
        licensePlateField = new JFormattedTextField(createFormatter("UU-UUU-###"));
        licensePlateField.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
        licensePlateField.setActionCommand("LicenseField");
        licensePlateField.setText("CO-AAA-111");
        
        gateStatusLabel = new JLabel("Gate is Closed", SwingConstants.CENTER);
		
        pane.add(topMessageLabel);
        pane.add(enterTicketField);
        pane.add(licensePlateField);
        //pane.add(exitButton);
        pane.add(messageLabel);
        pane.add(bottomMessageLabel);
        pane.add(gateStatusLabel);
        
        pane.setBorder(BorderFactory.createEmptyBorder(
                                        30, //top
                                        30, //left
                                        10, //bottom
                                        30) //right
                                        );

        getContentPane().add(pane, BorderLayout.CENTER);
                
	    pack();
	    //setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    protected MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
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

	public String getLicensePlate () {
		
		String licensePlate = licensePlateField.getText();
		return licensePlate;
		
	}
	
	public void addButtonActionListener(ActionListener listener) {
	    exitButton.addActionListener(listener);
	}
	
	public void addTicketFieldActionListener(ActionListener listener) {
	    enterTicketField.addActionListener(listener);
	}

	public void addLicenseFieldActionListener(ActionListener listener) {
	    licensePlateField.addActionListener(listener);
	}

	public void setGateStatus (boolean isOpen) {
		if (isOpen) {
			gateStatusLabel.setText("Gate is Open, wait for car entry");
		} else {
			gateStatusLabel.setText("Gate is Closed");
		}
	}

	
	
}
