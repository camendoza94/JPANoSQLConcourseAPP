/*
 * The MIT License
 *
 * Copyright 2016 Universidad De Los Andes - Departamento de Ingeniería de Sistemas.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package co.edu.uniandes.isis2503.basic.persistence;

import co.edu.uniandes.isis2503.basic.interfaces.ICompetitorPersistence;
import co.edu.uniandes.isis2503.basic.model.entity.CompetitorEntity;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Luis Felipe Mendivelso Osorio <lf.mendivelso10@uniandes.edu.co>
 */
public class CompetitorPersistence implements ICompetitorPersistence {
    
    private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(CompetitorPersistence.class.getName());
    
    private EntityManager em;

    public CompetitorPersistence() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConcourseAPP");
        em = emf.createEntityManager();
    }

    public CompetitorPersistence(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public CompetitorEntity add(CompetitorEntity entity) {
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(entity);
            tx.commit();
            em.refresh(entity);
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            LOG.log(Level.WARNING, e.getMessage());
        }
        return entity;
    }

    @Override
    public CompetitorEntity update(CompetitorEntity entity) {
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.merge(entity);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            LOG.log(Level.WARNING, e.getMessage());
        }
        return entity;
    }

    @Override
    public CompetitorEntity find(Long id) {
        CompetitorEntity competitor;
        Query query = em.createQuery("Select e FROM CompetitorEntity e WHERE e.id = :id");
        query.setParameter("id", id);
        try {
            competitor = (CompetitorEntity) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            competitor = null;
            LOG.log(Level.WARNING, e.getMessage());
        }
        return competitor;
    }

    @Override
    public CompetitorEntity findByName(String name) {
        CompetitorEntity competitor;
        Query query = em.createQuery("Select e FROM CompetitorEntity e WHERE e.name = :name");
        query.setParameter("name", name);
        try {
            competitor = (CompetitorEntity) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            competitor = null;
            LOG.log(Level.WARNING, e.getMessage());
        }
        return competitor;
    }

    @Override
    public CompetitorEntity findByEmail(String email) {
        CompetitorEntity competitor;
        Query query = em.createQuery("Select e FROM CompetitorEntity e WHERE e.email = :email");
        query.setParameter("email", email);
        try {
            competitor = (CompetitorEntity) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            competitor = null;
            LOG.log(Level.WARNING, e.getMessage());
        }
        return competitor;
    }

    @Override
    public List<CompetitorEntity> all() {
        List<CompetitorEntity> competitors;
        Query query = em.createQuery("Select c FROM CompetitorEntity c");
        try {
            competitors = query.getResultList();
        } catch (NoResultException | NonUniqueResultException e) {
            competitors = null;
            LOG.log(Level.WARNING, e.getMessage());
        } finally {
            em.close();
        }
        return competitors;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public Boolean delete(CompetitorEntity entity) {
        EntityTransaction tx = null;
        Query query = em.createQuery("Select e FROM CompetitorEntity e WHERE e.id = :id");
        query.setParameter("id", entity.getId());

        try {
            CompetitorEntity found = (CompetitorEntity) query.getSingleResult();
            if (found != null) {
                tx = em.getTransaction();
                tx.begin();
                em.remove(found);
                tx.commit();
                return true;
            } else {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            LOG.log(Level.WARNING, e.getMessage());
            return false;
        }
    }
}
