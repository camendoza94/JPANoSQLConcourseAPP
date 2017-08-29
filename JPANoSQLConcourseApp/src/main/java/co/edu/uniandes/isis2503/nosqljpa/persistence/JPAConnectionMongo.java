package co.edu.uniandes.isis2503.nosqljpa.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConnectionMongo {

    public static final String MONGO = "mongo_db";

    private EntityManager entityManager;
    public static final JPAConnectionMongo CONNECTION = new JPAConnectionMongo();

    public JPAConnectionMongo() {
        if (entityManager == null) {
            EntityManagerFactory emf;
            emf = Persistence.createEntityManagerFactory(MONGO);
            entityManager = emf.createEntityManager();
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
