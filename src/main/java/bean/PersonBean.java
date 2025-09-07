/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import java.util.List;
import model.Persistable;
import model.Person;
import service.PersonService;

/**
 *
 * @author Luboš
 */
@Named(value = "personBean")
@Dependent
public class PersonBean extends PersistableBean{

    @Inject
    private PersonService service;
    private List<Person> personList;
    private final String detail = "person.xhtml";
    
    public PersonBean() {
        System.out.println("----- PersonBean initialized -----");
    }

    
    
}
