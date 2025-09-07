/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import model.Persistable;

@ApplicationScoped
public abstract class PersistableService {
    
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Persistable persistable) {
        em.persist(persistable);
    }

    
    public abstract List<? extends Persistable> findAll();
    public abstract Persistable findById(long id);

    /*
    public List<Persistable> findAll(Class clazz, String db_table) {
        return em.createQuery("SELECT u FROM " + db_table + " u ORDER BY u.id", clazz)
                 .getResultList();
    }
    
    public Persistable selectOne() {
        return null;
    }*/
}
