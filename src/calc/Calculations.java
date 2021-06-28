package calc;

import java.util.Arrays;
import java.util.HashSet;

public class Calculations {
    public static boolean validForBase(String n, int base) {
        char[] validDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] digitsForBase = Arrays.copyOfRange(validDigits, 0, base);
        HashSet<Character> digitsList = new HashSet<>();
        for (int i = 0; i < digitsForBase.length; i++) digitsList.add(digitsForBase[i]);
        for (char c : n.toCharArray()) if (!digitsList.contains(c)) return false;
        return true;
    }
    public static String base2base(String n, int b1, int b2) {
        int decimalValue = 0, charB2;
        char charB1;
        String output = "";
        for (int i = 0; i < n.length(); i++) {
            charB1 = n.charAt(i);
            if (charB1 >= 'A' && charB1 <= 'Z') charB2 = 10 + (charB1 - 'A');
            else charB2 = charB1 - '0';
            decimalValue = decimalValue * b1 + charB2;
        }
        if (0 == decimalValue) return "0";
        while (decimalValue != 0) {
            if (decimalValue % b2 < 10) output = Integer.toString(decimalValue % b2) + output;
            else output = (char) ((decimalValue % b2) + 55) + output;
            decimalValue /= b2;
        }
        return output;
    }
}
