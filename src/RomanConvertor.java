import java.awt.dnd.InvalidDnDOperationException;
import java.security.InvalidParameterException;

public class RomanConvertor {

    public static int ToArabic(String roman) {
        int num = 0;

        String romanNumeral = roman;
        for (int x = 0; x < romanNumeral.length(); x++) {
            char convertToDecimal = roman.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    num += 1000;
                    break;

                case 'D':
                    num += 500;
                    break;

                case 'C':
                    num += 100;
                    break;

                case 'L':
                    num += 50;
                    break;

                case 'X':
                    num += 10;
                    break;

                case 'V':
                    num += 5;
                    break;

                case 'I':
                    num += 1;
                    break;
            }
        }
        return num;
    }


    public static String ToRoman(int arabic) {
            if (arabic < 1 || arabic > 3999)
                throw new InvalidParameterException();
            String s = "";
            while (arabic >= 1000) {
                s += "M";
                arabic -= 1000;
            }
            while (arabic >= 900) {
                s += "CM";
                arabic -= 900;
            }
            while (arabic >= 500) {
                s += "D";
                arabic -= 500;
            }
            while (arabic >= 400) {
                s += "CD";
                arabic -= 400;
            }
            while (arabic >= 100) {
                s += "C";
                arabic -= 100;
            }
            while (arabic >= 90) {
                s += "XC";
                arabic -= 90;
            }
            while (arabic >= 50) {
                s += "L";
                arabic -= 50;
            }
            while (arabic >= 40) {
                s += "XL";
                arabic -= 40;
            }
            while (arabic >= 10) {
                s += "X";
                arabic -= 10;
            }
            while (arabic >= 9) {
                s += "IX";
                arabic -= 9;
            }
            while (arabic >= 5) {
                s += "V";
                arabic -= 5;
            }
            while (arabic >= 4) {
                s += "IV";
                arabic -= 4;
            }
            while (arabic >= 1) {
                s += "I";
                arabic -= 1;
            }

            return s;
        }
    }






