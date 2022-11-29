// Взять набор строк, например,  Мороз и солнце день чудесный 
// Еще ты дремлешь друг прелестный пора красавица проснись.
// Написать метод, который отсортирует эти строки по длине с помощью TreeMар.
// Строки с одинаковой длиной не должны "потеряться".

package SEM_5;

import java.util.*;

public class task3 {
    static Scanner sc = new Scanner(System.in, "ibm866");

    public static void main(String[] args) {
        String str = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный пора красавица проснись";
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        String[] tabl = str.split(" ");
        for (int i = 0; i < tabl.length; i++) {
            int len = tabl[i].length();
            if (map.containsKey(len)) {
                List<String> list = map.get(len);
                list.add(tabl[i]);
                map.put(len, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(tabl[i]);
                map.put(len, list);
            }
        }
        List<String> result = new ArrayList<>();
        Set<Integer> set = map.keySet();
        for (Integer x: set) {
            List<String> list = map.get(x); 

            result.addAll (list); 
        }
        System.out.println(result);
    }

}

/**
 * в Терминале:
 * [и, ты, Еще, день, друг, пора, Мороз, солнце, чудесный, дремлешь, проснись, красавица, прелестный]
 */

