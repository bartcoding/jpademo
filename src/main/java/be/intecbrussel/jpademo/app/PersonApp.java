package be.intecbrussel.jpademo.app;


import be.intecbrussel.jpademo.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonApp {

    public static void main(String[] args) {

        Person person = new Person();
        person.setFirstName("Super");
        person.setLastName("Man");
        person.setAge(30);
        person.setAddress("America");
        person.setId(1);

        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
                try{
                    emf = Persistence.createEntityManagerFactory("mypersistenceunit");
                    entityManager = emf.createEntityManager();
                    EntityTransaction transaction = entityManager.getTransaction();
                    transaction.begin();
                    entityManager.persist(person);
                    transaction.commit();
                    System.out.println("person saved");

                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                finally {
                    if (entityManager != null){
                    entityManager.close();
                    }
                    if (emf!= null){
                        emf.close();
                    }
                }


    }
}
