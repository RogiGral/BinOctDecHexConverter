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
    public static String base2base(String inpString, int inpNumSys, int outNumSys) {
        int decimalValue = 0, charOutSys;
        char charInpSys;
        String output = "";
        for (int i = 0; i < inpString.length(); i++) {
            charInpSys = inpString.charAt(i);
            if (charInpSys >= 'A' && charInpSys <= 'Z') charOutSys = 10 + (charInpSys - 'A');
            else charOutSys = charInpSys - '0';
            decimalValue = decimalValue * inpNumSys + charOutSys;
        }
        if (0 == decimalValue) return "0";
        while (decimalValue != 0) {
            if (decimalValue % outNumSys < 10) output = Integer.toString(decimalValue % outNumSys) + output;
            else output = (char) ((decimalValue % outNumSys) + 55) + output;
            decimalValue /= outNumSys;
        }
        return output;
    }
}
