// You can just import java.awt.* and javax.swing.*
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ClassSlide7 implements ActionListener { // Implement ActionListener to be able to go back to Main Menu (MainClass)
	
	private JFrame subFrame1 = new JFrame("Answers for slide 7");
	private JButton bExit = new JButton("Back to main menu");
	
	public ClassSlide7() {
	
	double X = 0, Y = 0, Z = 0; // cannot define them in the try method to then be used later on.
	boolean validInput = false;
	while (!validInput) { // keeps on repeating until we have a valid input.
		String input = JOptionPane.showInputDialog(null, "Enter X: ", "Input X", -1); 
		/* null: Use a new default frame centered in the screen.
		 * "Enter X: ": The label.
		 * "Input X": The title.
		 * -1 = PLAIN_TEXT (Read JOptionPane documentation and 
		 * https://docs.oracle.com/javase/7/docs/api/constant-values.html#javax.swing.JOptionPane.PLAIN_MESSAGE ).
		 */
		if(input != null) { // OK is pressed
			try { 	// Checking if input is valid.
				double tmp = Double.parseDouble(input); 
				X = tmp;
				validInput = true;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "You need to input a number!", "Invalid Input", JOptionPane.WARNING_MESSAGE); 
			}
		}else { 	// Cancel or the X button is pressed
			break; 	// Skip this dialogue only, putting X = 0
		}
	}
	
	validInput = false;
	while (!validInput) {
		String input = JOptionPane.showInputDialog(null, "Enter Y: ", "Input Y", -1);
		if(input != null) {
			try {
				double tmp = Double.parseDouble(input); 
				Y = tmp;
				validInput = true;
			}catch(NumberFormatException f) {
				JOptionPane.showMessageDialog(null, "You need to input a number!", "Invalid Input", JOptionPane.WARNING_MESSAGE); 
			}
		}else {
			break;
		}
	}
	
	validInput = false;
	while (!validInput) {
		String input = JOptionPane.showInputDialog(null, "Enter Z: ", "Input Z", -1);
		if(input != null) {
			try {
				double tmp = Double.parseDouble(input); 
				Z = tmp;
				validInput = true;
			}catch(NumberFormatException g) {
				JOptionPane.showMessageDialog(null, "You need to input a number!", "Invalid Input", JOptionPane.WARNING_MESSAGE); 
			}
		}else {
			break;
		}
	}
	
	double S = X + Y + Z; // Sum
	double A = (S/3);     // Average
	double P = X * Y * Z; // Product
		
	JPanel subPanel1 = new JPanel();
	bExit.addActionListener(this);
	
	JLabel label1 = new JLabel("X = " + X);
	JLabel label2 = new JLabel("Y = " + Y);
	JLabel label3 = new JLabel("Z = " + Z);
	JLabel label4 = new JLabel("The answers are: ");
	JLabel label5 = new JLabel("Sum(X,Y,Z) = " + S);
	JLabel label6 = new JLabel("Avg(X,Y,Z) = " + A);
	JLabel label7 = new JLabel("Prd(X,Y,Z) = " + P);
	subPanel1.setBorder(BorderFactory.createEmptyBorder(0,30,10,50));
	subPanel1.setLayout(new GridLayout(8,1));
	
	subPanel1.add(label1);
	subPanel1.add(label2);
	subPanel1.add(label3);
	subPanel1.add(label4);
	subPanel1.add(label5);
	subPanel1.add(label6);	
	subPanel1.add(label7);
	subPanel1.add(bExit);
	
	subFrame1.add(subPanel1,BorderLayout.CENTER);
	subFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	subFrame1.pack();
	subFrame1.setLocationRelativeTo(null);
	subFrame1.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		subFrame1.dispose();
		new MainClass();
	}
}