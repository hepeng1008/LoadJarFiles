package testpackage.ability;

import java.util.Scanner;

public class Add {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String input=scanner.nextLine();
            String[] split = input.split("\\s+");
            System.out.println(Integer.parseInt(split[0])+Integer.parseInt(split[1]));
        }
    }
}
