/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import jakarta.enterprise.context.ConversationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import model.Person;
import service.PersonService;

/**
 *
 * @author Luboš
 */
@Named(value = "personBean")
@ConversationScoped
public class PersonBean extends PersistableBean {

    @Inject
    private PersonService service;
    private Person selectedtPerson;

    public String openDetail(int personId) {
        System.out.println("PersonId for detail is : " + personId);
        if (personId != 0) {
            this.selectedtPerson = service.findById(personId);
        } else {
            selectedtPerson = new Person();
        }
        return "person" + ".xhtml";
    }

    public Person getSelectedPerson() {
        return selectedtPerson;
    }

    public void setSelectedPerson(Person selectedtPerson) {
        this.selectedtPerson = selectedtPerson;
    }

    public String getFullName() {
        return (this.selectedtPerson.getName() + ' ' + this.selectedtPerson.getSurname());
    }

}
