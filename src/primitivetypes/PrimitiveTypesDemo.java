package primitivetypes;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PrimitiveTypesDemo {

    private static final Map<Class<?>, Class<?>> primitiveWrapperTypeMap = new IdentityHashMap<>(32);

    private static final Map<Class<?>, Class<?>> primitiveTypeToWrapperMap = new IdentityHashMap<>(32);

    private static final Map<String, Class<?>> primitiveTypeNameMap = new HashMap<>(32);


    public static void main(String[] args) {
        /*primitiveWrapperTypeMap.put(Boolean.class, boolean.class);
        primitiveWrapperTypeMap.put(Byte.class, byte.class);
        primitiveWrapperTypeMap.put(Character.class, char.class);
        primitiveWrapperTypeMap.put(Double.class, double.class);
        primitiveWrapperTypeMap.put(Float.class, float.class);
        primitiveWrapperTypeMap.put(Integer.class, int.class);
        primitiveWrapperTypeMap.put(Long.class, long.class);
        primitiveWrapperTypeMap.put(Short.class, short.class);

        primitiveWrapperTypeMap.forEach((key, value) -> {
            primitiveTypeToWrapperMap.put(value, key);
        });

        Set<Class<?>> primitiveTypes = new HashSet<>(32);
        primitiveTypes.addAll(primitiveWrapperTypeMap.values());
        primitiveTypes.addAll(Arrays.asList(boolean[].class, byte[].class, char[].class,
                double[].class, float[].class, int[].class, long[].class, short[].class));
        primitiveTypes.add(void.class);
        for (Class<?> primitiveType : primitiveTypes) {
            //System.out.println(primitiveType.getName()+":"+primitiveType);

            primitiveTypeNameMap.put(primitiveType.getName(), primitiveType);
        }

        System.out.println("int[].class:"+int[].class);
        System.out.println("long[].class:"+long[].class);
        System.out.println("short[].class"+short[].class);
        System.out.println("double[].class"+double[].class);
        System.out.println("boolean[].class"+boolean[].class);
        System.out.println("float[].class"+float[].class);
        System.out.println("char[].class"+char[].class);
        System.out.println("byte[].class"+byte[].class);
        System.out.println("------------------------------------------------");

        for(Map.Entry<Class<?>,Class<?>> entry: primitiveWrapperTypeMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        System.out.println("------------------------------------------------");
        for(Map.Entry<String,Class<?>> entry: primitiveTypeNameMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
*/
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            System.out.println(contextClassLoader);

            /* classpath的所有jar包中只有一个spring.factories文件
            InputStream resourceAsStream = contextClassLoader.getResourceAsStream("META-INF/spring.factories");
            InputStreamReader reader = new InputStreamReader(resourceAsStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String s = bufferedReader.readLine();
            while(s!=null){
                System.out.println(s);
                s=bufferedReader.readLine();
            }*/
            //有多个文件的处理方式
            Enumeration<URL> resources = contextClassLoader.getResources("META-INF/spring.factories");
            while (resources.hasMoreElements()){
                URL url = resources.nextElement();
                JarURLConnection urlConnection = (JarURLConnection)url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String s = bufferedReader.readLine();
                while(s!=null){
                    System.out.println(s);
                    s=bufferedReader.readLine();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
