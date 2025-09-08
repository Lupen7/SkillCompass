
package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import model.codelist.CodeList;

@ApplicationScoped
public class CodeListService {
    
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(CodeList cl) {
        em.persist(cl);
    }

    
    public List<? extends CodeList> findAll(Class clazz, String table) {
        return em.createQuery("SELECT u FROM " + table + " u ORDER BY u.code", clazz)
                 .getResultList();
    }
    
    public CodeList findById(long id) {
        return null;
    }

    /*
    public List<Persistable> findAll(Class clazz, String db_table) {
        return em.createQuery("SELECT u FROM " + db_table + " u ORDER BY u.id", clazz)
                 .getResultList();
    }
    
    public Persistable selectOne() {
        return null;
    }*/
}
