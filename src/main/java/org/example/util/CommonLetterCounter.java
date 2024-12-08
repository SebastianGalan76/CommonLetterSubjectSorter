package org.example.util;

import java.util.Map;

public class CommonLetterCounter {
    /**
     * Counts the total number of common letters between two strings
     *
     * @param text1 First string to be compared
     * @param text2 Second string to be compared
     * @return Total number of common letters
     */
    public static int countCommonLetters(String text1, String text2){
        Map<Character, Integer> text1result = LetterCounter.countLetters(text1);
        Map<Character, Integer> text2result = LetterCounter.countLetters(text2);

        if(text1result.isEmpty() || text2result.isEmpty()){
            return 0;
        }

        int commonLettersCount = 0;
        for(char letter:text1result.keySet()){
            if(text2result.containsKey(letter)){
                commonLettersCount += Math.min(text1result.get(letter), text2result.get(letter));
            }
        }
        return commonLettersCount;
    }
}
