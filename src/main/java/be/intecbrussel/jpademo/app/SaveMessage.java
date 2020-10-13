package be.intecbrussel.jpademo.app;

import be.intecbrussel.jpademo.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class SaveMessage {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        try{
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            entityManager = emf.createEntityManager();

            String messageToSave = readMessageFromKeyboard();

            Message message = new Message();
            message.setContent(messageToSave);
            EntityTransaction transaction = entityManager.getTransaction();
            System.out.println("id before persist" + message.getId());
            transaction.begin();
            entityManager.persist(message);
            transaction.commit();
            System.out.println("id after persist" + message.getId());


        }
        catch (Exception ex){
ex.printStackTrace();
        }
        finally {
            if(entityManager != null){
                entityManager.close();
            }
            if (emf != null){
                emf.close();
            }

        }

    }

    private static String readMessageFromKeyboard() {
        System.out.println("please enter a message you would like to save");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();;
        scanner.close();
        return message;
    }

}
