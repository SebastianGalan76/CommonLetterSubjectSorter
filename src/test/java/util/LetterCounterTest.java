package util;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.example.util.LetterCounter.countLetters;
import static org.junit.jupiter.api.Assertions.*;

public class LetterCounterTest {

    @Test
    public void countLetters_nullString(){
        assertTrue(countLetters(null).isEmpty(), "Mapa powinna być pusta");
    }

    @Test
    public void countLetters_emptyString(){
        assertTrue(countLetters("").isEmpty(), "Mapa powinna być pusta");
    }

    @Test
    public void countLetters_textWithNoLetters(){
        assertTrue(countLetters("1234567890!@#$%^&*().,[] ").isEmpty(), "Mapa powinna być pusta");
    }

    @Test
    public void countLetters_singleLetter(){
        char letter = 'a';
        Map<Character, Integer> result = countLetters(String.valueOf(letter));
        assertFalse(result.isEmpty(), "Mapa powinna zawierać jedną parę klucz-wartość");
        assertEquals(1, result.get(letter), "Wartość dla klucza "+letter+" powinna wynosić 1");
    }

    @Test
    public void countLetters_ignoreCaseLetters(){
        String text = "aA";
        Map<Character, Integer> result = countLetters(text);
        assertFalse(result.isEmpty(), "Mapa powinna zawierać jedną parę klucz-wartość");
        assertEquals(2, result.get('a'), "Wartość dla klucza 'a' powinna wynosić 2");
    }

    @Test
    public void countLetters_countAllLetters(){
        String text = "Hello";
        Map<Character, Integer> result = countLetters(text);
        assertEquals(4, result.size(), "Mapa powinna mieć rozmiar 4");
        assertEquals(1, result.get('h'), "Wartość dla klucza 'h' powinna wynosić 1");
        assertEquals(1, result.get('e'), "Wartość dla klucza 'e' powinna wynosić 1");
        assertEquals(2, result.get('l'), "Wartość dla klucza 'l' powinna wynosić 2");
        assertEquals(1, result.get('o'), "Wartość dla klucza 'o' powinna wynosić 1");
    }
}
