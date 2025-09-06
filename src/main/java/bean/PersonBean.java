/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import java.util.List;
import model.Person;
import service.PersonService;

/**
 *
 * @author Luboš
 */
@Named(value = "chargerBean")
@Dependent
public class PersonBean {

    @Inject
    private PersonService service;
    private List<Person> personList;
    
    public PersonBean() {
    }
    
    public List<Person> getChargerList() {
       if (personList == null) {
            personList = service.findAll();
        }
        return personList;
    }
    
}
