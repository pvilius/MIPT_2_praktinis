package com.example.mipt_2_praktinis;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WordCharacterCounterTest {

    @Test
    public void Given_SentenceWithMultipleSpaces_When_getCharactersCountIsCalled_Then_ReturnsCorrectCharacterCount() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "This    is     a   sentence   with  multiple spaces.";
        final int expectedResult = 52;
        final int actualResult = counter.getCharactersCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_SentenceWithLeadingAndTrailingSpaces_When_getCharactersCountIsCalled_Then_ReturnsCorrectCharacterCount() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "   This is a sentence with extra spaces   ";
        final int expectedResult = 42;
        final int actualResult = counter.getCharactersCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_SentenceWithPunctuation_When_getCharactersCountIsCalled_Then_ReturnsCorrectCharacterCount() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "Hello, world! How are you?";
        final int expectedResult = 26;
        final int actualResult = counter.getCharactersCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_InputWithSpecialCharacters_When_getCharactersCountIsCalled_Then_ReturnsCorrectCharacterCount() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "!@#$%^&*()";
        final int expectedResult = 10;
        final int actualResult = counter.getCharactersCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_SingleWord_When_getCharactersCountIsCalled_Then_ReturnsCharacterCount() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "Nebeprisikiškiakopūsteliaujantiesiems";
        final int expectedResult = 37;
        final int actualResult = counter.getCharactersCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_InputWithNumbers_When_getCharactersCountIsCalled_Then_ReturnsCorrectCharacterCount() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "123abc456";
        final int expectedResult = 9;
        final int actualResult = counter.getCharactersCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_EmojiText_When_getCharactersCountIsCalled_Then_ReturnsCorrectCharacterCount() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "Emojis 😊 are not words, but count as two characters!";
        final int expectedResult = 53;
        final int actualResult = counter.getCharactersCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_VeryLargeInput_When_getCharactersCountIsCalled_Then_ReturnsCorrectCharacterCount() {
        WordCharacterCounter counter = new WordCharacterCounter();
        StringBuilder largeInput = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            largeInput.append("word ");
        }
        final int expectedResult = 50000;
        final int actualResult = counter.getCharactersCount(largeInput.toString());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_MultilineInput_When_getCharactersCountIsCalled_Then_ReturnsCorrectCharacterCount() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "This is\na multiline input\nwith several characters.";
        final int expectedResult = 50;
        final int actualResult = counter.getCharactersCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_EmptyString_When_getCharactersCountIsCalled_Then_ReturnsZero() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "";
        final int expectedResult = 0;
        final int actualResult = counter.getCharactersCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_ValidSentence_When_getWordsCountIsCalled_Then_ReturnsCorrectWordCount() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "This is a simple sentence!";
        final int expectedResult = 5;
        final int actualResult = counter.getWordsCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_SentenceWithMultipleSpacesAndPunctuation_When_getWordsCountIsCalled_Then_ReturnsCorrectWordCount() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "Hello, world!!  How are you?";
        final int expectedResult = 5;
        final int actualResult = counter.getWordsCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_EmptyString_When_getWordsCountIsCalled_Then_ReturnsZero() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "";
        final int expectedResult = 0;
        final int actualResult = counter.getWordsCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_SingleWord_When_getWordsCountIsCalled_Then_ReturnsOne() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "Nebeprisikiškiakopūsteliaujantiesiems";
        final int expectedResult = 1;
        final int actualResult = counter.getWordsCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_SpecialCharacters_When_getWordsCountIsCalled_Then_ReturnsZero() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "!!!@@@###$$$";
        final int expectedResult = 1;
        final int actualResult = counter.getWordsCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_MultilineInput_When_getWordsCountIsCalled_Then_ReturnsCorrectWordCount() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "This is\na multiline input\nwith several words.";
        final int expectedResult = 8;
        final int actualResult = counter.getWordsCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_EmojiText_When_getWordsCountIsCalled_Then_ReturnsCorrectWordCount() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "Emojis 😊 are not words, but counts as two characters!";
        final int expectedResult = 10;
        final int actualResult = counter.getWordsCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_SentenceWithMultipleSpaces_When_getWordsCountIsCalled_Then_ReturnsCorrectWordCount() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "This    is     a   sentence   with  multiple spaces.";
        final int expectedResult = 7;
        final int actualResult = counter.getWordsCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_SentenceWithLeadingAndTrailingSpaces_When_getWordsCountIsCalled_Then_ReturnsCorrectWordCount() {
        WordCharacterCounter counter = new WordCharacterCounter();
        final String givenString = "   This is a sentence with extra spaces   ";
        final int expectedResult = 7;
        final int actualResult = counter.getWordsCount(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_VeryLargeInput_When_getWordsCountIsCalled_Then_ReturnsCorrectWordCount() {
        WordCharacterCounter counter = new WordCharacterCounter();
        StringBuilder largeInput = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            largeInput.append("word ");
        }
        final int expectedResult = 10000;
        final int actualResult = counter.getWordsCount(largeInput.toString());
        assertEquals(expectedResult, actualResult);
    }

}
