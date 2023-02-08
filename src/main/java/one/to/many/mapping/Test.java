package one.to.many.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Bank bank = new Bank();
		bank.setBankName("HDFC");
		bank.setBranch("Mumbai");
		
		Employee emp1 = new Employee();
		emp1.setEmpName("Ajinkya");
		emp1.setDesignation("Senior Developer");
		
		Employee emp2 = new Employee();
		emp2.setEmpName("Akanksha");
		emp2.setDesignation("CEO");
		
//		first we added 2 employees in the list
		List<Employee> list = new ArrayList<Employee>();
		list.add(emp1);
		list.add(emp2);
		
//		we are saving the list into the setter method of the employees reference variable
		bank.setEmp(list);
		
//		here we first have to save employee because we are trying to use its primary key in bank table
		session.save(emp1);
		session.save(emp2);
		session.save(bank);
		transaction.commit();
		session.close();
//		but instead of joining the column of employees in the table of bank
//		it will join the column of bank id into table of employee as a foreign key
//		this gives us exact same result of many to one mapping but we are writing one to many mapping
	}

}