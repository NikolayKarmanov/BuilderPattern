public class PersonBuilder {
    private String name = null;
    private String surname = null;
    private int age;
    private String city;


    //========СЕТТЕРЫ========
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    //сборка объекта Person
    public Person build() {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст указан некорректно!");
        }
        if (name == null) {
            throw new IllegalStateException("Не указано имя!");
        }
        if (surname == null) {
            throw new IllegalStateException("Не указана фамилия!");
        }
        return new Person(this);
    }


    //========ГЕТТЕРЫ========
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }
}
