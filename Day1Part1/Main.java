package Day1Part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static int totaldistance(List<Integer> a, List<Integer> b)
    {
        PriorityQueue<Integer> PQ1 = new PriorityQueue<>();
        PriorityQueue<Integer> PQ2 = new PriorityQueue<>();
        int result = 0;
        for (int i = 0; i < a.size(); i++) {
            PQ1.add(a.get(i));
            PQ2.add(b.get(i));
        }
        while(!PQ1.isEmpty() && !PQ2.isEmpty())
            result+=Math.abs(PQ1.poll()-PQ2.poll());


        return result;
    }

    public static void main(String[] args) {
        List<Integer> leftLocations = new ArrayList<>();
        List<Integer> rightLocations = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Day1Part1/Day1Part1_input.txt"));
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

        System.out.println(totaldistance(leftLocations,rightLocations));
    }
}
