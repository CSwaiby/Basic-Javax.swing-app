import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainClass{

	private JFrame frame = new JFrame("Main Menu");
	private JButton button1 = new JButton("Example of slide 7");
	private JButton button2 = new JButton("Example of slide 8");
	private JButton button3 = new JButton("Example of slide 9");
	
	public MainClass() {
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae1) {
				frame.dispose();
				new ClassSlide7();
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae2) {
				frame.dispose();
				new ClassSlide8();
			}
		});
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae3) {
				frame.dispose();
				new ClassSlide9();
			}
		});
		
		JLabel label = new JLabel("Choose which example: ");
		
		panel.setBorder(BorderFactory.createEmptyBorder(0,45,20,45));
		panel.setLayout(new GridLayout(0,1));
		panel.add(label);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
	}
	
    public static void main(final String[] args) {
      new MainClass();  
    	
    }
}