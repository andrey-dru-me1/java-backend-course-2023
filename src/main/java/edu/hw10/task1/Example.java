package edu.hw10.task1;

public class Example {
    public static void main(String[] args) throws Exception {
        RandomObjectGenerator rog = new RandomObjectGenerator();

        // Пример использования для POJO
        MyPojo pojo = rog.nextObject(MyPojo.class, null);
        System.out.println(pojo);

        // Пример использования для Record
        MyRecord record = rog.nextObject(MyRecord.class, null);
        System.out.println(record);
    }
}
