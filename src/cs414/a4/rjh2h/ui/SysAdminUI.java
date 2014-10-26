package cs414.a4.rjh2h.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SysAdminUI extends JFrame {

	private JLabel messageLabel;
	
	public SysAdminUI() {
		initUI();
	}
	
    private void initUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setTitle("System Administration");
                
        messageLabel =  new JLabel("System Adminstration", SwingConstants.CENTER);
        		
        add(messageLabel);
       
        setSize(200, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

	public void setMessage(String message) {
		messageLabel.setText(message);
	}


	
	
	
}
