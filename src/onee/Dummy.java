package onee;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class Dummy {

	private JFrame frame;
	static Random rand = new Random();
	static boolean state = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dummy window = new Dummy();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dummy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					state = !state;
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Are u dumb?");
		lblNewLabel.setBounds(6, 0, 444, 65);
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnYesButton = new JButton("Yes");
		JButton btnNo = new JButton("No");
		btnYesButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					btnYesButton.hide();
					btnNo.hide();
					lblNewLabel.setText("Dummmyyy <3");
					lblNewLabel.setLocation(6, 100);
					lblNewLabel.setVisible(true);
				}
			}
		});
		btnYesButton.setBounds(57, 134, 104, 65);
		frame.getContentPane().add(btnYesButton);
		
		btnNo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
            	if (state) {
	                int Xmax = frame.getWidth()-105;
	                int Ymax = frame.getHeight()-100;
	                int randX = rand.nextInt(Xmax);
	                int randY = rand.nextInt(Ymax);
	                btnNo.setLocation(randX, randY);
            	}
            }
            @Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					btnYesButton.hide();
					btnNo.hide();
					lblNewLabel.setText("Smartyyy 😍");
					lblNewLabel.setLocation(6, 100);
					
				}
			}
		});
		btnNo.setBounds(277, 134, 104, 65);
		frame.getContentPane().add(btnNo);
	}
}
