package com.core.properties;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * Properties文件操作示例
 * Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串
 * 特点：
 * 1、Map接口的子类，map中的方法都可以用。
 * 2、该集合没有泛型。键值都是字符串。
 * 3、它是一个可以持久化的属性集。键值可以存储到集合中，也可以存储到持久化的设备(硬盘、U盘、光盘)上。键值的来源也可以是持久化的设备。
 * 4、有和流技术相结合的方法。
 *
 * @author raynor
 * @date 2019-05-13
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        //创建Properties对象
        Properties prop = new Properties();
        //添加元素到集合
//        prop.put(key, value);
        prop.setProperty("name", "Raynor");
        prop.setProperty("title", "java programmer");
        //遍历集合
        Set<String> keys = prop.stringPropertyNames();
        for (String key : keys) {
            Object obj = prop.get(key);
            String value = prop.getProperty(key);
            System.out.println(key + "：" + value);
            System.out.println(key + "==" + obj);
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "123Q");
        map.put("key2", "456Q");
        setProperties(map);
    }

    /**
     * 将集合中内容存储到Properties文件
     * 注意请在编译后的文件目录中查看写入的信息
     */
    @Test
    public void saveProperties() throws IOException {
        FileOutputStream out = null;
        FileWriter fw = null;
        try {
//            InputStream is = PropertiesDemo.class.getClassLoader().getResourceAsStream("prop.properties");
//            InputStream input = new FileInputStream("prop.properties");
            //1创建Properties对象
            Properties prop = new Properties();
            //2添加元素到集合
            prop.put("Language", "Java");
            prop.setProperty("Name", "Raynor");
            prop.setProperty("Title", "Programmer");

            //这种方法需要在resources目录下先创建对应的properties文件
            //PropertiesDemo.class为当前类名,prop.properties为路径
            String path = PropertiesDemo.class.getResource("/prop.properties").getPath();
            //3创建流
            out = new FileOutputStream(path);
            //4将集合中的数据存储到流所对应的文件中
            prop.store(out, "save data");

            // 这种方法无需事先创建对应的文件，会直接将文件保存在根路径目录下
//            fw = new FileWriter("prop.properties");
//            prop.store(fw,"save data");
        } finally {
            //5关闭流
//            out.close();
            fw.close();
        }
    }

    /**
     *
     * @param data 需要写入properties文件的map集合数据
     */
    public static void setProperties(Map<String, String> data) throws IOException {
        InputStream input = null;
        OutputStream out = null;
        //1.步取得一个Properties对象
        Properties props = new Properties();
        //2.取得该配置文件的输入流
        try {
            input = PropertiesDemo.class.getClassLoader().getResourceAsStream("prop.properties");
            String path = PropertiesDemo.class.getResource("/prop.properties").getPath();
//            String path = input.getClass().getResource("/prop.properties").getPath();
//            input = new FileInputStream("prop.properties");
            //3.把配置文件的输入流load到Properties对象中，
            props.load(input);
            //接下来就可以随便往配置文件里面添加内容了
            if (data != null) {
                Iterator<Map.Entry<String, String>> iterator = data.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, String> entry = iterator.next();
                    props.setProperty(entry.getKey(), entry.getValue());
                }
            }
            //在保存配置文件之前还需要取得该配置文件的输出流，切记，如果该项目是需要导出的且是一个非WEB项目，则该配置文件应当放在根目录下，否则会提示找不到配置文件
            out = new FileOutputStream(path);
            //4利用Properties对象保存配置文件的输出流到文件中;
            props.store(out, "modify");
        } finally {
            input.close();
            out.close();
        }
    }

    /**
     * 读取properties文件
     */
    @Test
    public void getProperties() throws IOException {
//        InputStream in = null;
        FileReader in = null;
        try {
            //1创建Properties对象
            Properties prop = new Properties();
            //2.创建输入流对象
//            in = PropertiesDemo.class.getClassLoader().getResourceAsStream("prop.properties");
            //文件流可以读取中文
            String path = PropertiesDemo.class.getResource("/prop.properties").getPath();
            in=new FileReader(path);
            prop.load(in);
            Set<String> strings = prop.stringPropertyNames();
            for (String key : strings) {
                String value = prop.getProperty(key);
                System.out.println(key + "：" + value);
            }
        } finally {
            in.close();
        }
    }

}
