package testpackage.enumerationtest;

import java.util.Enumeration;

public class CreateEnumeration {
    final static String[] stringarray= new String[]{"hello","world","nice","to","meet","you"};

    public static Enumeration<String> getEnumeration(){
        return new Enumeration<String>(){
            int index=0;
            @Override
            public boolean hasMoreElements() {
                return index<stringarray.length;
            }

            @Override
            public String nextElement() {
                return stringarray[index++];
            }
        };
    }
}
