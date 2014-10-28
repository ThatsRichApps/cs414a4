package cs414.a4.rjh2h.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GarageUI extends JFrame {

	private static final long serialVersionUID = -632474825274688493L;
	private JLabel messageLabel;
    private JButton sysAdminButton;
	private JButton showUsageButton;
    
	public GarageUI (){		
		initUI();
	}
	
	public void setMessage(String message) {
		messageLabel.setText(message);
	}

	private void initUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setTitle("Parking Garage");
    	
        messageLabel = new JLabel("Current Occupancy: 0", SwingConstants.CENTER);
    
        sysAdminButton = new JButton("System Administration");
        sysAdminButton.setActionCommand("SysAdmin");
        
        showUsageButton = new JButton("Show Garage Usage"); 
        showUsageButton.setActionCommand("ShowUsage");
        
        JPanel pane = new JPanel(new GridLayout(4, 1));
        
        pane.add(sysAdminButton);
        pane.add(showUsageButton);
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
	
	public void addSysAdminActionListener (ActionListener listener) {
		
		sysAdminButton.addActionListener(listener);
		
	}
	
	public void addShowUsageActionListener (ActionListener listener) {
		
		showUsageButton.addActionListener(listener);
		
	}
	
	
}
