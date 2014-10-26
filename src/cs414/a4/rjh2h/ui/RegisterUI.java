package cs414.a4.rjh2h.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RegisterUI extends JFrame {

	private String title;

	private JButton exitButton;
    private JFormattedTextField enterTicketField;
    
    private String topMessage;
    private JLabel topMessageLabel;
    
    private String bottomMessage;
    private JLabel bottomMessageLabel;
    
    private JDialog loginDialog;
    
    
    public RegisterUI () {
    	
    	initUI();
    }
    
	
    private void initUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        title = "Cash Register";
        setTitle(title);
        
        topMessage = "";
        topMessageLabel = new JLabel(topMessage, SwingConstants.CENTER);
        
        bottomMessage = "";
        bottomMessageLabel = new JLabel(bottomMessage, SwingConstants.CENTER);
        
        exitButton = new JButton("Payment");
        
        JPanel pane = new JPanel(new GridLayout(5, 1));
        
        // create enter ticket field with integer as input   
        enterTicketField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        enterTicketField.setFocusLostBehavior(JFormattedTextField.PERSIST);
        enterTicketField.setActionCommand("TicketField");
        
        enterTicketField.setText("0");
        
        try {
			enterTicketField.commitEdit();
		} catch (ParseException e) {
			// catch block
			e.printStackTrace();
		}
        
        pane.add(topMessageLabel);
        pane.add(enterTicketField);
        pane.add(exitButton);
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
	
	public void setTopMessage(String message) {
		this.topMessage = message;
		topMessageLabel.setText(message);
	}

}
