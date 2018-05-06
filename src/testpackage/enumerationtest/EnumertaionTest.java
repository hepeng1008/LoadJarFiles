package testpackage.enumerationtest;

import java.util.Enumeration;

public class EnumertaionTest {

    public static void main(String[] args) {
        Enumeration<String> enumeration = CreateEnumeration.getEnumeration();
        while(enumeration.hasMoreElements()){
            String str = enumeration.nextElement();
            System.out.println(str);
        }
        System.out.println(System.getProperty("java.class.path"));
    }
}
