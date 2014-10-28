package cs414.a4.rjh2h.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SysAdminUI extends JFrame {

	private static final long serialVersionUID = -7241484193835854441L;
	private JLabel messageLabel;
	private JComboBox preferenceListBox;
	private JFormattedTextField setPreferenceField;
	private JButton setPreferenceButton;
	private String[] listOfPreferences;
	
	public SysAdminUI() {
		initUI();
	}
	
    private void initUI() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("System Administration");
                
        messageLabel =  new JLabel("System Adminstration", SwingConstants.CENTER);
   
        
        String[] listOfPreferences = { "maxoccupancy", "rate", "grace period", "maxfee" };

        preferenceListBox = new JComboBox<>(listOfPreferences);
		      
        setPreferenceField = new JFormattedTextField();
        
        setPreferenceButton = new JButton("Set Preference");        
        
        JPanel pane = new JPanel(new GridLayout(4, 2));
        
        pane.add(messageLabel);
        pane.add(preferenceListBox);
        pane.add(setPreferenceField);
        pane.add(setPreferenceButton);
        
        pane.setBorder(BorderFactory.createEmptyBorder(
                                        30, //top
                                        30, //left
                                        10, //bottom
                                        30) //right
                                        );

        getContentPane().add(pane, BorderLayout.CENTER);
                
	    pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

	public void setMessage(String message) {
		messageLabel.setText(message);
	}


	
	
	
}
