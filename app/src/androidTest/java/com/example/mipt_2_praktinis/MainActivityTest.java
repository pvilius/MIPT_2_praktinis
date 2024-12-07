package com.example.mipt_2_praktinis;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.not;

public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testWordCountSentence() {
        final String givenString = "Roses are red, violets are blue, unit tests are awesome, and so are you!";
        final String expectedResult = "Words:14";
        testWordCount(givenString, expectedResult);
    }

    @Test
    public void testCharacterCountSentence() {
        final String givenString = "Roses are red, violets are blue, unit tests are awesome, and so are you!";
        final String expectedResult = "Characters:72";
        testCharacterCount(givenString, expectedResult);
    }

    @Test
    public void testWordCountWithEmoji() {
        final String givenString = "Testing is fun! 😊🔥💻";
        final String expectedResult = "Words:4";
        testWordCount(givenString, expectedResult);
    }

    @Test
    public void testCharacterCountWithEmoji() {
        final String givenString = "Testing is fun! 😊🔥💻";
        final String expectedResult = "Characters:22";
        testCharacterCount(givenString, expectedResult);
    }

    @Test
    public void testWordCountMultiline() {
        final String givenString = "First line of text.\nSecond line of text.\nThird line.";
        final String expectedResult = "Words:10";
        testWordCount(givenString, expectedResult);
    }

    @Test
    public void testCharacterCountMultiline() {
        final String givenString = "First line of text.\nSecond line of text.\nThird line.";
        final String expectedResult = "Characters:52";
        testCharacterCount(givenString, expectedResult);
    }

    @Test
    public void testWordCountSpecialChars() {
        final String givenString = "@@@ $$$ !!! --- ??? ###";
        final String expectedResult = "Words:6";
        testWordCount(givenString, expectedResult);
    }

    @Test
    public void testCharacterCountSpecialChars() {
        final String givenString = "@@@ $$$ !!! --- ??? ###";
        final String expectedResult = "Characters:23";
        testCharacterCount(givenString, expectedResult);
    }

    @Test
    public void testWordCountSingleWord() {
        final String givenString = "Nebeprisikiškiakopūsteliaujantiesiems";
        final String expectedResult = "Words:1";
        testWordCount(givenString, expectedResult);
    }

    @Test
    public void testCharacterCountSingleWord() {
        final String givenString = "Nebeprisikiškiakopūsteliaujantiesiems";
        final String expectedResult = "Characters:37";
        testCharacterCount(givenString, expectedResult);
    }

    @Test
    public void testWordCountLongInput() {
        final StringBuilder givenString = new StringBuilder();
        final String expectedResult = "Words:1000";
        for (int i = 0; i < 1000; i++) {
            givenString.append("Nebeprisikiškiakopūsteliaujantiesiems ");
        }
        testWordCount(givenString.toString(), expectedResult);
    }

    @Test
    public void testCharacterCountLongInput() {
        final StringBuilder givenString = new StringBuilder();
        final String expectedResult = "Characters:37000";
        for (int i = 0; i < 1000; i++) {
            givenString.append("Nebeprisikiškiakopūsteliaujantiesiems");
        }
        testCharacterCount(givenString.toString(), expectedResult);
    }

    @Test
    public void testWordCountMultipleSpacesBetweenWords() {
        final String givenString = "Hello    world  this   is  a test";
        final String expectedResult = "Words:6";
        testWordCount(givenString, expectedResult);
    }

    @Test
    public void testCharacterCountMultipleSpacesBetweenWords() {
        final String givenString = "Hello    world  this   is  a test";
        final String expectedResult = "Characters:33";
        testCharacterCount(givenString, expectedResult);
    }

    @Test
    public void testWordCountChineseCharacterInput() {
        final String givenString = "测试 是 有趣 的";
        final String expectedResult = "Words:4";
        testWordCount(givenString, expectedResult);
    }

    @Test
    public void testCharacterCountChineseCharacterInput() {
        final String givenString = "测试 是 有趣 的";
        final String expectedResult = "Characters:9";
        testCharacterCount(givenString, expectedResult);
    }

    // Helper method to test word count
    private void testWordCount(String input, String expectedResult) {
        onView(withId(R.id.editInputText)).perform(replaceText(input));
        onView(withId(R.id.spinnerCountType)).perform(click());
        onData(anything()).atPosition(0).perform(click());  // Word count option
        onView(withId(R.id.btnCount)).perform(click());
        onView(withId(R.id.tvResults)).check(matches(withText(expectedResult)));
    }

    // Helper method to test character count
    private void testCharacterCount(String input, String expectedResult) {
        onView(withId(R.id.editInputText)).perform(replaceText(input));
        onView(withId(R.id.spinnerCountType)).perform(click());
        onData(anything()).atPosition(1).perform(click());  // Character count option
        onView(withId(R.id.btnCount)).perform(click());
        onView(withId(R.id.tvResults)).check(matches(withText(expectedResult)));
    }

}
