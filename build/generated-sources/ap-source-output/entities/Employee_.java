package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, String> password;
	public static volatile SingularAttribute<Employee, Date> dateNaissance;
	public static volatile SingularAttribute<Employee, Service> service;
	public static volatile SingularAttribute<Employee, Employee> chef;
	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SingularAttribute<Employee, String> nom;
	public static volatile SingularAttribute<Employee, String> prenom;

}

