package multiinnerclass;

import java.util.Collections;

public class Outer {

    public static class Inner1{
        public static class Inner2{

        }
    }

    public static void main(String[] args) {
        new Outer();
    }
}
