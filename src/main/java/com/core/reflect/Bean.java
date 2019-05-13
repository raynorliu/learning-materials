package com.core.reflect;

/**
 * @author raynor
 */
public class Bean {
    private String id;

    private String className;

    public String description;

    public String getId() {

        System.out.println("getId方法执行");

        return id;

    }

    public void setId(String id) {

        System.out.println("setId方法执行：" + id);

        this.id = id;
    }

    private String show() {

        System.out.println("私有方法执行");

        return "Bean[" + id + ", " + className + "]";

    }

    public Bean(String id, String className) {
        System.out.println("有参构造函数方法执行：" + id + className);
        this.id = id;
        this.className = className;
    }

    public Bean() {
    }

    private Bean(String id) {
        this.id = id;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {

            System.out.print(i + ", ");
        }
    }
}