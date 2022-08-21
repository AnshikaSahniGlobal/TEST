package com.java.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Question2.EmployeeEntity;

public class Employee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    EntityManagerFactory emf=Persistence.createEntityManagerFactory("Employee_details");
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    EmployeeEntity e1=new EmployeeEntity();
	    e1.setEmpId(1);
        e1.setEmpName("anshika sahni");
        e1.setEmpDept("computer science");
        e1.setEmpSal(60000.0);
        em.persist(e1);
        em.getTransaction().commit();
        Query q= em.createQuery("from EmployeeEntity");
         List <EmployeeEntity> list= q.getResultList();
         for(EmployeeEntity e:list)
        {
        
            System.out.println(e.getEmpId()+" "+e.getEmpName()+" "+e.getEmpSal()+" "+e.getEmpDept());
         }
        
	}

}
