package morse.tests;

import morse.controller.MorseController;
import morse.view.MorsePanel;
import morse.view.MorseFrame;

import java.awt.Component;
/**
 * Reflection imports
 */
import java.lang.reflect.*;

import javax.swing.JFrame;

/**
 * Testing imports
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FrameTest
{
	private MorseController testedController; //Change!
	private MorseFrame testedFrame; //Change!

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new MorseController();
		this.testedFrame = new MorseFrame(testedController);
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController = null;
		this.testedFrame = null;
	}

	@Test
	void testChatFrame()
	{
		assertTrue(testedFrame instanceof JFrame, "... needs to extend JFrame");
		Method [] methods = testedFrame.getClass().getDeclaredMethods();
		assertTrue(methods.length == 1, "You need 1 method in the ChatFrame");
		assertTrue(testedFrame.getTitle().length() > 5, "Your title needs at least 6 letters");
		assertTrue(testedFrame.getContentPane() instanceof MorsePanel, "Your ChatFrame needs to have a ChatPanel inside");  //Change!
	}

}