package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.example.util.CommonLetterCounter.countCommonLetters;
public class CommonLetterCounterTest {
    @Test
    public void countCommonLetters_emptyStrings(){
        assertEquals(0, countCommonLetters("", ""), "Puste stringi nie mają wspólnych liter");
    }

    @Test
    public void countCommonLetters_emptyFirstString(){
        assertEquals(0, countCommonLetters("", "abc"), "Pusty string nie ma wspólnych liter");
    }

    @Test
    public void countCommonLetters_noCommonLetters(){
        assertEquals(0, countCommonLetters("abc", "def"), "Stringi 'abc' i 'def' nie mają wspólnych liter");
    }

    @Test
    public void countCommonLetters_oneCommonLetters(){
        assertEquals(1, countCommonLetters("abc", "cde"), "Stringi 'abc' i 'cde' mają jedną wspólną literę");
    }

    @Test
    public void countCommonLetters_manyCommonLetters(){
        assertEquals(5, countCommonLetters("aabbACcd", "aaBCDx"), "Stringi 'aabbACcd' i 'aaBCDx' mają 5 wspólnych liter");
    }
}
