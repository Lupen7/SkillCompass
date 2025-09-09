/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.codelist;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Luboš
 */
@Entity
@Table(name = "cl_state")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClState.findAll", query = "SELECT c FROM CLState c"),
    @NamedQuery(name = "ClState.findByCode", query = "SELECT c FROM CLState c WHERE c.code = :code"),
    @NamedQuery(name = "ClState.findByName", query = "SELECT c FROM CLState c WHERE c.name = :name")})
public class CLState extends CodeList implements Serializable {

   
    public CLState() {
    }

    public CLState(String code) {
        this.code = code;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CLState)) {
            return false;
        }
        CLState other = (CLState) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.codelist.ClState[ code=" + code + " ]";
    }
    
}
