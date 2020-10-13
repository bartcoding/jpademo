package be.intecbrussel.jpademo.app;

import be.intecbrussel.jpademo.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetMessage {
    public static void main(String[] args) {
        EntityManagerFactory emf= null;
        EntityManager em = null;

        try{
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();

            Message message = em.find(Message.class,1);
            System.out.println(message);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
