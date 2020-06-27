import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main implements ActionListener{
	
	private static JButton button;
	private static JTextArea userText;
	private static JLabel enterText;
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel showWords;
	private static JLabel title;
	
	public static void main(String[] args) {
		
		panel = new JPanel();
		
		frame = new JFrame();
		frame.setSize(450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		
		panel.setLayout(null);
		
		
		//title
		title = new JLabel("Word Counter");
		title.setBounds(180, 0, 80, 25);
		panel.add(title);
		
		//prompt for user
		enterText = new JLabel("Enter Text: ");
		enterText.setBounds(10, 20, 80, 25);
		panel.add(enterText);
		
		//area for user to type or insert their text
		userText = new JTextArea();
		userText.setBounds(10, 50, 400, 300);
		panel.add(userText);
		
		//button to click once the user is complete and wants to check the number of words
		button = new JButton("Check");
		button.setBounds(10, 370, 80, 25);
		button.addActionListener(new Main());
		panel.add(button);

		//displaying the number of words
		showWords = new JLabel("");
		showWords.setBounds(100, 370, 200, 25);
		panel.add(showWords);
		

		frame.setVisible(true);

	}

	//method using action listener that displays the number of words once the user clicks the button
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String text = userText.getText();
		int characters = text.length();
		
		int numberOfWords = countWords(text);
		showWords.setText(numberOfWords+" word(s). "+characters+" character(s).");
		
	}
	
	//method for counting and returning the number of words entered by the user
		public static int countWords(String s){

		    int count = 0;

		    boolean word = false;
		    int end = s.length() - 1;

		    for (int i = 0; i < s.length(); i++) {
		        
		        if (Character.isLetter(s.charAt(i)) && i != end) {
		            word = true;
		           
		        } else if (!Character.isLetter(s.charAt(i)) && word) {
		            count++;
		            word = false;
		          
		        } else if (Character.isLetter(s.charAt(i)) && i == end) {
		            count++;
		        }
		    }
		    return count;
		}

}
