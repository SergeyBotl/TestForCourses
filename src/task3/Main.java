package task3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> list;
        List<Integer> intList;
        String toChar;
        StringBuilder sb = new StringBuilder();
        toChar = "2*12ihi52.414oi4+5oi/kjlj-jkhlk15-5jhjkh+ll10/2kkll5+3";
        for (int i = 0; i < toChar.length(); i++) {
            if (isNumber(toChar.charAt(i))) {
                sb.append(toChar.charAt(i));
                if (toChar.length() - 1 > i && !isNumber(toChar.charAt(i + 1))) {
                    sb.append(" ");
                    if (i < toChar.length() - 2
                            && isOperator(toChar.charAt(i + 1))
                            && isNumber(toChar.charAt(i + 2))) {
                        sb.append(toChar.charAt(i + 1)).append(" ");
                    }
                }
            }
        }
        list = new ArrayList<>(Arrays.asList(sb.toString().split(" ")));
        intList = new ArrayList<>();
        // System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 2
                    && isNumber(list.get(i))
                    && !isNumber(list.get(i + 1))
                    && isNumber(list.get(i + 2))) {
                int first = Integer.valueOf(list.get(i)), last = Integer.valueOf(list.get(i + 2));
                if (list.get(i + 1).equals("*")) intList.add(first * last);
                if (list.get(i + 1).equals("/")) intList.add(first / last);
                if (list.get(i + 1).equals("+")) intList.add(first + last);
                if (list.get(i + 1).equals("-")) intList.add(first - last);
                i += 2;
            } else {
                intList.add(Integer.valueOf(list.get(i)));

            }
        }
        // System.out.println(list);
        System.out.println(intList.toString());
        maxMin(intList);
    }

    static void maxMin(List<Integer> integers) {
        Collections.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        //System.out.println(integers);
        System.out.println("Max: " + integers.get(integers.size() - 1) + "\nMin: " + integers.get(0));
    }

    static boolean isNumber(String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static boolean isNumber(char c) {
        return (c > 47 && c < 58);
    }

    static boolean isOperator(char c) {
        return (c == 47 || c == 42 || c == 45 || c == 43);
    }


}
