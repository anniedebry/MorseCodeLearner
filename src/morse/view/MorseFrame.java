package morse.view;

import morse.controller.MorseController;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent; 

public class MorseFrame extends JFrame
{
	private MorseController app;
	private MorsePanel menuPanel;
	private JPanel cardPanel;
	public SentencesPanel sentencesPanel;
	public AlphabetPanel alphabetPanel;
	public WordPanel wordPanel;
	
	public MorseFrame(MorseController app) {
		super();
		this.app = app;
		
		
		this.menuPanel = new MorsePanel(this.app);
		this.cardPanel = new JPanel(new CardLayout());
		this.sentencesPanel = new SentencesPanel(this.app);
		this.alphabetPanel = new AlphabetPanel(this.app);
		this.wordPanel = new WordPanel(this.app);
		
		setupFrame();
	}
	
	public void changeScreen(String screen) {
		((CardLayout) cardPanel.getLayout()).show(cardPanel, screen);
	}
	
	
	private void setupFrame() {
		
		//card layout setup
		
		cardPanel.add(menuPanel, "Menu");
		cardPanel.add(sentencesPanel, "Sentences"); 
		cardPanel.add(alphabetPanel, "Alphabet");
		cardPanel.add(wordPanel, "Words");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(cardPanel);
		this.setSize(800, 600);
		this.setResizable(false);
		this.setTitle("Morse Code Learner");
		this.setVisible(true);
	}
	
}
