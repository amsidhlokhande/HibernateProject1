package com.amsidh.mvc.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.amsidh.mvc.entities.Address;
import com.amsidh.mvc.entities.Person;

public class MainApp {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		
		//try to save some entities
		for(int i=0;i<10;i++){
			Person p=new Person(i,"PersonName"+i);
			p.getAddresses().add(new Address("City"+i,"State"+i,41047L+i));
			p.getAddresses().add(new Address("OfficeCity"+i,"OfficeState"+i,411047L+1));
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(p);
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
		
		
		//Now retrive all saved entities

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Person> persons=session.createQuery("from Person").list();
		for(Person p:persons){
			System.out.println(p.toString());
			for(Address address:p.getAddresses()){
				System.out.print("  "+address.toString());
			}
		}
		session.getTransaction().commit();
		session.close();
		System.out.println("End of Program");
		
		sessionFactory.close();

	}

}
