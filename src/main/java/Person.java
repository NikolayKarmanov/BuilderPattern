public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String city;

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.getName();
        this.surname = personBuilder.getSurname();
        setAge(personBuilder.getAge());
        this.city = personBuilder.getCity();
    }

    public boolean hasAge() {
        return age > 0;
    }

    public boolean hasAddress() {
        return !city.equals(null);
    }

    public void setAge(int age) {
        // проверяем задан ли возраст
        if (hasAge()) {
            throw new IllegalStateException("Возраст уже задан!");
        }
        // проверяем введен ли адекватный ворзраст
        // будем реалистами - установим максимум 100 лет (хотя можно было и меньше)
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Возраст указан некорректно!");
        }
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // метод увеличивает возраст на 1 год
    public void happyBirthday() {
        age++;
    }

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

    // создает полузаполненный билдер для ребёнка с такими же фамилией и адресом
    protected PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setCity(this.city);
    }

    @Override
    public String toString() {
        return "[" + name + " " + surname + ", age: " + age + ", city: " + city + ".]";
    }
}
