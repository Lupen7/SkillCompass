/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import model.Persistable;
import model.codelist.enumer.ViewType;
import service.PersistableService;

/**
 *
 * @author Luboš
 */
@Named(value = "persistableBean")
@ViewScoped
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
        System.out.println("Persistable bean: delete action called... Pesistable ID: " + selectedPersistable.getId());
        
        try {
            // Call the service method to remove the user from the database
            service.delete(selectedPersistable);
            // Remove the user from the local list to refresh the UI
            this.persistables.remove(selectedPersistable);
            // Optional: Show a success message
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Item deleted successfully!", null));
        } catch (Exception e) {
            // Handle any exceptions and show an error message
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting user.", null));
        }
        setViewType(ViewType.LIST);
    }

    public void saveAction() {
        selectedPersistable = service.save(selectedPersistable);
        this.isEditable = false;
        //this.selectedPersistable = service.findById(selectedPersistable.getId());
        System.out.println("Persistable bean: save action called: " + selectedPersistable.toString());
    }

    public void openDetail(Persistable p) {
        System.out.println("Opening persistable detail: " + p.toString());
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
