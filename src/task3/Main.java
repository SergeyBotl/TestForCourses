package task3;

public class Main {

    public static void main(String[] args) {
        String toChar;
        int countInt, countString;
        countInt = 0;
        countString = 0;
        StringBuilder sb = new StringBuilder();
        toChar = "2jhkjh*12ihi5oioi/kjlj-jkhlkjhjkh+llkkll5";
        for (int i = 0; i < toChar.length(); i++) {
            if (Character.isDigit(toChar.charAt(i))) {
                  System.out.println("while");
                  sb.append(toChar.charAt(i));
              }
             if (isOperator(toChar.charAt(i))){
                sb.append(toChar.charAt(i));
                sb.append(System.lineSeparator());
            }else sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
        //System.out.println(sb.toString() + "\n" + "Стрингов: " + countString + "  Интов: " + countInt);
    }

    static boolean isNumber(char c) {
       /* int i = c;
        String s = i + "";
        System.out.println(s);*/
        return (c > 47 && c < 58);
    }

    static boolean isOperator(char c) {
        return (c == 46 || c == 42 || c == 45 || c == 43);
    }
}
