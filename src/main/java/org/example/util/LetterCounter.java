package org.example.util;

import java.util.HashMap;
import java.util.Map;

public class LetterCounter {
    /**
     * Counts the occurrences of each letter in a given text.
     *
     * @param text the string to be processed
     * @return a map where keys are letters and values are their counts
     */
    public static Map<Character, Integer> countLetters(String text){
        Map<Character, Integer> letterCounts = new HashMap<>();
        if(text == null){
            return letterCounts;
        }

        for(char letter:text.toLowerCase().toCharArray()){
            if(Character.isLetter(letter)){
                letterCounts.put(letter, letterCounts.getOrDefault(letter, 0) + 1);
            }
        }

        return letterCounts;
    }
}
