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

public class ClassSlide8 implements ActionListener{
	
	private JFrame subFrame2 = new JFrame("Answers for slide 8");
	private JButton bExit = new JButton("Back to main menu");
	
	public ClassSlide8() {
	
	double A = 0, B = 0; // cannot define them in the try method to then be used later on.
	boolean validInput = false;
	while (!validInput) { // keeps on repeating until we have a valid input.
		String input = JOptionPane.showInputDialog(null, "Enter A: ", "Input Number A", -1);
		/* null: Use a new default frame centered in the screen.
		 * "Enter A: ": The label.
		 * "Input Number A": The title.
		 * -1 = PLAIN_TEXT (Read JOptionPane documentation and 
		 * https://docs.oracle.com/javase/7/docs/api/constant-values.html#javax.swing.JOptionPane.PLAIN_MESSAGE ).
		 */
		if(input != null) { // OK is pressed
			try { 	// Checking if input is valid
				double tmp = Double.parseDouble(input); 
				A = tmp;
				validInput = true;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "You need to input a number!", "Invalid Input", JOptionPane.WARNING_MESSAGE); 
			}
		}else { 	// Cancel or the X button is pressed
			break; 	// Skip this dialogue only, putting A = 0
		}
	}
	
	validInput = false;
	while (!validInput) {
		String input = JOptionPane.showInputDialog(null, "Enter B: ", "Input Number B", -1);
		if(input != null) {
			try {
				double tmp = Double.parseDouble(input); 
				B = tmp;
				validInput = true;
			}catch(NumberFormatException f) {
				JOptionPane.showMessageDialog(null, "You need to input an integer!", "Invalid Input", JOptionPane.WARNING_MESSAGE); 
			}
		}else {
			break;
		}
	}
		
	String H, L;     	// High and Low numbers (String)
	double b = 0, s = 0;// Big and Small numbers (Decimal)
	// Doing the comparison (the process below can be done in a much simpler way)
	if(A < B) {
		H = "B";
		L = "A";
		b = B;
		s = A;
	}else { 
	/* Keep in mind in the flowchart example, there is no possibility for A = B
	 * Then in this case, if A = B it will go into the else condition with A > B
	 */
		H = "A";
		L = "B";
		b = A;
		s = B;
	}
	
	JPanel subPanel2 = new JPanel();
	bExit.addActionListener(this);
	
	JLabel labela = new JLabel("A = " + A);
	JLabel labelb = new JLabel("B = " + B);
	JLabel labelend = new JLabel("Then, " + H + " = " + b + " is the BIG number and " + L + " = " + s + " is the SMALL number");
	
	subPanel2.setBorder(BorderFactory.createEmptyBorder(0,20,10,30));
	subPanel2.setLayout(new GridLayout(5,1));
	subPanel2.add(labela);
	subPanel2.add(labelb);
	subPanel2.add(labelend);
	subPanel2.add(bExit);
	
	subFrame2.add(subPanel2,BorderLayout.CENTER);
	subFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	subFrame2.pack();
	subFrame2.setLocationRelativeTo(null);
	subFrame2.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		subFrame2.dispose();
		new MainClass();
	}
}