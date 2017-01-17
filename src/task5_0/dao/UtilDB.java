package task5_0.dao;
import task5_0.entity.Employees;
import java.io.*;
import java.util.List;

public class UtilDB {

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


    public boolean writeFile(File file, List<Employees> employees)  {
        StringBuilder sb = new StringBuilder();
        for (Employees e : employees) {
            sb.append(e.toString());
            sb.append(System.lineSeparator()); //get the string for records
        }
        //i used try-with-resources so not necessary  in the method close()
        try  (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){

           bw.write(sb.toString());
           // bw.close();
            return true;
        } catch (IOException e) {
            System.err.println("cannot write");
            return false;
        }

    }



}
