package com.example.mipt_2_praktinis;

public class WordCharacterCounter {

    public int getWordsCount(String input) {
        String[] words = input.split("[\\s,\\.]+");
        return words.length;
    }

    public int getCharactersCount(String input) {
        return input.length();
    }
}