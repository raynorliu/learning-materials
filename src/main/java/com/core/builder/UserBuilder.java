package com.core.builder;

/**
 * builder构建者模式
 * @author raynor
 */
public class UserBuilder {
    private String name;
    private String sex;
    private int age;

    private UserBuilder(Builder builder) {
        this.name = builder.name;
        this.sex = builder.sex;
        this.age = builder.age;
    }

    public static class Builder {
        private String name;
        private String sex;
        private int age;

        public Builder(String name) {
            this.name = name;
        }


        public Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder build() {
            return new UserBuilder(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
