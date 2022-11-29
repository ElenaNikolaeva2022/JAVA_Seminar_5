/**
 * Даны 2 строки, написать метод, который вернёт true,
 * если эти строки являются изоморфными и false, если нет.
 * Строки изоморфны, если одну букву в первом слове можно зоменить
 * на некоторую букву во втаром слове, при этом повторяющиеся буквы
 * одного слова меняются но одну и ту же букву с сохранением порядка следования.
 * (Например, add - egg изоморфны)
 * буква может не меняться, a остаться такой же. (Например, note - code)
 * Пример 1:
 * Input: 5 = "foo", t = "bar"
 * Output: false
 * Пример 2:
 * Input: s = "paper", t = "title"
 * Output: true
 */

package SEM_5;

import java.util.*;

public class task1 {
    static Scanner sc = new Scanner(System.in, "ibm866");

    public static void main(String[] args) {
        System.out.print("Введите первое слово: ");
        String inp1 = sc.nextLine();
        System.out.print("Введите второе слово: ");
        String inp2 = sc.nextLine();
        boolean ans = isomorph(inp1, inp2);
        System.out.println(ans);
        sc.close();
    }

    public static boolean isomorph(String str1, String str2) {
        Map<Character, Character> words = new HashMap<>();
        {
            for (int i = 0; i < str1.length(); i++) {
                if (words.containsKey(str1.charAt(i))) {
                    if (words.get(str1.charAt(i)) != str2.charAt(i)) {
                        return false;
                    }

                } else {
                    words.put(str1.charAt(i), str2.charAt(i));
                }
            }
            return true;
        }
    }
}

/**
 * в Терминале: Пример 1
 * Введите первое слово: foo (водим слово)
 * Введите второе слово: bar (водим слово)
 * false (получаем)
 * 
 * в Терминале: Пример 2
 * Введите первое слово: paper (водим слово)
 * Введите второе слово: title (водим слово)
 * true (получаем)
 */
