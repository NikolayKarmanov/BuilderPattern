public class Main {
    public static void main(String[] args) {

        Person person = new PersonBuilder()
                .setName("Николай")
                .setSurname("Карманов")
                .setAge(36)
                .setCity("Заинск")
                .build();
        System.out.println(person);

//        person.setAge(30);
        person.happyBirthday();
        System.out.println(person);

        Person son = person.newChildBuilder()
                .setName("Тимофей")
                .setAge(10)
                .build();
        System.out.println("У " + person + " есть сын - " + son);

//        try {
//            // Не хватает обязательных полей
//            new PersonBuilder().build();
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        }

//        try {
//            // Возраст недопустимый
//            new PersonBuilder().setAge(-100).build();
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
    }
}
