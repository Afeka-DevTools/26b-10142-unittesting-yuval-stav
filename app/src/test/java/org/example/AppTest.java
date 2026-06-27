package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class AppTest {

    // ---------- constructor ----------

    @Test void testConstructor_createsInstance() {
        App app = new App();
        assertNotNull(app);
    }

    // ---------- add ----------

    @Test void testAdd_positiveNumbers() {
        assertEquals(5, App.add(2, 3));
    }

    @Test void testAdd_negativeNumbers() {
        assertEquals(-5, App.add(-2, -3));
    }

    @Test void testAdd_withZero() {
        assertEquals(7, App.add(7, 0));
    }

    // ---------- isPrime ----------

    @Test void testIsPrime_negativeNumber() {
        assertFalse(App.isPrime(-5));
    }

    @Test void testIsPrime_zero() {
        assertFalse(App.isPrime(0));
    }

    @Test void testIsPrime_one() {
        assertFalse(App.isPrime(1));
    }

    @Test void testIsPrime_two() {
        assertTrue(App.isPrime(2));
    }

    @Test void testIsPrime_primeNumber() {
        assertTrue(App.isPrime(13));
    }

    @Test void testIsPrime_compositeNumber() {
        assertFalse(App.isPrime(9));
    }

    // ---------- reverse ----------

    @Test void testReverse_normalString() {
        assertEquals("cba", App.reverse("abc"));
    }

    @Test void testReverse_emptyString() {
        assertEquals("", App.reverse(""));
    }

    @Test void testReverse_singleChar() {
        assertEquals("x", App.reverse("x"));
    }

    @Test void testReverse_nullThrows() {
        assertThrows(NullPointerException.class, () -> App.reverse(null));
    }

    // ---------- factorial ----------

    @Test void testFactorial_negativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> App.factorial(-1));
    }

    @Test void testFactorial_zero() {
        assertEquals(1, App.factorial(0));
    }

    @Test void testFactorial_one() {
        assertEquals(1, App.factorial(1));
    }

    @Test void testFactorial_positiveNumber() {
        assertEquals(120, App.factorial(5));
    }

    // ---------- isPalindrome ----------

    @Test void testIsPalindrome_simplePalindrome() {
        assertTrue(App.isPalindrome("racecar"));
    }

    @Test void testIsPalindrome_withPunctuationAndSpaces() {
        assertTrue(App.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test void testIsPalindrome_notPalindrome() {
        assertFalse(App.isPalindrome("hello"));
    }

    @Test void testIsPalindrome_emptyString() {
        assertTrue(App.isPalindrome(""));
    }

    // ---------- fibonacciUpTo ----------

    @Test void testFibonacciUpTo_negativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> App.fibonacciUpTo(-1));
    }

    @Test void testFibonacciUpTo_zero() {
        assertEquals(List.of(0), App.fibonacciUpTo(0));
    }

    @Test void testFibonacciUpTo_positiveLimit() {
        assertEquals(List.of(0, 1, 1, 2, 3, 5, 8), App.fibonacciUpTo(10));
    }

    // ---------- charFrequency ----------

    @Test void testCharFrequency_normalString() {
        Map<Character, Integer> freq = App.charFrequency("aab");
        assertEquals(2, freq.get('a'));
        assertEquals(1, freq.get('b'));
    }

    @Test void testCharFrequency_emptyString() {
        Map<Character, Integer> freq = App.charFrequency("");
        assertTrue(freq.isEmpty());
    }

    // ---------- isAnagram ----------

    @Test void testIsAnagram_simpleAnagram() {
        assertTrue(App.isAnagram("listen", "silent"));
    }

    @Test void testIsAnagram_withSpacesAndCase() {
        assertTrue(App.isAnagram("Dormitory", "Dirty Room"));
    }

    @Test void testIsAnagram_notAnagram() {
        assertFalse(App.isAnagram("hello", "world"));
    }

    // ---------- average ----------

    @Test void testAverage_emptyArrayThrows() {
        assertThrows(IllegalArgumentException.class, () -> App.average(new int[]{}));
    }

    @Test void testAverage_normalArray() {
        assertEquals(2.0, App.average(new int[]{1, 2, 3}));
    }

    @Test void testAverage_singleElement() {
        assertEquals(5.0, App.average(new int[]{5}));
    }

    // ---------- filterEvens ----------

    @Test void testFilterEvens_mixedNumbers() {
        List<Integer> result = App.filterEvens(List.of(1, 2, 3, 4));
        assertEquals(List.of(2, 4), result);
    }

    @Test void testFilterEvens_emptyList() {
        List<Integer> result = App.filterEvens(List.of());
        assertTrue(result.isEmpty());
    }

    @Test void testFilterEvens_allOdd() {
        List<Integer> result = App.filterEvens(List.of(1, 3, 5));
        assertTrue(result.isEmpty());
    }

    // ---------- mostCommonWord ----------

    @Test void testMostCommonWord_normalText() {
        assertEquals("the", App.mostCommonWord("the cat the dog the"));
    }

    @Test void testMostCommonWord_singleWord() {
        assertEquals("hello", App.mostCommonWord("hello"));
    }
}
