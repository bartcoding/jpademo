package be.intecbrussel.jpademo.app;


import be.intecbrussel.jpademo.model.Person;

public class App {

    public static void main(String[] args) {

        Person p = new Person();
        p.setFirstName("Super");
        p.setLastName("Man");
        p.setAge(30);
        p.setAddress("America");
        p.setId(1);

        System.out.println(p);


    }
}
