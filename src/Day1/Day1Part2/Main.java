package Day1.Day1Part1.Day1Part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int SimScore(List<Integer> a, List<Integer> b)
    {
        int max = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            max = (a.get(i) > max)? a.get(i) : max ;
        }
        int[] count = new int[max+1];

        for (int i = 0; i < b.size(); i++) {
            if(b.get(i) <= max)
                count[b.get(i)]++;
        }

        int result = 0;

        for (int i = 0; i < a.size(); i++) {
            result += a.get(i) * count[a.get(i)];
        }

        return result;
    }


    public static void main(String[] args) {
        List<Integer> leftLocations = new ArrayList<>();
        List<Integer> rightLocations = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Day1/Day1Part2/Day1Part2_input.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split(" {3}");
                if (parts.length == 2) {
                    leftLocations.add(Integer.parseInt(parts[0]));
                    rightLocations.add(Integer.parseInt(parts[1]));
                }
            }
        } catch (IOException e) {
            System.err.println(e + "File not found !");;
        }

        System.out.println(SimScore(leftLocations,rightLocations));
    }
}
