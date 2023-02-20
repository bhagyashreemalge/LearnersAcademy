package com.control;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.entity.Class;
import com.entity.Student;
import com.entity.Subject;
import com.entity.Teacher;



public class H_Main {
	//static SessionFactory sessionFactoryObj;
	//static Session sessionObj;
	
	public static Session session;
	public static Transaction transaction;
	public static Set<Subject> subjects=new HashSet<>();
	public static Set<Teacher> teachers=new HashSet<>();
	public static Set<Class> classes=new HashSet<>();
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Configuration configuration=new Configuration().configure();
			configuration.addAnnotatedClass(com.entity.Class.class);
			configuration.addAnnotatedClass(com.entity.Student.class);
			configuration.addAnnotatedClass(com.entity.Subject.class);
			configuration.addAnnotatedClass(com.entity.Teacher.class);
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory=configuration.buildSessionFactory(builder.build());
			session=factory.openSession();
			transaction=session.beginTransaction();
			
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
			
			session.save(subject1);
			session.save(subject2);
			session.save(subject3);
			session.save(subject4);
			session.save(subject5);
			session.save(subject6);
			session.save(subject7);
			session.save(subject8);
			
			
			
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
			
			session.save(teacher1);
			session.save(teacher2);
			session.save(teacher3);
			session.save(teacher4);
			session.save(teacher5);
			session.save(teacher6);
			
			
			
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
			
			/*class1.setSubjects(subjects);
			class1.setTeacher(teachers);
			session.save(class1);
			
			class2.setSubjects(subjects);
			class2.setTeacher(teachers);
			session.save(class2);
			
			class3.setSubjects(subjects);
			class3.setTeacher(teachers);
			session.save(class3);
			
			class4.setSubjects(subjects);
			class4.setTeacher(teachers);
			session.save(class4);
			
			class5.setSubjects(subjects);
			class5.setTeacher(teachers);
			session.save(class5);
			
			class6.setSubjects(subjects);
			class6.setTeacher(teachers);
			session.save(class6);*/
			
			class7.setSubjects(subjects);
			class7.setTeacher(teachers);
			session.save(class7);
			

			
			/*Student student1=new Student(1,"Bharat Singh",class1);
			Student student2=new Student(2,"Divya Singh",class1);
			
			Student student3=new Student(3,"Bharati Dev",class2);
			Student student4=new Student(4,"Arun Singhania",class2);
			
			Student student5=new Student(5,"Aditi Sharma",class3);
			Student student6=new Student(6,"Akhila Patil",class3);
			
			Student student7=new Student(7,"Akshara purohit",class4);
			Student student8=new Student(8,"Bhagyashree malge",class4);
			
			Student student9=new Student(9,"Pavan mishra",class5);
			Student student10=new Student(10,"Rishab shetty",class5);
			
			Student student11=new Student(11,"Rohit Sharma",class6);
			Student student12=new Student(12,"Arpita khanna",class6);*/
			
			Student student13=new Student(13,"Shruti bhattacharya",class7);
			Student student14=new Student(14,"Sitara Narang",class7);
			
			
			/*session.save(student1);
			session.save(student2);
			session.save(student3);
			session.save(student4);
			session.save(student5);
			session.save(student6);
			session.save(student7);
			session.save(student8);
			session.save(student9);
			session.save(student10);
			session.save(student11);
			session.save(student12);*/
			session.save(student13);
			session.save(student14);
		
		
		
			
			transaction.commit();
			System.out.println("Done");
			session.close();
			
			
			}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
			
	}
		

}
