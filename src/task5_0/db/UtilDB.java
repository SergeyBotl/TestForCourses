package task5_0.db;

import task5_0.entity.Employees;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class UtilDB {
    public static File FILE_PATH;

    public String readFile() {
        StringBuilder sb = new StringBuilder();
        if (!FILE_PATH.exists()) {
            System.out.println("create file");
            writeFile(CreateData.list);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
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


    public boolean writeFile(List<Employees> employees) {
        StringBuilder sb = new StringBuilder();
        long id = 0;
        for (Employees e : employees) {
            if (e.getId() == 0) e.setId(id++);
            sb.append(e.toString());
            sb.append(System.lineSeparator());
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH));
            bw.write(sb.toString());
            bw.close();
            return true;
        } catch (IOException e) {
            System.err.println("cannot write");
            return false;
        }
    }


}
