package morse.view;

import morse.controller.MorseController;

import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MorsePanel extends JPanel
{

	private MorseController controller;
	private SpringLayout layout;
	private JButton alphabet;
	private JButton seperation;
	private JButton words;
	private JButton sentences; 
	private JPanel menuPanel; 
	private ImageIcon titleImage;
	private JLabel imageLabel;
	
	public MorsePanel(MorseController controller) {
		super();
		this.controller = controller; 
		this.layout = new SpringLayout();
		this.menuPanel = new JPanel(new GridLayout(0, 1));
		this.titleImage = new ImageIcon();
		this.imageLabel = new JLabel("");
		
		setupPanel();
		setupListeners();
		setupLayout(); 
		updateDisplay();
	}
	
	public void setupPanel() {
		this.setLayout(layout);
		this.add(menuPanel);
		this.sentences = new JButton("Sentences");
		this.words = new JButton("Words");
		this.seperation = new JButton("Seperation");
		this.alphabet = new JButton("Alphabet");
		this.add(imageLabel);
		
	}
	
	private void updateDisplay() {
		String path = "/morse/view/images/";
		String defaultName = "morseCodeTitle";
		String extension = ".jpg";
		
		try {
			titleImage = new ImageIcon(getClass().getResource(path + extension));
		}
		catch(NullPointerException missingFile){
			titleImage = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		
		imageLabel.setIcon(titleImage);
	}
	
	public void setupListeners() {
		//((MorseFrame)this.getParent().getParent()).changeScreen("screen to change to");
		
		sentences.addActionListener(click -> controller.getFrame().changeScreen("Sentences"));
		alphabet.addActionListener(click -> controller.getFrame().changeScreen("Alphabet"));
	}
	
	public void setupLayout() {
		layout.putConstraint(SpringLayout.NORTH, sentences, -124, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, sentences, 208, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, sentences, -60, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, sentences, -218, SpringLayout.EAST, this);
		add(sentences);
		layout.putConstraint(SpringLayout.NORTH, words, -80, SpringLayout.NORTH, sentences);
		layout.putConstraint(SpringLayout.WEST, words, 0, SpringLayout.WEST, sentences);
		layout.putConstraint(SpringLayout.SOUTH, words, -16, SpringLayout.NORTH, sentences);
		layout.putConstraint(SpringLayout.EAST, words, 0, SpringLayout.EAST, sentences);
		add(words);
		layout.putConstraint(SpringLayout.NORTH, seperation, -88, SpringLayout.NORTH, words);
		layout.putConstraint(SpringLayout.WEST, seperation, 0, SpringLayout.WEST, sentences);
		layout.putConstraint(SpringLayout.SOUTH, seperation, -24, SpringLayout.NORTH, words);
		layout.putConstraint(SpringLayout.EAST, seperation, 0, SpringLayout.EAST, sentences);
		add(seperation);
		layout.putConstraint(SpringLayout.NORTH, alphabet, -86, SpringLayout.NORTH, seperation);
		layout.putConstraint(SpringLayout.WEST, alphabet, 213, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, alphabet, -22, SpringLayout.NORTH, seperation);
		layout.putConstraint(SpringLayout.EAST, alphabet, 0, SpringLayout.EAST, sentences);
		layout.putConstraint(SpringLayout.SOUTH, imageLabel, -49, SpringLayout.NORTH, alphabet);
		add(alphabet);
		layout.putConstraint(SpringLayout.EAST, imageLabel, -248, SpringLayout.EAST, this);
	}
	
}
