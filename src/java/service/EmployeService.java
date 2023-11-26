/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Employee;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author ikram
 */

public class EmployeService extends AbstractFacade<Employee> {

    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }
     public List<Object[]> nbremployebyservice(){
        List<Object[]> emp = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
emp  = session.createQuery("select count(e.id), s.code from Employe e right join e.service s group by s.code").list();
        session.getTransaction().commit();
        return emp;
    }
    
    public List<Employee> getEmployeesForChef(Employee chef) {

        List<Employee> employes = new ArrayList<Employee>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        employes = session.createQuery("FROM Employe e WHERE e.chef = :chef").setParameter("chef", chef).list();
        session.getTransaction().commit();
        return employes;

    }
}
