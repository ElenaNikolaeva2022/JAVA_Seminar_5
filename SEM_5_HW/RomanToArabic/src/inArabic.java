// Написать метод, который переведет число из римского формата записи в арабский. 
// Например, MMXXII = 2022

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class inArabic {
    static Scanner iScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите римское число: ");
        String romanNum = iScanner.nextLine();
        System.out.println(romanNumToArab(romanNum));

        iScanner.close();
    }

    public static int romanNumToArab(String romanNum) {

        Map<Character, Integer> romanMap = new HashMap<>();

        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int transformation = 0;
        char[] charArray = romanNum.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (i == charArray.length - 1) {
                transformation = transformation + romanMap.get(charArray[i]);
            } else if (romanMap.get(charArray[i]) >= romanMap.get(charArray[i + 1])) {
                transformation = transformation + romanMap.get(charArray[i]);
            } else {
                transformation = transformation + (romanMap.get(charArray[i + 1]) - romanMap.get(charArray[i]));
                i++;
            }
        }
        return transformation;

    }

}
