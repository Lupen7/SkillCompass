package bean;

import jakarta.enterprise.context.ConversationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import java.io.Serializable;
import model.Address;
import model.Person;
import service.PersonService;

@Named(value = "personBean")
@ViewScoped
public class PersonBean extends PersistableBean implements Serializable {

    @Inject
    private PersonService service;

    public PersonBean() {
        System.out.println("Person bean is initialized.");
    }

    public Person getSelectedPerson() {
        System.out.println("Service is tpe of: " + service.getClass());
        return (Person) selectedPersistable;
    }

    public void setSelectedPerson(Person selectedtPerson) {
        this.selectedPersistable = selectedtPerson;
    }

    public String getFullName() {
        return (getSelectedPerson().getName() + ' ' + getSelectedPerson().getSurname());
    }

    public void openDetail(Person p) {
        if (p.getAddress() == null) {
            System.out.println("Selecting person, address is null - creating new empty address");
            p.setAddress(new Address());
        }
        super.openDetail(p);
    }
    
    public void newPerson() {
        Person p = new Person();
        this.setSelectedPerson(p);
        openDetail(p);
    }
}
