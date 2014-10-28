package cs414.a4.rjh2h.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class UsageReportsUI extends JFrame {

	private static final long serialVersionUID = -4705765678072542814L;
	private JLabel messageLabel;
	
	public UsageReportsUI() {
		initUI();
	}
	
    private void initUI() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        setTitle("Usage Reports");
                
        messageLabel =  new JLabel("Usage Reports", SwingConstants.CENTER);
        		
        add(messageLabel);
       
        setSize(200, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

	public void setMessage(String message) {
		messageLabel.setText(message);
	}
	
}
