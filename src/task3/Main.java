package task3;

public class Main {


    public static void main(String[] args) {



        //======================================
        String toChar;
        int countInt, countString;
        countInt = 0;
        countString = 0;
        StringBuilder sb = new StringBuilder();
        toChar = "*/-+";
        //=======================================
       /* Integer integer = Integer.parseInt(toChar);
        System.out.println(integer);*/
        //=======================================
        for (int i = 0; i < toChar.length(); i++) {

            if (isNumber(toChar.charAt(i))) {

                // sb.append(toChar.charAt(i));
                if (toChar.length() - 1 == i || !isNumber(toChar.charAt(i + 1))) {
                    sb.append("\n");
                    countInt++;
                }
            } else {


            }
        }


        System.out.println(sb.toString() + "\n" + "Стрингов: " + countString + "  Интов: " + countInt);
    }

    static boolean isNumber(char c) {
        int i = c;
        String s = i + "";
        System.out.println(s);
        return (c > 47 && c < 58 || c == 46 || c == 42 || c == 45 || c == 43);
    }
}
