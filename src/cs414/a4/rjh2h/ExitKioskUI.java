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

public class ExitKioskUI extends JFrame {

	private String title;
	private String message;
    JLabel messageLabel = new JLabel("Hello", SwingConstants.CENTER);
    JButton exitButton = new JButton("Enter Ticket");


	public ExitKioskUI() {
		initUI();
	}
	
    private void initUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        title = "Exit Kiosk";
        setTitle(title);
        message = "Thanks for visiting the garage";
        messageLabel.setText(message);
        
        JPanel pane = new JPanel(new GridLayout(0, 1));
        pane.add(exitButton);
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
        setVisible(true);
    }
	
	public void setMessage(String message) {
		this.message = message;
		messageLabel.setText(message);
	}
	
	public void addButtonActionListener(ActionListener listener) {
	    exitButton.addActionListener(listener);
	}
	
}
