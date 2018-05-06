package testpackage.ability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class huaweitest1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] splits = input.split("\\s+");
            int length = Integer.parseInt(splits[0]);
            int count = Integer.parseInt(splits[1]);
            int[] numbers = new int[length];
            input = scanner.nextLine();
            splits = input.split("\\s+");
            for (int i = 0; i < length; i++) {
                numbers[i] = Integer.parseInt(splits[i]);
            }
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                String str = scanner.nextLine();
                String[] split = str.split("\\s+");
                if (split[0].equals("Q")) {
                    int max = Integer.MIN_VALUE;
                    int start = Integer.min(Integer.parseInt(split[1]), Integer.parseInt(split[2])) - 1;
                    int end = Integer.max(Integer.parseInt(split[1]), Integer.parseInt(split[2])) - 1;
                    for (int k = start; k <= end; k++) {
                        if (max < numbers[k])
                            max = numbers[k];
                    }
                    list.add(max);
                } else {
                    numbers[Integer.parseInt(split[1]) - 1] = Integer.parseInt(split[2]);
                }
            }
            for (Integer i : list) {
                System.out.println(i);
            }
        }
    }
}
