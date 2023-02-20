package com.control;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import com.entity.Class;
import com.entity.Subject;
import com.entity.Teacher;

public class HibernateUtil {
	static Session sessionObj;
    static SessionFactory sessionFactoryObj;
    static Transaction transaction;
    static Set<Teacher> teachers=new HashSet<>();
    static Set<Subject> subjects=new HashSet<>();
    static Set<Class> classes=new HashSet<>();
    static Iterator<Class> classItr;
    
 
	
	public static Session getSession()
	{
		
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		sessionFactoryObj=meta.getSessionFactoryBuilder().build();
		sessionObj=sessionFactoryObj.openSession();
		transaction=sessionObj.beginTransaction();
		return sessionObj;
		
			
	}
	
	public static void commitTransaction()
	{
		transaction.commit();
	}
	
	
	private static SessionFactory buildSessionFactory() {
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
       ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
       sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }
	
	public static void initializingTables()
	{
		sessionFactoryObj=HibernateUtil.buildSessionFactory();
		sessionObj=sessionFactoryObj.openSession();
		transaction=sessionObj.beginTransaction();
		Subject subject1=new Subject(1,"English");
		Subject subject2=new Subject(2,"Hindi");
		Subject subject3=new Subject(3,"Kannada");
		Subject subject4=new Subject(4,"Social Science");
		Subject subject5=new Subject(5,"Science");
		Subject subject6=new Subject(6,"Mathematics");
		Subject subject7=new Subject(7,"Drawing");
		Subject subject8=new Subject(8,"Computer Science");
	
		
		subjects.add(subject1);
		subjects.add(subject2);
		subjects.add(subject3);
		subjects.add(subject4);
		subjects.add(subject5);
		subjects.add(subject6);
		subjects.add(subject7);
		subjects.add(subject8);
		
		
		sessionObj.save(subject1);
		sessionObj.save(subject2);
		sessionObj.save(subject3);
		sessionObj.save(subject4);
		sessionObj.save(subject5);
		sessionObj.save(subject6);
		
		
		Teacher teacher1=new Teacher(1,"Shailendra Singh");
		Teacher teacher2=new Teacher(2,"Divya Bharati");
		Teacher teacher3=new Teacher(3,"Narendra modi");
		Teacher teacher4=new Teacher(4,"Priyanka ganghi");
		Teacher teacher5=new Teacher(5,"Rajeev Gandhi");
		Teacher teacher6=new Teacher(6,"Shankar goel");
		
		
		teachers.add(teacher1);
		teachers.add(teacher2);
		teachers.add(teacher3);
		teachers.add(teacher4);
		teachers.add(teacher5);
		teachers.add(teacher6);
		
		sessionObj.save(teacher1);
		sessionObj.save(teacher2);
		sessionObj.save(teacher3);
		sessionObj.save(teacher4);
		sessionObj.save(teacher5);
		sessionObj.save(teacher6);
		
		Class class1=new Class(1,"1");
		Class class2=new Class(2,"2");
		Class class3=new Class(3,"3");
		Class class4=new Class(4,"4");
		Class class5=new Class(5,"5");
		Class class6=new Class(6,"6");
		Class class7=new Class(7,"7");
		
		
		classes.add(class1);
		classes.add(class2);
		classes.add(class3);
		classes.add(class4);
		classes.add(class5);
		classes.add(class6);
		classes.add(class7);
		
		
		sessionObj.save(class1);
		sessionObj.save(class2);
		sessionObj.save(class3);
		sessionObj.save(class4);
		sessionObj.save(class5);
		sessionObj.save(class6);
		sessionObj.save(class7);
		
		classItr=classes.iterator();
		
		
}
	
	
     public static void setSubjects(Class classes,Set<Subject> subjects) {
    	 classes.setSubjects(subjects);
    	 
     }
     
     public static void setTeachers(Class classes,Set<Teacher> teachers) {
    	 classes.setTeacher(teachers);
    	 
     }
	
	
	
	
}
