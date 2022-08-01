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

public class ClassSlide9 implements ActionListener{
	
	private JFrame subFrame3 = new JFrame("Answers for slide 9");
	private JButton bExit = new JButton("Back to main menu");
	
	public ClassSlide9() {
	
	int amountOfReadings = 0;
	boolean validInput = false;
	while (!validInput) { // keeps on repeating until we have a valid input.
		String input = JOptionPane.showInputDialog(null,"Enter n (amount of readings): ", "Input number of readings", -1);
		/* null: Use a new default frame centered in the screen.
		 * "Enter n (amount of readings): ": The label.
		 * "Input number of readings": The title.
		 * -1 = PLAIN_TEXT (Read JOptionPane documentation and 
		 * https://docs.oracle.com/javase/7/docs/api/constant-values.html#javax.swing.JOptionPane.PLAIN_MESSAGE ).
		 */
		if(input != null) { // OK is pressed
			try {	// Checking if input is valid
				int tmp = Integer.parseInt(input); 
				amountOfReadings = tmp;
				validInput = true;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "You need to input an integer!", "Invalid Input", JOptionPane.WARNING_MESSAGE);
			}
		}else { 	// Cancel or the X button is pressed
			break; 	// Skip this dialogue only, putting A = 0
		}
	}
	
	double sum = 0;
	int counter = 0;
	while(counter < amountOfReadings) {
		double analogVal = 0;
		validInput = false;
		while (!validInput) {
			String input = JOptionPane.showInputDialog("Value " + (counter + 1) + " = ");
			if(input != null) {
				try {
					double a = Double.parseDouble(input); 
					analogVal = a;
					validInput = true;
				}catch(NumberFormatException f) {
					JOptionPane.showMessageDialog(null, "You need to input an integer!", "Invalid Input", JOptionPane.WARNING_MESSAGE); 
				}
			}else {
				break;
			}
		}
		sum = sum + analogVal;
		counter++;
	}
	
	double Average = sum/amountOfReadings;
	/* In the flowchart, the "Average = sum/n" bloc is a rectangle which means it is supposed to
	 * process and not output anything, but for the aesthetics of the program, we will add an output
	 */

	JPanel subPanel3 = new JPanel();
	bExit.addActionListener(this);
	
	JLabel labela = new JLabel("Amount of values used " + amountOfReadings);
	JLabel labelb = new JLabel("Average of all analog values = " + Average);
	
	subPanel3.setBorder(BorderFactory.createEmptyBorder(0,25,20,60));
	subPanel3.setLayout(new GridLayout(3,1));
	subPanel3.add(labela);
	subPanel3.add(labelb);
	subPanel3.add(bExit);
	
	subFrame3.add(subPanel3,BorderLayout.CENTER);
	subFrame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	subFrame3.pack();
	subFrame3.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		subFrame3.dispose();
		new MainClass();
	}
}