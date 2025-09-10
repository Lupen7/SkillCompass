/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import model.Persistable;
import model.Person;
import model.codelist.ViewType;
import service.PersistableService;

/**
 *
 * @author Luboš
 */
@Named(value = "persistableBean")
@SessionScoped
public class PersistableBean implements Serializable {

    @Inject
    protected PersistableService service;
    protected List<? extends Persistable> persistables;
    protected Persistable selectedPersistable;
    protected boolean isEditable = false;
    protected ViewType viewType = ViewType.LIST;

    public PersistableBean() {

    }

    public boolean isIsEditable() {
        return isEditable;
    }

    public void setIsEditable(boolean isEditable) {
        this.isEditable = isEditable;
    }

    public void editAction() {
        System.out.println("Persistable bean: edit action called...");
        this.isEditable = !this.isEditable;
    }

    public void cancelAction() {
        System.out.println("Persistable bean: cancel action called...");
        setViewType(ViewType.LIST);
        this.isEditable = false;
    }
    
    public void deleteAction() {
        System.out.println("Persistable bean: delete action called...");
        setViewType(ViewType.LIST);
    }
    
    public void saveAction() {
        System.out.println("Persistable bean: save action called: " + selectedPersistable.toString());
        service.save(selectedPersistable);
        this.isEditable = false;
    }

    public void openDetail(Persistable p) {
        setSelectedPersistable(p);
        setViewType(ViewType.DETAIL);
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
        System.out.println("Setting selected persistable of class: " + persistable.getClass());
        this.selectedPersistable = persistable;
    }

    public ViewType getViewType() {
        return viewType;
    }

    public void setViewType(ViewType vt) {
        this.viewType = vt;
    }

}
