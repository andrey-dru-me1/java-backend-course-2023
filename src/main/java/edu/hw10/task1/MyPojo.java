package edu.hw10.task1;

class MyPojo {
    @NotNull
    private String name;

    @Min(18)
    @Max(100)
    private int age;

    public MyPojo() {
    }

    public MyPojo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyPojo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
