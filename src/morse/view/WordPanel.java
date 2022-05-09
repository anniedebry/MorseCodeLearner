package morse.view;

import morse.controller.MorseController;
import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;

public class WordPanel extends JPanel
{
	private MorseController controller;
	private SpringLayout layout;
	private JTextArea wordArea;
	private JScrollPane wordPane;
	private JTextField wordField;
	private JPanel ioPanel;
	private JButton submit;
	private JButton start;
	
	public WordPanel(MorseController controller) {
		super();
		this.controller = controller;
		this.layout = new SpringLayout();
		
		this.wordField = new JTextField("Type here", 50);
		this.wordPane = new JScrollPane();
		this.wordArea = new JTextArea("Welcome to the Morse Code Words, characters will be presented to you in morse code , please type in the corresponding letters which will form a word.  "
				+ "\n" + "Press start to receive morse to de-code" + "\n" + "---------------" + "\n",  20, 40);
		
		wordArea.setEditable(false);
		this.ioPanel = new JPanel(new GridLayout(1, 0));
		this.submit = new JButton("Submit");
		this.start = new JButton("Start");
		
		setupPanel();
		setupAlphabetPane();
		setupLayout();
		setupListeners();

	}
	
	private void setupPanel() {
		this.setLayout(layout);
		this.add(ioPanel);
		this.add(wordPane);
		this.add(wordField);
		this.add(submit);
		this.add(start);

	}
	
	private void setupAlphabetPane() {
		
		wordArea.setLineWrap(true);
		wordArea.setWrapStyleWord(true);
		wordArea.setEnabled(false);
		
		wordPane.setViewportView(wordArea);
		wordPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		wordPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	}
	
	private void setupListeners() {
		submit.addActionListener(click -> wordArea.append(controller.interactWithMorseCodeAlphabet(wordField.getText())));
		start.addActionListener(click -> wordArea.append(controller.processMorseCodeAlphabet(wordField.getText())));
	}
	
	private void setupLayout() {
		layout.putConstraint(SpringLayout.WEST, wordField, 15, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, wordField, 21, SpringLayout.SOUTH, wordPane);
		layout.putConstraint(SpringLayout.NORTH, wordPane, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, wordPane, 15, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, wordPane, -100, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, wordPane, -40, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.EAST, wordField, -175, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, submit, 0, SpringLayout.NORTH, wordField);
		layout.putConstraint(SpringLayout.WEST, submit, 6, SpringLayout.EAST, wordField);
		layout.putConstraint(SpringLayout.NORTH, start, 6, SpringLayout.SOUTH, submit);
		layout.putConstraint(SpringLayout.WEST, start, 0, SpringLayout.WEST, submit);
		layout.putConstraint(SpringLayout.EAST, start, 75, SpringLayout.WEST, submit);
	}
}
