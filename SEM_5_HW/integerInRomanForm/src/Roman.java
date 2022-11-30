/**
* Написать метод, который переведёт данное целое число в римский формат.
*
* IV - 4
* VII - 7
* - I = 1
* - V = 5
* - X = 10
* - L = 50
* - C = 100
* - D = 500
* - M = 1000
*
* http://graecolatini.bsu.by/htm-different/num-converter-roman.htm
*/

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Roman {
    static Scanner iScanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Введите арабское число: ");
        int arabNum = iScanner.nextInt();
        System.out.println(arabNumToRoman(arabNum));

        iScanner.close();
    }

    public static String arabNumToRoman(int arab) {

        Map<Integer, Character> arabNum = new HashMap<>();

        arabNum.put(1000, 'M');
        arabNum.put(500, 'D');
        arabNum.put(100, 'C');
        arabNum.put(50, 'L');
        arabNum.put(10, 'X');
        arabNum.put(5, 'V');
        arabNum.put(1, 'I');

        StringBuilder romanNumber = new StringBuilder();

        while (arab > 0) {
            while (arab / 1000 >= 1) {
                romanNumber.append(arabNum.get(1000));
                arab -= 1000;
            }
            while (arab / 100 >= 1) {
                if (arabNum.containsKey(arab - arab % 100)) {
                    romanNumber.append(arabNum.get(arab - arab % 100));
                    arab = arab % 100;
                }
                if (arab >= 500) {
                    romanNumber.append(arabNum.get(500));
                    arab = arab - 500;
                } else {
                    if (arab >= 100) {
                        romanNumber.append(arabNum.get(100));
                        arab -= 100;
                    }
                }
            }
            while (arab / 10 >= 1) {
                if (arabNum.containsKey(arab - arab % 10)) {
                    romanNumber.append(arabNum.get(arab - arab % 10));
                    arab = arab % 10;
                }
                if (arab >= 50) {
                    romanNumber.append(arabNum.get(50));
                    arab -= 50;
                } else {
                    if (arab >= 10) {
                        romanNumber.append(arabNum.get(10));
                        arab -= 10;
                    }
                }
            }
            while (arab > 0) {
                if (arabNum.containsKey(arab)) {
                    romanNumber.append(arabNum.get(arab));
                    arab = 0;
                }
                if (arab >= 5) {
                    romanNumber.append(arabNum.get(5));
                    arab -= 5;
                } else {
                    if (arab >= 1) {
                        romanNumber.append(arabNum.get(1));
                        arab -= 1;
                    }
                }
            }
        }
        return romanNumber.toString();
    }
}
