package co.edu.uniandes.isis2503.nosqljpa.persistence;

import com.impetus.client.cassandra.common.CassandraConstants;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConnectionCassandra {

    public static final String CASSANDRA = "cassandra_db";

    private EntityManager entityManager;
    public static final JPAConnectionCassandra CONNECTION = new JPAConnectionCassandra();

    public JPAConnectionCassandra() {
        if (entityManager == null) {
            EntityManagerFactory emf;
            Map<String, String> propertyMap = new HashMap<>();
            propertyMap.put(CassandraConstants.CQL_VERSION, CassandraConstants.CQL_VERSION_3_0);
            emf = Persistence.createEntityManagerFactory(CASSANDRA, propertyMap);
            entityManager = emf.createEntityManager();
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
