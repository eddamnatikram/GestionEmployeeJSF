/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author ikram
 */
@Entity
public class Employee implements Serializable {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String password;
    private Date dateNaissance;

    @ManyToOne
    private Employee chef;

    public Employee() {
        
        super();
    }
    @ManyToOne
    private Service service;


    public Employee(int id, String nom, String prenom, String password, Date dateNaissance, Employee chef, Service service) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.chef = chef;
        this.service = service;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Employee getChef() {
        return chef;
    }

    public void setChef(Employee chef) {
        this.chef = chef;
    }
  

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
    

    
}
