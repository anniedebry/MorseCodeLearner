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

public class SentencesPanel extends JPanel
{
	private MorseController controller;
	
	private SpringLayout layout;
	private JTextArea sentencesArea;
	private JScrollPane sentencesPane;
	private JTextField sentencesField;
	private JPanel ioPanel;
	private JButton submit;
	private JButton start;
	private JButton back; 

	public SentencesPanel(MorseController controller) {
		super();
		this.controller = controller;
		this.layout = new SpringLayout();
		
		this.sentencesField = new JTextField("Type here", 50);
		this.sentencesPane = new JScrollPane();
		this.sentencesArea = new JTextArea("Sentences are layed out without specific spaces between letters, you must place the spaces where they make the most sense" + "\n" + "---------------------" + "\n", 20, 40);
		sentencesArea.setEditable(false);
		this.ioPanel = new JPanel(new GridLayout(1, 0));
		this.submit = new JButton("Submit");
		this.start = new JButton("Start");
		this.back = new JButton("Back");
		
		setupPanel();
		setupSentencesPane();
		setupLayout();
		setupListeners();

	}
	
	private void setupPanel() {
		this.setLayout(layout);
		this.add(ioPanel);
		this.add(sentencesPane);
		this.add(sentencesField);
		this.add(submit);
		this.add(start);
		this.add(back);

	}
	
	private void setupSentencesPane() {
		
		sentencesArea.setLineWrap(true);
		sentencesArea.setWrapStyleWord(true);
		sentencesArea.setEnabled(false);
		
		sentencesPane.setViewportView(sentencesArea);
		sentencesPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sentencesPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	}
	
	private void setupListeners() {
		submit.addActionListener(click -> sentencesArea.append(controller.interactWithMorseCodeSentences(sentencesField.getText())));
		start.addActionListener(click -> sentencesArea.append(controller.processMorseCodeSentences(sentencesField.getText())));
		back.addActionListener(click -> controller.getFrame().changeScreen("Menu"));
	}
	
	private void setupLayout() {
		layout.putConstraint(SpringLayout.WEST, sentencesField, 15, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, sentencesField, 21, SpringLayout.SOUTH, sentencesPane);
		layout.putConstraint(SpringLayout.NORTH, sentencesPane, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, sentencesPane, 15, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, sentencesPane, -100, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, sentencesPane, -40, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.EAST, sentencesField, -175, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, submit, 0, SpringLayout.NORTH, sentencesField);
		layout.putConstraint(SpringLayout.WEST, submit, 6, SpringLayout.EAST, sentencesField);
		layout.putConstraint(SpringLayout.NORTH, start, 6, SpringLayout.SOUTH, sentencesField);
		layout.putConstraint(SpringLayout.WEST, start, 0, SpringLayout.WEST, submit);
		layout.putConstraint(SpringLayout.NORTH, back, 0, SpringLayout.NORTH, start);
		layout.putConstraint(SpringLayout.WEST, back, 10, SpringLayout.WEST, this);
	}
}
