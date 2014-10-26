package cs414.a4.rjh2h.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
    
    private JLabel paymentMessageLabel;
    
    private JLabel gateStatusLabel;
	
    private JButton payCashButton;
    private JButton payOnAccountButton;
    
    private JFormattedTextField creditCardField;
    
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
        
        paymentMessageLabel = new JLabel("", SwingConstants.CENTER);
        
        exitButton = new JButton("Determine Fees");
        exitButton.setActionCommand("DetermineFees");
        
        JPanel pane = new JPanel(new GridLayout(9, 1));
        
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
        
        
        payCashButton = new JButton("Pay by Cash");
        payCashButton.setActionCommand("PayCash");
        
        payOnAccountButton = new JButton("Pay on Account");
        payOnAccountButton.setActionCommand("PayOnAccount");
        
        creditCardField = new JFormattedTextField(createFormatter("#### #### #### ####"));
        creditCardField.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
        creditCardField.setActionCommand("CreditCardField");
        creditCardField.setText("1111 1111 1111 11111");
        
        // create enter license plate field   
        licensePlateField = new JFormattedTextField(createFormatter("UU-UUU-###"));
        licensePlateField.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
        licensePlateField.setActionCommand("LicenseField");
        licensePlateField.setText("CO-AAA-111");
        
        licensePlateField.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                licensePlateField.setText("");
            }
            
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        
        gateStatusLabel = new JLabel("Gate is Closed", SwingConstants.CENTER);
		
        pane.add(topMessageLabel);
        pane.add(enterTicketField);
        pane.add(licensePlateField);
        //pane.add(exitButton);
        pane.add(messageLabel);

        pane.add(paymentMessageLabel);
        pane.add(creditCardField);
        pane.add(payOnAccountButton);
        pane.add(payCashButton);
        
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

	public void setPaymentMessage(String message) {
		paymentMessageLabel.setText(message);
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
