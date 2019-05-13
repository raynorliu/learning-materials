package com.core.reflect;


import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射测试
 * @author raynor
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ///1 通过类型获得
        // 语法：类名.class
        // 应用场景：确定类型 等
        Class<Bean> aClass1 = Bean.class;

        //2 通过实例对象获得
        // 语法：变量.getClass()
        // 应用场景：在方法内部通过参数获得类型 等
        Bean bean = new Bean();
        Class clazz2 = bean.getClass();

        //3 通过字符串获得
        // 语法：Class.forName("全限定类名")
        // 应用场景：通过配置获得字符串 等
        Class<?> aClass3 = Class.forName("com.core.reflect.Bean");
    }

    /**
     * 无参构造，并获得实例
     *
     * @throws Exception
     */
    @Test
    public void testDefaultConstructor() throws Exception {
        //获得class对象
        Class<Bean> beanClass = Bean.class;
        //获得无参构造函数
        Constructor<Bean> constructor = beanClass.getConstructor();
        //实例化对象
        Bean bean = constructor.newInstance();
        System.out.printf(String.valueOf(bean));
    }

    /**
     * 有参构造，并获得实例
     *
     * @throws Exception
     */
    @Test
    public void testParamsConstructor() throws Exception {
        //获得class对象
        Class<Bean> beanClass = Bean.class;
        //获得无参构造函数，2个字符串参数
        Constructor<Bean> constructor = beanClass.getConstructor(String.class, String.class);
        //实例化对象，并传参数
        Bean bean = constructor.newInstance("has params", "promise");
        System.out.printf(String.valueOf(bean));
    }

    /**
     * 私有构造，并获得实例
     *
     * @throws Exception
     */
    @Test
    public void testPrivateConstructor() throws Exception {
        //获得class对象
        Class<Bean> beanClass = Bean.class;
        //获得无参构造函数，2个字符串参数
        Constructor<Bean> constructor = beanClass.getDeclaredConstructor(String.class);
        //暴力访问
        constructor.setAccessible(true);
        //实例化对象，并传参数
        Bean bean = constructor.newInstance("has params");
        System.out.printf(String.valueOf(bean));
    }

    /**
     * public方法
     *
     * @throws Exception
     */
    @Test
    public void testMethod() throws Exception {
        //获得class对象
        Class<?> aClass = Class.forName("com.core.reflect.Bean");
        //获得实例
        Object obj = aClass.newInstance();
        //获得方法（方法名，形成列表）
        Method setMethod = aClass.getMethod("setId", String.class);
        //执行方法
        Object result = setMethod.invoke(obj, "我是id参数");
        System.out.println(String.valueOf(result));
        System.out.println("=================");

        Method getMethod = aClass.getMethod("getId");
        //执行方法
        result = getMethod.invoke(obj);
        System.out.println(String.valueOf(result));
    }

    /**
     * private方法
     *
     * @throws Exception
     */
    @Test
    public void testPrivateMethod() throws Exception {
        //获得class对象
        Class<?> aClass = Class.forName("com.core.reflect.Bean");
        //获得构造函数
        Constructor<?> constructor = aClass.getConstructor(String.class, String.class);
        //获得实例
        Object obj = constructor.newInstance("id", "className");
        //获得方法（方法名，形成列表）
        Method setMethod = aClass.getDeclaredMethod("show");
        //暴力访问
        setMethod.setAccessible(true);
        //执行方法
        Object result = setMethod.invoke(obj);
        System.out.println(String.valueOf(result));

    }

    /**
     * main方法
     *
     * @throws Exception
     */
    @Test
    public void testMainMethod() throws Exception {
        //获得class对象
        Class<?> aClass = Class.forName("com.core.reflect.Bean");
        Method mainMethod = aClass.getMethod("main", String[].class);
        Object result = mainMethod.invoke(null, (Object) new String[]{});
        System.out.println(String.valueOf(result));
    }

    /**
     * public属性
     *
     * @throws Exception
     */
    @Test
    public void testField() throws Exception {
        //获得class对象
        Class<?> aClass = Class.forName("com.core.reflect.Bean");
        //获得实例
        Object obj = aClass.newInstance();
        //通过class对象获得字段属性
        Field descriptionField = aClass.getField("description");
        //为对象字段赋值
        descriptionField.set(obj, "description");
        //获取对象的字段值
        Object result = descriptionField.get(obj);
        System.out.println(String.valueOf(result));
    }

    /**
     * private属性
     *
     * @throws Exception
     */
    @Test
    public void testPrivateField() throws Exception {
        //获得class对象
        Class<?> aClass = Class.forName("com.core.reflect.Bean");
        //获得实例
        Object obj = aClass.newInstance();
        //通过class对象获得声明的字段属性
        Field classNameField = aClass.getDeclaredField("className");
        //暴力访问
        classNameField.setAccessible(true);
        //为对象字段赋值
        classNameField.set(obj, "className");
        //获取对象的字段值
        Object result = classNameField.get(obj);
        System.out.println(String.valueOf(result));
    }
}
