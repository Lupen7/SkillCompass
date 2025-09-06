/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Person;
import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PersonService extends PersistableService{

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Person person) {
        em.persist(person);
    }

    @Override
    public List<Person> findAll() {
        System.out.println("\n >>>> looking for persons >>> ");
        return em.createQuery("SELECT u FROM Person u ORDER BY u.id", Person.class)
                 .getResultList();
    }

 
}