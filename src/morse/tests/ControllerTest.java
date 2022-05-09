package morse.tests;

import morse.controller.MorseController;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UpdateControllerTest
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
	void testBuildPokedexText()
	{
		assertTrue(testedController != null, "Can't be null");
	}

	@Test
	void testGetPokemonData()
	{
		assertEquals("Description", testedController.toString(), "Words match");
	}

}
