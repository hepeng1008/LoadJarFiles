package testpackage.classloaderpathtest;

import sun.misc.Launcher;

import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderDemo {

    public static void main(String[] args) {
        System.out.println("BootStrap类加载器的加载路径");
        URL[] urLs2 = Launcher.getBootstrapClassPath().getURLs();
        for(URL url:urLs2){
            System.out.println(url.toString());
        }
        System.out.println("扩展类加载器的加载路径");
        URLClassLoader extClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader().getParent();
        URL[] urLs = extClassLoader.getURLs();
        for(URL url:urLs){
            System.out.println(url.toString());
        }

        System.out.println("系统类加载器的加载路径");
        URLClassLoader systemClassLoader =  (URLClassLoader) Thread.currentThread().getContextClassLoader();
        URL[] urLs1 = systemClassLoader.getURLs();
        for(URL url:urLs1){
            System.out.println(url.toString());
        }

        String property = System.getProperty("java.class.path");
        System.out.println(property);

    }
}
