package task5_0.db;

import task5_0.entity.Employees;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UtilDB {

    public String readFile(File file) {

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            StringTokenizer st;
            while (line != null) {
                st = new StringTokenizer(line, " ");
                while (st.hasMoreElements()) {
                    sb.append(st.nextToken());
                    sb.append(" ");
                }

                line = br.readLine();
                sb.append(System.lineSeparator());
                // System.out.println(sb.toString());
            }

            System.out.println(sb.toString());


        } catch (IOException e) {

        }
        return null;
    }


    public void createFile(List<Employees> employees, File file) { //
        StringBuilder sb = new StringBuilder();
        //List<Employees>list=new ArrayList<>();
        // Employees[]array= employees.toArray(new Employees[employees.size()]);

        for (Employees e : employees) {
            sb.append(e.toString());
            sb.append(System.lineSeparator());
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(sb.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
