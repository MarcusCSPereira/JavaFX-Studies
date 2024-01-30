package model;

public class Customer {

    private String name;
    private int age;
    private int number=0;
    
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
        this.number++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    
}
