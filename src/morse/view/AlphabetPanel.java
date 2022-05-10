package morse.view;

import morse.controller.MorseController;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Dimension; 
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AlphabetPanel extends JPanel
{
	private MorseController controller;
	private SpringLayout layout;
	private JTextArea alphabetArea;
	private JScrollPane alphabetPane;
	private JTextField alphabetField;
	private JPanel ioPanel;
	private JButton submit;
	private JButton start;
	private JButton back;

	public AlphabetPanel(MorseController controller) {
		super();
		this.controller = controller;
		this.layout = new SpringLayout();
		
		this.alphabetField = new JTextField("Type here", 50);
		this.alphabetPane = new JScrollPane();
		this.alphabetArea = new JTextArea("Welcome to the Morse Code Alphabet, characters will be presented to you in either morse code or as letters, please type in the corresponding letter or morse code. For example: "
				+ "if the screen displays A please type in .-  , and visversa" + "\n" + "Press start to receive morse to de-code" + "\n" + "---------------" + "\n",  20, 40);
		
		alphabetArea.setEditable(false);
		this.ioPanel = new JPanel(new GridLayout(1, 0));
		this.submit = new JButton("Submit");
		this.start = new JButton("Start");
		this.back = new JButton("Back");
		layout.putConstraint(SpringLayout.NORTH, start, 6, SpringLayout.SOUTH, submit);
		layout.putConstraint(SpringLayout.WEST, start, 0, SpringLayout.WEST, submit);
		layout.putConstraint(SpringLayout.EAST, start, 75, SpringLayout.WEST, submit);
		
		setupPanel();
		setupAlphabetPane();
		setupLayout();
		setupListeners();

	}
	
	private void setupPanel() {
		this.setLayout(layout);
		this.add(ioPanel);
		this.add(alphabetPane);
		this.add(alphabetField);
		this.add(submit);
		this.add(start);
		this.add(back);

	}
	
	private void setupAlphabetPane() {
		
		alphabetArea.setLineWrap(true);
		alphabetArea.setWrapStyleWord(true);
		alphabetArea.setEnabled(false);
		
		alphabetPane.setViewportView(alphabetArea);
		alphabetPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		alphabetPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	}
	
	private void setupListeners() {
		submit.addActionListener(click -> alphabetArea.append(controller.interactWithMorseCodeAlphabet(alphabetField.getText())));
		start.addActionListener(click -> alphabetArea.append(controller.processMorseCodeAlphabet(alphabetField.getText())));
		back.addActionListener(click -> controller.getFrame().changeScreen("Menu"));
	}
	
	private void setupLayout() {
		layout.putConstraint(SpringLayout.WEST, alphabetField, 15, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, alphabetField, 21, SpringLayout.SOUTH, alphabetPane);
		layout.putConstraint(SpringLayout.NORTH, alphabetPane, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, alphabetPane, 15, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, alphabetPane, -100, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, alphabetPane, -40, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.EAST, alphabetField, -175, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, submit, 0, SpringLayout.NORTH, alphabetField);
		layout.putConstraint(SpringLayout.WEST, submit, 6, SpringLayout.EAST, alphabetField);
	}
}
