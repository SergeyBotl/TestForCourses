package task5_0.db;

import task5_0.entity.Employees;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class UtilDB {
    public static File FILE_PATH;

    public String readFile() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = br.readLine();
            StringTokenizer st;
            while (line != null) {
                sb.append(line);
                sb.append(" ");
                line = br.readLine();
                sb.append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("wrong file");
        }
        return sb.toString();
    }


    public boolean writeFile(List<Employees> employees) {
        StringBuilder sb = new StringBuilder();
        for (Employees e : employees) {
            sb.append(e.toString());
            sb.append(System.lineSeparator());
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH));
            bw.write(sb.toString());
            bw.close();
            return true;
        } catch (IOException e) {
            System.out.println("cannot write");
            //e.printStackTrace();
            return false;
        }
    }


}
