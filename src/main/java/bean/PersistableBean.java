/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import model.Persistable;
import model.Person;
import service.PersistableService;

/**
 *
 * @author Luboš
 */
@Named(value = "persistableBean")
@SessionScoped
public class PersistableBean implements Serializable {

    @Inject
    private PersistableService service;
    private List<? extends Persistable> persistables;
    private Persistable selectedPersistable;
    protected String detail = "default";
    private final String REDIRECT = ".xhtml" + "?faces-redirect=true";
            
    public PersistableBean() {

    }

    public List<? extends Persistable> getPersistables() {
        persistables = service.findAll();
        return persistables;
    }

    public void setPersistables(List<? extends Persistable> list) {
        this.persistables = list;
    }

    public Persistable getSelectedPersistable() {
        return selectedPersistable;
    }

    public void setSelectedPersistable(Persistable persistable) {
        System.out.println("\n >>>> Setting selected persistable of class: " + persistable.getClass());
        this.selectedPersistable = persistable;
    }

    public String openDetail(Persistable persistable) {
        setSelectedPersistable(persistable);
        return getDetail();
    }

    public String getDetail() {
        String current_detail = this.detail;
        if (this.selectedPersistable instanceof Person) {
            current_detail = "person";
        }
        System.out.println("\n>>> Detail is : " + current_detail);
        return current_detail + REDIRECT;
    }

}
