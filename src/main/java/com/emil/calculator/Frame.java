package com.emil.calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import calculator.wsdl.AddResponse;

@SpringBootApplication
public class Frame extends JFrame {
	private static final long serialVersionUID = 1907887853617040543L;

	private JTextField input;
	
	@Autowired 
	private CalculatorClient client;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Frame.class).headless(false).run(args);
		Frame frame = ctx.getBean(Frame.class);
		frame.run();
	}
	
	private void run() {
		
		setResizable(false);
		setTitle("Calculator");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel contentPane = new JPanel();
				
		GridBagLayout grid = new GridBagLayout();
		grid.columnWeights =  new double[] {};
		grid.columnWidths = new int[] {100,100,100,100};
		grid.rowWeights = new double[] {};
		grid.rowHeights = new int[] {50,100,100,100,100};
		
		contentPane.setLayout(grid);
		setContentPane(contentPane);

		Font btnFont = new Font("Arial", 0, 20);
		
		JButton btn1 = new JButton("1");
		btn1.setFont(btnFont);
		btn1.addActionListener(new BtnAction());
		JButton btn2 = new JButton("2");
		btn2.setFont(btnFont);
		btn2.addActionListener(new BtnAction());
		JButton btn3 = new JButton("3");
		btn3.setFont(btnFont);
		btn3.addActionListener(new BtnAction());
		JButton btn4 = new JButton("4");
		btn4.setFont(btnFont);
		btn4.addActionListener(new BtnAction());
		JButton btn5 = new JButton("5");
		btn5.setFont(btnFont);
		btn5.addActionListener(new BtnAction());
		JButton btn6 = new JButton("6");
		btn6.setFont(btnFont);
		btn6.addActionListener(new BtnAction());
		JButton btn7 = new JButton("7");
		btn7.setFont(btnFont);
		btn7.addActionListener(new BtnAction());
		JButton btn8 = new JButton("8");
		btn8.setFont(btnFont);
		btn8.addActionListener(new BtnAction());
		JButton btn9 = new JButton("9");
		btn9.setFont(btnFont);
		btn9.addActionListener(new BtnAction());
		JButton btn0 = new JButton("0");
		btn0.setFont(btnFont);
		btn0.addActionListener(new BtnAction());
		
		JButton btnAdd = new JButton("+");
		btnAdd.setFont(btnFont);
		btnAdd.addActionListener(new BtnAction());
		JButton btnSub = new JButton("-");
		btnSub.setFont(btnFont);
		btnSub.addActionListener(new BtnAction());
		JButton btnMul = new JButton("*");
		btnMul.setFont(btnFont);
		btnMul.addActionListener(new BtnAction());
		JButton btnDiv = new JButton("/");
		btnDiv.setFont(btnFont);
		btnDiv.addActionListener(new BtnAction());
		JButton btnDot = new JButton(".");
		btnDot.setFont(btnFont);
		btnDot.addActionListener(new BtnAction());
		JButton btnEq  = new JButton("=");
		btnEq.setFont(btnFont);
		btnEq.addActionListener(new EqualsAction());

		input = new JTextField();
		input.setPreferredSize(new Dimension(300, 50));
		input.setFont(new Font("Arial", 1, 20));
		input.setEditable(false);

		GridBagConstraints gridCon = new GridBagConstraints();
		
		gridCon.fill = GridBagConstraints.BOTH;
		
		//First row
		gridCon.gridx = 0;
		gridCon.gridy = 1;
		contentPane.add(btn1, gridCon);
		
		gridCon.gridx = 1;
		gridCon.gridy = 1;
		contentPane.add(btn2, gridCon);
		
		gridCon.gridx = 2;
		gridCon.gridy = 1;
		contentPane.add(btn3, gridCon);
		
		gridCon.gridx = 3;
		gridCon.gridy = 1;
		contentPane.add(btnDiv, gridCon);
		
		//Second Row
		gridCon.gridx = 0;
		gridCon.gridy = 2;
		contentPane.add(btn4, gridCon);
		
		gridCon.gridx = 1;
		gridCon.gridy = 2;
		contentPane.add(btn5, gridCon);
		
		gridCon.gridx = 2;
		gridCon.gridy = 2;
		contentPane.add(btn6, gridCon);
		
		gridCon.gridx = 3;
		gridCon.gridy = 2;
		contentPane.add(btnMul, gridCon);
		
		//Third Row
		gridCon.gridx = 0;
		gridCon.gridy = 3;
		contentPane.add(btn7, gridCon);
		
		gridCon.gridx = 1;
		gridCon.gridy = 3;
		contentPane.add(btn8, gridCon);
		
		gridCon.gridx = 2;
		gridCon.gridy = 3;
		contentPane.add(btn9, gridCon);
		
		gridCon.gridx = 3;
		gridCon.gridy = 3;
		contentPane.add(btnSub, gridCon);
		
		//Fourth Row
		gridCon.gridx = 0;
		gridCon.gridy = 4;
		contentPane.add(btn0, gridCon);
		
		gridCon.gridx = 1;
		gridCon.gridy = 4;
		contentPane.add(btnDot, gridCon);
		
		gridCon.gridx = 2;
		gridCon.gridy = 4;
		contentPane.add(btnEq, gridCon);
		
		gridCon.gridx = 3;
		gridCon.gridy = 4;
		contentPane.add(btnAdd, gridCon);
		
		//Input
		GridBagConstraints inputCon = new GridBagConstraints();
		inputCon.gridx = 0;
		inputCon.gridy = 0;
		inputCon.gridwidth = 4;
		contentPane.add(input, inputCon);
		
		pack();
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screen = kit.getScreenSize();
		
		int posX = (int)((screen.getWidth() - getWidth()) / 2);
		int posY = (int)((screen.getHeight() - getHeight()) / 2);
		
		setLocation(posX, posY);
		
		setVisible(true);
	}
	
	private class BtnAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JButton btn = (JButton)arg0.getSource();
			input.setText(input.getText() + btn.getText());
		}
		
		
	}
	
	private class EqualsAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String inputText = input.getText();
			input.setText(compute(inputText));
		}
		
		private String compute(String inputText) {
			Queue<String> operator = new LinkedList<>();
			Queue<Integer> operands = new LinkedList<>();
			
			String digit = "";
			for (int x = 0; x < inputText.length(); x++) {
				try{
					Integer.parseInt(String.valueOf(inputText.charAt(x)));
					digit += String.valueOf(inputText.charAt(x));
				} catch(NumberFormatException nfe) {
					operator.add(String.valueOf(inputText.charAt(x)));
					operands.add(Integer.parseInt(digit));
					digit = "";
				}
			}
			operands.add(Integer.parseInt(digit));
			
			int digit1 =  (operands.peek() != null) ? operands.poll() : 0;;
			int digit2 = 0;
			while (!operator.isEmpty()) {
				digit2 = (operands.peek() != null) ? operands.poll() : 0;
				
				switch (operator.poll()) {
				case "+":
					digit1 = client.add(digit1, digit2).getAddResult();
					break;
				case "-":
					digit1 = client.subtract(digit1, digit2).getSubtractResult();
					break;
				case "*":
					digit1 = client.multiply(digit1, digit2).getMultiplyResult();
					break;
				case "/":
					if (digit2 != 0) digit1 = client.divide(digit1, digit2).getDivideResult();
					else System.out.println("Cannot divide by 0");
					break;
				}
			}
			
			int output = digit1;
			return Integer.toString(output);
		}
	}
}
