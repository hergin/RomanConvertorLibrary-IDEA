// DO NOT CHANGE THIS FILE!!!

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RomanConvertorTest {

    Map<String, Integer> sampleRandomNumbers = new HashMap<String, Integer>() {{
        put("XV", 15);
        put("VI", 6);
        put("LXXVIII", 78);
        put("CIII", 103);
    }};

    Map<String, Integer> specialNumbers = new HashMap<String, Integer>() {{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
    }};


    @Test
    void ToRomanTest_RepeatingSingleDigits() {
        Assertions.assertEquals("I", RomanConvertor.ToRoman(1));
        Assertions.assertEquals("III", RomanConvertor.ToRoman(3));
    }

    @Test
    void ToRomanTest_RandomSuccessfulValues() {
        for (var number : sampleRandomNumbers.entrySet()) {
            Assertions.assertEquals(number.getKey(), RomanConvertor.ToRoman(number.getValue()));
        }
    }

    @Test
    void ToArabicTest_RandomSuccessfulValues() {
        for (var number : sampleRandomNumbers.entrySet()) {
            Assertions.assertEquals(number.getValue(), RomanConvertor.ToArabic(number.getKey()));
        }
    }

    @Test
    void ToRomanTest_SpecialNumbers() {
        for (var number : specialNumbers.entrySet()) {
            Assertions.assertEquals(number.getKey(), RomanConvertor.ToRoman(number.getValue()));
        }
    }

    @Test
    void ToArabicTest_SpecialNumbers() {
        for (var number : specialNumbers.entrySet()) {
            Assertions.assertEquals(number.getValue(), RomanConvertor.ToArabic(number.getKey()));
        }
    }

    @Test
    void Test_Sanity() {
        var originalRomanNumber = "MCDXCVIII";
        var convertedArabic = RomanConvertor.ToArabic(originalRomanNumber);
        var convertedRoman = RomanConvertor.ToRoman(convertedArabic);

        Assertions.assertEquals(originalRomanNumber, convertedRoman);
    }

    @Test
    void ToRomanTest_TestNegative() {
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            RomanConvertor.ToRoman(-1);
        });
    }

    @Test
    void ToRomanTest_Test0() {
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            RomanConvertor.ToRoman(0);
        });
    }

    @Test
    void ToRomanTest_Test4000() {
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            RomanConvertor.ToRoman(4000);
        });
    }

    @Test
    void ToRomanTest_TestMoreThan4000() {
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            RomanConvertor.ToRoman(4001);
        });
    }


    @Test
    void ToArabicTest_InvalidChars() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            RomanConvertor.ToArabic("XXBBIIOO");
        });
    }

}