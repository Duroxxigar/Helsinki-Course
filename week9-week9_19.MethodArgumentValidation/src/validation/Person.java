package validation;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        if (name == null) {
            throw new IllegalArgumentException("Name is null");
        }
        if (name.equals("")) {
            throw new IllegalArgumentException("Name is blank");
        }
        if (name.length() > 40) {
            throw new IllegalArgumentException("Name is greater than 40 characters");
        }
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age is not between 0-120");
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
