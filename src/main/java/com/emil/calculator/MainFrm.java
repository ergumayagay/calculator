package com.emil.calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SpringBootApplication
public class MainFrm {
	
	@Autowired
	private CalculatorClient client;

	private JFrame frame;
	private JTextField txtAns;
	private JButton btnTest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(MainFrm.class).headless(false).run(args);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm window = ctx.getBean(MainFrm.class);
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
	public MainFrm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 832, 563);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = client.add(1, 2).getAddResult();
				txtAns.setText(Integer.toString(ans));
			}
		});
		btnTest.setBounds(71, 128, 115, 29);
		frame.getContentPane().add(btnTest);
		
		txtAns = new JTextField();
		txtAns.setBounds(26, 16, 574, 26);
		frame.getContentPane().add(txtAns);
		txtAns.setColumns(10);
	}
	public JTextField getTxtAns() {
		return txtAns;
	}
	public JButton getBtnTest() {
		return btnTest;
	}
	
	
}
