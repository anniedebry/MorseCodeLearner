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
	
	public String interactWithMorseCodeSentences(String text) {
		String response = "";
		
		response += chat.processTextSentences(text) + "/n";
		
		return response;
	}
	
	public String interactWithMorseCodeAlphabet(String text) {
		String response = "";
		
		response += chat.processTextAlphabet(text);
		
		return response;
	}
	
	
	public void handleError(Exception error) {
		JOptionPane.showMessageDialog(frame, error.getMessage(), "Morse Code Error!", JOptionPane.ERROR_MESSAGE);
	}
	
	public MorseFrame getFrame() {
		return frame;
	}
}
