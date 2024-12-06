package com.klu.mavenHibernate;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("Hibernate.cfg.xml").build();
        Metadata md=new MetadataSources().getMetadataBuilder(ssr).build();
        
        SessionFactory sf=md.getSessionFactoryBuilder().build();
        Session s=sf.openSession();
        Transaction tr;
        
        Student st=new Student();
        st.setName("Rishitha");
        tr=s.beginTransaction();
        s.save(st);
        tr.commit();
        System.out.println("Data Inserted....");
        
        //Student st1 =s.find(Student.class, 6);
        //st1.setName("Laxmi");
       // tr.begin();
        //s.update(st1);
        //tr.commit();
        //System.out.println("data updated successfully");
        
        //Student st2 =s.find(Student.class, 6);
        //tr.begin();
        //s.delete(st2);
        //tr.commit();
        //System.out.println("data deleted successfully");
        
        Criteria c = s.createCriteria(Student.class);
        		c.add(Restrictions.gt("id", 8));
        		List<Student> l=c.list();
        		for(Student s1: l) {
        			System.out.println("id= " + s1.getId() + ", name = " + s1.getName());
        		}
	     Query<Student> qry = s.createQuery("select ST from Student ST where ST.id > 10", Student.class);
	      List<Student> l2=qry.getResultList();
	      for (Student s1: l2) {
	        System.out.println("id= " + s1.getId() + ", name= " + s1.getName());  
	      }
        Acceleration ac = new Acceleration();
        ac.setCourse("jfsd");
        ac.setResult("pass");
        ac.setName("Rishi");
        tr.begin();
        s.save(ac);
        tr.commit();
        System.out.println("Acceleration inserted....");
        
        OddSemester os=new OddSemester();
        os.setCourse("mern");
        os.setName("Varun");
        os.setRegistration("odd sem");
        tr.begin();
        s.save(os);
        tr.commit();
        System.out.println("Odd semester inserted");
        
        
        
    }
}
