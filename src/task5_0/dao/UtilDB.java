package task5_0.dao;

import task5_0.db.CreateData;
import task5_0.entity.Employees;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class UtilDB {

    /**
     * @param file the path to the file
     * @return type String
     */

    public String readFile(File file) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(" ");
                line = br.readLine();
                sb.append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("incorrectly read the file");
        }
        return sb.toString();
    }


    public boolean writeFile(File file, List<Employees> employees) {
        StringBuilder sb = new StringBuilder();
        for (Employees e : employees) {
            sb.append(e.toString());
            sb.append(System.lineSeparator());
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(sb.toString());
            bw.close();
            return true;
        } catch (IOException e) {
            System.err.println("cannot write");
            return false;
        }
    }



}
