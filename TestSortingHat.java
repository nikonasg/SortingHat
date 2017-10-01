import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/*
Download junit:
https://github.com/junit-team/junit4/wiki/Download-and-Install

Build junit
javac -cp "./:junit-4.12.jar:hamcrest-core-1.3.jar" TestSortingHat.java && java -cp "./:junit-4.12.jar:hamcrest-core-1.3.jar" org.junit.runner.JUnitCore TestSortingHat

*/
public class TestSortingHat {

	@Test
	public void test_getHouse1() {
		Map<House, Integer> playerChoiceToFrequency = new HashMap<>();
		playerChoiceToFrequency.put(House.GRYFFINDOR, 1);
		playerChoiceToFrequency.put(House.RAVENCLAW, 4);
		String result = HarryPotterQuiz.getHouse(playerChoiceToFrequency);
		assertEquals("RAVENCLAW", result);
	}

	@Test
	public void test_getHouse2() {
		Map<House, Integer> playerChoiceToFrequency = new HashMap<>();
		playerChoiceToFrequency.put(House.SLYTHERIN, 3);
		playerChoiceToFrequency.put(House.HUFFLEPUFF, 1);
		playerChoiceToFrequency.put(House.GRYFFINDOR, 1);
		String result = HarryPotterQuiz.getHouse(playerChoiceToFrequency);
		assertEquals("SLYTHERIN", result);
	}

	@Test
	public void test_getHouse3() {
		Map<House, Integer> playerChoiceToFrequency = new EnumMap<>(House.class);
		playerChoiceToFrequency.put(House.SLYTHERIN, 1);
		playerChoiceToFrequency.put(House.GRYFFINDOR, 1);
		playerChoiceToFrequency.put(House.HUFFLEPUFF, 1);
		playerChoiceToFrequency.put(House.RAVENCLAW, 1);
		String result = HarryPotterQuiz.getHouse(playerChoiceToFrequency);
		assertEquals("RAVENCLAW", result);
	}
}

