/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Person;
import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import model.Persistable;

@ApplicationScoped
public class PersonService extends PersistableService{

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Person person) {
        System.out.println("Mergin person and saving it....");
        System.out.println(person.toString());
        em.merge(person);
    }

    @Override
    public List<Person> findAll() {
       // System.out.println("\n >>>> looking for persons >>> ");
        return em.createQuery("SELECT u FROM Person u ORDER BY u.id", Person.class)
                 .getResultList();
    }

    @Override
    public Person findById(long id) {
        System.out.println("Looking for person, ID: " + id);

        TypedQuery<Person> query = em.createNamedQuery("Person.findById", Person.class);
        // Set the value of the named parameter
        query.setParameter("id", id);
        // Execute the query and get the single result
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No Person of id: " + id + "was found.");
            return null; // or throw a custom exception
        }
    }

    @Override
    public void save(Persistable persistable) {
        this.save((Person) persistable);
    }

 
}