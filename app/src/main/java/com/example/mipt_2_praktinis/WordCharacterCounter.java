package com.example.mipt_2_praktinis;

public class WordCharacterCounter {

    public int getWordsCount(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        String[] words = input.trim().split("\\s+");
        return words.length;
    }

    public int getCharactersCount(String input) {
        return input.length();
    }
}
