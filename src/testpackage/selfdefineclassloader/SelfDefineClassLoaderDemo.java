package testpackage.selfdefineclassloader;

public class SelfDefineClassLoaderDemo {

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader(Thread.currentThread().getContextClassLoader().getParent());
        try {
            Class<?> aClass = myClassLoader.loadClass("testpackage.selfdefineclassloader.People");
            Object o = aClass.newInstance();
            System.out.println(o.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }
}
