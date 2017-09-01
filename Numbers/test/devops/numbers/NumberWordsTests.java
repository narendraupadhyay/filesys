package devops.numbers;

import org.junit.*;

import devops.numbers.NumberWords;

public class NumberWordsTests {
	private NumberWords numberWords ;
	
	@Before
	public void setup() {
		numberWords = new NumberWords() ;
	}

	@Test
	public void numberOutOfRangeReturnsError() {
		Assert.assertEquals( "Error", "Number is -ve or 0", numberWords.toWords( -1 ) ) ;
	}

	@Test
	public void positveNumber() {
		Assert.assertEquals("One", "one hundred", numberWords.toWords(100)) ;
	}
	
	@Test
	public void AnotherpositveNumber() {
		Assert.assertEquals("One", "one thousand twenty five", numberWords.toWords(1025)) ;
	}
}
