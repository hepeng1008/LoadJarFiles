package primitivetypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PrimitiveTypesDemo2 {

    private static final Map<Class<?>, Class<?>> primitiveWrapperTypeMap = new IdentityHashMap<>(32);

    private static final Map<Class<?>, Class<?>> primitiveTypeToWrapperMap = new IdentityHashMap<>(32);

    private static final Map<String, Class<?>> primitiveTypeNameMap = new HashMap<>(32);


    public static void main(String[] args) throws IOException {

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = contextClassLoader.getResources("META-INF/spring.factories");
        while (resources.hasMoreElements()){
            URL url = resources.nextElement();
            int i = url.toString().lastIndexOf("!");
            String jarpath=url.toString().substring(0,i);
            JarFile jarFile = new JarFile("C:\\spring-boot-2.0.0.RELEASE.jar");

            Enumeration<JarEntry> entries = jarFile.entries();
            while(entries.hasMoreElements()){
                JarEntry entry = entries.nextElement();
                InputStream inputStream = jarFile.getInputStream(entry);
                process(inputStream);
            }
        }
        System.out.println();
    }
    private static void process(InputStream input) throws IOException {
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(isr);
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
