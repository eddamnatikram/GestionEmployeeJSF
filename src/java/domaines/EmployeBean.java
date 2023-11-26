/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaines;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import service.*;
import entities.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean(name = "employeBean")
@SessionScoped
public class EmployeBean implements Serializable{

     private Employee employe ;
    private EmployeService employees;
    private Employee chef;

    public static ChartModel getBarModel() {
        return barModel;
    }

    
    private Service service;
    private static ChartModel barModel;

    public Employee getSelectedChef() {
        return selectedChef;
    }

    public void setSelectedChef(Employee selectedChef) {
        this.selectedChef = selectedChef;
    }
    private ServiceService serviceService; 
    private Employee selectedChef;
    
    
    private List<Employee> employes;

    public EmployeBean() {
        employe=new Employee();
        service = new Service();
        chef = new Employee();
        employe.setChef(chef);
        employe.setService(service);
        employees=new EmployeService();
       serviceService=new ServiceService();
    }

    public List<Employee> getEmployes() {
        if(employes == null){
            employes=employees.getAll();
        }
        return employes;
    }

    public void setEmployes(List<Employee> employes) {
        this.employes = employes;
    }
    
    public  String onDeleteAction(){
        employe.setService(null);
        employees.delete(employe);
        return null;
    }
    public void onCancel(RowEditEvent event) {
    }
    public void onEdit(RowEditEvent event) {
        try  {
        employe = (Employee) event.getObject();
        Service s = serviceService.getById(this.employe.getService().getId());
    
        employe.setService(s);
        employe.getService().setCode(s.getCode());
        employees.update(employe);
    } catch (Exception e) {
       
            e.printStackTrace();
    }
        
    }

   public String onCreateAction() {
    if (employe.getChef() != null) {
        Employee chef = employees.getById(employe.getChef().getId());
        employe.setChef(chef);
        chef.setChef(employe); // Assurez-vous que la propriété est appelée "chief" et non "isChief"
    } else {
        employe.setChef(null);
    }

    // Pas besoin de redéfinir "chef.setChief(true);" car il a déjà été fait dans la condition ci-dessus

    employe.setService(service); // Assurez-vous que "service" est initialisé

    employees.create(employe);

    // Réinitialisez uniquement les propriétés nécessaires après la création
    employe = new Employee();
    employe.setChef(null);
    employe.setService(null);

    return null;
}


    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employee getEmploye() {
        return employe;
    }

    public void setEmploye(Employee employe) {
        this.employe = employe;
    }
    
      
    
  
   
    
   

public String validateUsernamePassword() {
    try {
                System.out.println("validateUsernamePassword method called");

        // Validate if the entered username is a valid integer
        int nomAsInt = Integer.parseInt(employe.getNom());

        // Retrieve the actual employee from the database based on the entered username
        Employee actualEmployee = employees.getById(nomAsInt);

        if (actualEmployee != null && actualEmployee.getPassword().equals(employe.getPassword())) {
            // Redirect to the success page if validation succeeds
            return "service.xhtml?faces-redirect=true";
        } else {
            // Display an error message if validation fails
FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nom d'utilisateur ou mot de passe incorrect"));
            return null;
        }
    } catch (NumberFormatException e) {
        // Handle the case where the entered username is not a valid integer

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nom d'utilisateur doit être un nombre"));
        return null;
    }
}






}
