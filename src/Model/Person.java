package Model;

public class Person {
    private String name;
    private Integer age;
    private Double height;

    public Person(String name, Integer age, Double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public Double getHeight() {
        return this.height;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.age + ", " + this.getHeight();
    }
}
