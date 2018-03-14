package strategy.strategyDemo3;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class CalPriceFactory {

    private static final String CAL_PRICE_PACKAGE = "strategy.strategyDemo3";

    private ClassLoader classLoader = getClass().getClassLoader();

    private List<Class<? extends CalPrice>> calPriceList; //策略列表

    //获取扫描的包下面的所有的class文件
    private File[] getResource() {
        try {
            File file = new File(classLoader.getResource(CAL_PRICE_PACKAGE.replace(".", "/")).toURI());
            return file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (pathname.getName().endsWith(".class"))
                        return true;
                    return false;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //内部类的单例模式
    private static class CalPriceFactoryInstance {
        private static CalPriceFactory instance = new CalPriceFactory();
    }

    public static CalPriceFactory getInstance() {
        return CalPriceFactoryInstance.instance;
    }


    //在工厂初始化时要初始化策略列表
    private void init() {
        calPriceList = new ArrayList<Class<? extends CalPrice>>();

        File[] resources = getResource();

        Class<CalPrice> calPriceClazz = null;

        try {
            calPriceClazz = (Class<CalPrice>) classLoader.loadClass(CalPrice.class.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("未找到策略接口");
        }
        for (int i = 0; i < resources.length; i++) {
            try {
                Class<?> clazz = classLoader.loadClass(CAL_PRICE_PACKAGE + "." + resources[i].getName().replace(".class", ""));
                if (CalPrice.class.isAssignableFrom(clazz) && clazz != calPriceClazz) {
                    calPriceList.add((Class<? extends CalPrice>) clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    //单例
    private CalPriceFactory() {
        init();
    }

    //处理注解，我们传入一个策略类，返回它的注解
    private PriceRegion handleAnnotation(Class<? extends CalPrice> clazz) {
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        if (annotations == null || annotations.length == 0) {
            return null;
        }
        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i] instanceof PriceRegion) {
                return (PriceRegion) annotations[i];
            }
        }
        return null;
    }

    //根据玩家的总金额产生相应的策略
    public CalPrice createCalPrice(Player player) {
        //在策略列表中查找策略
        for (Class<? extends CalPrice> clazz : calPriceList) {

            PriceRegion validRegion = handleAnnotation(clazz);
            //判断金额是否在注解的区间
            if (player.getTotalAmound() >= validRegion.min() && player.getTotalAmound() < validRegion.max()) {
                try {
                    return clazz.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
