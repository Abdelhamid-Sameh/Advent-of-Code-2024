package Day3.Day3Part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static int Mull(List<String> s)
    {
        int result = 0;

        for (int i = 0; i < s.size(); i++) {
            String line = s.get(i);
            for (int j = 0; j < line.length(); j++) {
                if(line.charAt(j)=='m') {
                    int z = checkMullable(line, j + 1);
                    if (z != -1)
                        result+=z;
                }
            }
        }

        return result;
    }

    private static int  checkMullable(String line, int start)
    {
        if(start>=line.length())
            return -1;
        String s = "ul(,)";
        int j = 0;
        String X = "";
        String Y = "";
        for (int i = start; i < line.length() && j < s.length() ; i++) {
            if(j==3 && line.charAt(i)>='0' && line.charAt(i)<='9')
                X+=line.charAt(i);
            else if(j==4 && line.charAt(i)>='0' && line.charAt(i)<='9')
                Y+=line.charAt(i);
            else if(line.charAt(i)!=s.charAt(j))
                return -1;
            else
                j++;
        }
        if(j==s.length()) {
            int x = Integer.parseInt(X);
            int y = Integer.parseInt(Y);
            return x * y;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<String> instructions = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Day3/Day3Part1/Day3Part1_input.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                instructions.add(line);
            }
        } catch (IOException e) {
            System.err.println(e + "File not found !");;
        }


        System.out.println(Mull(instructions));
    }
}
