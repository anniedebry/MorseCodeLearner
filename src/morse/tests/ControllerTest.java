package morse.tests;

import morse.controller.MorseController;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerTest
{
	private MorseController testedController;

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new MorseController();
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController  = null;
	}

	@Test
	void  testInteractWithMorseCodeSentences()
	{
		assertTrue(testedController != null, "Can't be null");
	}

	@Test
	void testProcessMorseCodeAlphabet()
	{
		assertTrue(testedController.getFrame() instanceof JFrame, "getFrame  must return a frame");
	}

}
