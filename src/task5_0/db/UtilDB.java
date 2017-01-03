package task5_0.db;

import task5_0.entity.Employees;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class UtilDB {


    public String readFile(File file) {
        StringBuilder sb = new StringBuilder();
        if (!file.exists()) {
            System.out.println("create file");
            writeFile(file,CreateData.list);
        }
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


    public boolean writeFile(File file,List<Employees> employees) {
        StringBuilder sb = new StringBuilder();
        long id = 0;
        for (Employees e : employees) {
            if (e.getId() == 0) e.setId(id);
            sb.append(e.toString());
            sb.append(System.lineSeparator());
            id++;
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
