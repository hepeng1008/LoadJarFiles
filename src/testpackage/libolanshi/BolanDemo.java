package testpackage.libolanshi;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BolanDemo {


    public static int getPriority(char ch) {
        switch (ch) {
            case ('+'):
            case ('-'):
                return 1;
            case ('*'):
            case ('/'):
                return 2;
            default:
                return 0;
        }
    }

    public static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Stack<Character> number = new Stack<>();
        Stack<Character> operator = new Stack<>();
        ArrayList<Character> result = new ArrayList<>();
        char op;
        for (int i = str.length()-1; i >=0; i--) {
            char ch = str.charAt(i);
            if (isNumber(ch)) {
                number.push(ch);
            } else if (ch == ')') {
                operator.push(ch);
            } else if (ch == '(') {
                op = operator.pop();
                while (op != ')') {
                    number.push(op);
                    op = operator.pop();
                }
            } else {
                if (!operator.empty()) {
                    op = operator.peek();
                    while (getPriority(op) >=getPriority(ch)) {
                        number.push(operator.pop());
                        if (!operator.empty())
                            op = operator.peek();
                        else
                            break;
                    }
                }
                operator.push(ch);
            }
        }
        while (!operator.isEmpty())
            number.push(operator.pop());
        for (char ch : number) {
            System.out.print(ch);
        }
    }


}
