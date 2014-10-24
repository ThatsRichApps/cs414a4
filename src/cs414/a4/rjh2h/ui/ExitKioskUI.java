package cs414.a4.rjh2h.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ExitKioskUI extends JFrame {

	private String title;
	private String message;
    private JLabel messageLabel = new JLabel("Hello", SwingConstants.CENTER);
    private JButton exitButton = new JButton("Exit Garage");
    
    private JComboBox<String> licenseBox;
    
	public ExitKioskUI() {
		initUI();
	}
	
    private void initUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        title = "Exit Kiosk";
        setTitle(title);
        message = "Thanks for visiting the garage";
        messageLabel.setText(message);
        
        JPanel pane = new JPanel(new GridLayout(4, 0));
        
        String[] licenseList = {"Enter Ticket Number or Select License"};
        
        licenseBox = new JComboBox<>(licenseList);
        
        licenseBox.setEditable(true);
        
        pane.add(exitButton);
        pane.add(messageLabel);
        pane.add(licenseBox);
        
        pane.setBorder(BorderFactory.createEmptyBorder(
                                        30, //top
                                        30, //left
                                        10, //bottom
                                        30) //right
                                        );

        getContentPane().add(pane, BorderLayout.CENTER);
	    
	    pack();
	    setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
	
	public void setMessage(String message) {
		this.message = message;
		messageLabel.setText(message);
	}

	public void setLicenseBoxList(String[] licenseList) {
		for (String string : licenseList) {
			   licenseBox.addItem(string);
		}
	}

	public void addLicense (String license) {
		
		licenseBox.addItem(license);
		
	}
	
	public void removeLicense (String license) {
		
		licenseBox.removeItem(license);
		
	}
	
	
	public void addButtonActionListener(ActionListener listener) {
	    exitButton.addActionListener(listener);
	}
	
	public void addComboBoxActionListener(ActionListener listener) {
	    licenseBox.addActionListener(listener);
	}
	
	
	
	
	
	
}
