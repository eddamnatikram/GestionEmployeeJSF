/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaines;

import entities.Service;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;
import service.ServiceService;

/**
 *
 * @author Lachgar
 */
@ManagedBean
@RequestScoped
public class ServiceBean {
    
     private Service service ;
    private ServiceService service1;
    
    private List<Service> services;

    public ServiceBean() {
        service=new Service();
        service1=new ServiceService();
        
    }

    public List<Service> getServices() {
        if(services == null){
            services=service1.getAll();
        }
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
    
    public  String onDeleteAction(){
        service1.delete(service);
        return null;
    }
    public void onCancel(RowEditEvent event) {
    }
    public void onEdit(RowEditEvent event) {
        service = (Service) event.getObject();
        service1.update(service);
        
    }

    
     public String onCreateAction() {
        service1.create(service);
        service = new Service();
        return null;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
     
    
}
