import java.security.InvalidParameterException;

public class RomanConvertor {


    public static int processDecimal(int decimal, int lastnumber, int lastdecimal){
        if (lastnumber > decimal){
            return lastdecimal -decimal;
        } else {
            return lastdecimal + decimal;
        }
    }


    public static int ToArabic(String roman)
    {
        // Replace the following line with the actual code!
        int decimal = 0;
        int lastNumber = 0;
        for (int x = roman.length() - 1; x >=0; x--){
            char convertToArabic = roman.charAt(x);
            switch (convertToArabic){
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;
                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;
                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;
                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;
                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;
                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;
                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
            if (decimal > 3999){
                throw new InvalidParameterException();
            }
            if (convertToArabic != 'M'){
                if (convertToArabic != 'D'){
                    if (convertToArabic != 'C'){
                        if (convertToArabic != 'L'){
                            if (convertToArabic != 'X'){
                                if (convertToArabic != 'V'){
                                    if (convertToArabic != 'I'){
                                        throw new NumberFormatException();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return decimal;
    }


    public static String ToRoman(int arabic)
    {
        // Replace the following line with the actual code!
        String isRomanNumeral = "";
        if (arabic < 1 || arabic > 3999){
            throw new InvalidParameterException();
        }
        while (arabic >= 1000){
            isRomanNumeral += "M";
            arabic -= 1000;
        }
        while (arabic >= 500){
            isRomanNumeral += "D";
            arabic -= 500;
        }
        while (arabic >= 100){
            isRomanNumeral += "C";
            arabic -= 100;
        }
        while (arabic >= 50){
            isRomanNumeral += "L";
            arabic -= 50;
        }
        while (arabic >= 10){
            isRomanNumeral += "X";
            arabic -= 10;
        }
        while (arabic >= 5){
            isRomanNumeral += "V";
            arabic -= 5;
        }
        while (arabic >= 1){
            isRomanNumeral += "I";
            arabic -= 1;
        }
        return isRomanNumeral;
    }

}
