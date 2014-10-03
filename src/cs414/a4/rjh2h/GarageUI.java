package cs414.a4.rjh2h;

import javax.swing.JFrame;

public class GarageUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GarageUI (){		
		initUI();
	}
	
    private void initUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setTitle("Parking Garage");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
