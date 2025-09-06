/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import model.Person;
import model.Persistable;
import service.PersistableService;

/**
 *
 * @author Luboš
 */
@Named(value = "persistableBean")
@RequestScoped
public class PersistableBean implements Serializable {

    @Inject
    private PersistableService service;
    private List<? extends Persistable> persistables;

    public PersistableBean() {
        
    }

    public void detail() {

    }

    public List<? extends Persistable> getPersistables() {
        persistables = service.findAll();
        return persistables;
    }

    public void setPersistables(List<? extends Persistable> list) {
        this.persistables = list;
    }
}
