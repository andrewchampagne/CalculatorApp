import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
	
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	
	JButton addButton, subButton, multButton, divButton;
	JButton decButton, eqButton, delButton, clrButton, negButton;
	JPanel panel;
	
	Font myFont = new Font("Courier", Font.BOLD,25);
	
	
	double num1 = 0, num2 = 0, result=0;
	char operator;
	
	
	Calculator(){
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.getContentPane().setBackground(new java.awt.Color(117, 89, 145));
		frame.setLayout(null);
		
		
		
		textfield = new JTextField();
		textfield.setBounds(50,25,300,50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		textfield.setBackground(new java.awt.Color(209, 177, 240));
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		multButton = new JButton("x");
		divButton = new JButton("/");
		decButton = new JButton(".");
		eqButton = new JButton("=");
		delButton = new JButton("Del.");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = multButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = eqButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		for(int i = 0; i<9; i ++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
			
		}
		
		for(int i= 0; i < 10; i++) {
			
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			
		}
		addButton.setBackground(new java.awt.Color(235, 75, 63));
		numberButtons[1].setBackground(new java.awt.Color(240, 139, 46));
		numberButtons[2].setBackground(new java.awt.Color(242, 222, 36));
		numberButtons[3].setBackground(new java.awt.Color(64, 189, 23));
		subButton.setBackground(new java.awt.Color(42, 161, 107));
		numberButtons[4].setBackground(new java.awt.Color(42, 161, 157));
		numberButtons[5].setBackground(new java.awt.Color(91, 191, 245));
		numberButtons[6].setBackground(new java.awt.Color(71, 164, 245));
		multButton.setBackground(new java.awt.Color(77, 101, 240));
		numberButtons[7].setBackground(new java.awt.Color(80, 42, 161));
		numberButtons[8].setBackground(new java.awt.Color(115, 42, 161));
		numberButtons[9].setBackground(new java.awt.Color(149, 42, 161));
		divButton.setBackground(new java.awt.Color(151, 113, 171));
		numberButtons[0].setBackground(new java.awt.Color(219, 134, 211));
		decButton.setBackground(new java.awt.Color(161, 42, 133));
		eqButton.setBackground(new java.awt.Color(161, 42, 86));
		
		negButton.setBounds(50,430,100,50);
		delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);
		
		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(new java.awt.Color(25, 23, 26));
		
		panel.add(addButton);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(subButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(multButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(divButton);
		panel.add(numberButtons[0]);
		panel.add(decButton);
		panel.add(eqButton);
		
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.add(panel);
		frame.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();

	}
	
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 10; i ++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
				
			}
		}
		if(e.getSource() == decButton){
			textfield.setText(textfield.getText().concat("."));
			
		}
		if(e.getSource() == addButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");//clears the textfield
		}	
		if(e.getSource() == subButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");//clears the textfield

		}
		if(e.getSource() == multButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = 'x';
			textfield.setText("");//clears the textfield
		
		}
		if(e.getSource() == divButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");//clears the textfield
		
		}
		if(e.getSource() == eqButton) {
			
			num2 = Double.parseDouble(textfield.getText());
			
			switch(operator) {
			
			case'+':
				result = num1 + num2;
				break;
			case'-':
				result = num1 - num2;
				break;
			case'x':
				result = num1 * num2;
				break;
			case'/':
				result = num1 / num2;
				break;
			}
			
			textfield.setText(String.valueOf(result));
			num1 = result;
	
		}
		if(e.getSource() == clrButton) {
			textfield.setText("");
			
		}
		if(e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0; i<string.length()-1;i++){
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource() == negButton) {
			double temporary = Double.parseDouble(textfield.getText());
			temporary*=-1;
			textfield.setText(String.valueOf(temporary));
			
		}
		
	}
}