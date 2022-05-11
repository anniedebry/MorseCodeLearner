package morse.controller;

import java.util.ArrayList;
import morse.model.MorseChat;

import javax.swing.JOptionPane;
import morse.view.MorseFrame;

public class MorseController
{
	private MorseFrame frame;
	private MorseChat chat;
	
	public MorseController() {
		this.chat = new MorseChat();
		frame = new MorseFrame(this);
	}
	
	public void start() {
		JOptionPane.showMessageDialog(frame, "Welcome to Morse Code Learner!");
	}
	
	public String processMorseCodeSentences(String text) {
		String response = "";
		
		response += chat.sentenceMap() + ("\n");
		
		return response;
	}
	
	public String interactWithMorseCodeSentences(String text) {
		String response = "";
		
		response += chat.processTextSentences(text) + "\n";
		
		return response;
	}
	
	public String processMorseCodeAlphabet(String text) {
		String response = "";
		
		response += chat.alphabetMap() + ("\n");
		
		return response;
	}
	
	public String interactWithMorseCodeAlphabet(String text) {
		String response = "";
		
		response += chat.processTextAlphabet(text);
		
		return response;
	}
	
	public String processMorseCodeWords(String text) {
		String response = "";
		
		response += chat.processTextWords(text);
		
		return response;
	}
	
	public String interactWithMorseWords(String text) {
		String response = "";
		
		response += chat.wordMap() + ("\n");
		
		return response;
	}
	
	
	public void handleError(Exception error) {
		JOptionPane.showMessageDialog(frame, error.getMessage(), "Morse Code Error!", JOptionPane.ERROR_MESSAGE);
	}
	
	public MorseFrame getFrame() {
		return frame;
	}
}
