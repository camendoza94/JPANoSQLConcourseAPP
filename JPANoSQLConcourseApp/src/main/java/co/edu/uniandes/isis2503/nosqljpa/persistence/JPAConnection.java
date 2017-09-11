package co.edu.uniandes.isis2503.nosqljpa.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class JPAConnection {
 
    public static final String MONGO = "mongo_db";
    public static final String DERBY = "derby_db";
 
    public static final String DB = DERBY;
 
    private EntityManager entityManager;
    public static final JPAConnection CONNECTION = new JPAConnection();
 
    public JPAConnection(){
        if (entityManager == null) {
            EntityManagerFactory emf;
            emf = Persistence.createEntityManagerFactory(DB);
            entityManager = emf.createEntityManager();
        }
    }
 
    public EntityManager getEntityManager() {
        return entityManager;
    }
 
}