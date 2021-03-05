package poc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

import static org.mockito.Mockito.*;

import java.util.Set;

public class FindWordsTest {
	Dictionary mockedDict = mock(Dictionary.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		when(mockedDict.isEnglishWord("dog")).thenReturn(true);
		when(mockedDict.isEnglishWord("cat")).thenReturn(true);
		when(mockedDict.isEnglishWord("at")).thenReturn(true);
		when(mockedDict.isEnglishWord("tac")).thenReturn(true);
		when(mockedDict.isEnglishWord("god")).thenReturn(true);
		when(mockedDict.isEnglishWord("taco")).thenReturn(true);
		when(mockedDict.isEnglishWord("toad")).thenReturn(true);
		when(mockedDict.isEnglishWord("toga")).thenReturn(true);
		when(mockedDict.isEnglishWord("tacgod")).thenReturn(true);
		when(mockedDict.isEnglishWord("nope")).thenReturn(true);
		when(mockedDict.isEnglishWord("dang")).thenReturn(true);
		when(mockedDict.isEnglishWord("7")).thenReturn(true);
	}

	@Test
	public void simple_word() {
		FindWords fw = new FindWords(mockedDict);
		Set<String> wordsFound = fw.findWords("dogcat");
		assertTrue(9 == wordsFound.size());
	}
	
	@Test
	public void space_in_word() {
		FindWords fw = new FindWords(mockedDict);
		Set<String> wordsFound = fw.findWords("da ng");
		assertTrue(1 == wordsFound.size());
	}
	
	@Test
	public void number_in_word() {
		FindWords fw = new FindWords(mockedDict);
		Set<String> wordsFound = fw.findWords("6taco");
		assertTrue(4 == wordsFound.size());
	}
	
	@Test
	public void 	number_as_word() {
		FindWords fw = new FindWords(mockedDict);
		Set<String> wordsFound = fw.findWords("7");
		assertTrue(1 == wordsFound.size());
	}
	
	@Test
	public void 	no_words_found() {
		FindWords fw = new FindWords(mockedDict);
		Set<String> wordsFound = fw.findWords("zebra");
		assertTrue(0 == wordsFound.size());
	}
}
