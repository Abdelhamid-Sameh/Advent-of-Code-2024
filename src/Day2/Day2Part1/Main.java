package Day2.Day2Part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int SafeReports(List<List<Integer>> a)
    {
        int safe = 0;
        for (int i = 0; i < a.size() ; i++) {
            safe+= (isSafe(a.get(i)))? 1 : 0 ;
        }
        return safe;

    }

    private static boolean isSafe(List<Integer> a)
    {
        int sign = 0;
        for (int i = 0; i < a.size() - 1; i++) {
            if(i==0) {
                sign = a.get(i + 1) - a.get(i);
                if(sign == 0 || Math.abs(sign) > 3)
                    return false;
            }
            else {
                int diff = a.get(i+1) - a.get(i);
                if(diff == 0 || (diff > 0 && sign < 0) || (diff < 0 && sign > 0) || Math.abs(diff) > 3)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> Reports = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Day2/Day2Part1/Day2Part1_input.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split(" ");
                List<Integer> report = new ArrayList<>();
                for (int i = 0; i < parts.length; i++) {
                    report.add(Integer.parseInt(parts[i]));
                }
                Reports.add(report);
            }
        } catch (IOException e) {
            System.err.println(e + "File not found !");;
        }

        System.out.println(SafeReports(Reports));
    }
}
