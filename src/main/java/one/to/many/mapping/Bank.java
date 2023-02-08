package one.to.many.mapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class Bank {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id ;
	
	@Column(name="b_name")
	private String bankName;
	
	@Column(name="branch")
	private String branch;
	
//	whenever we try to map one to many then it will create 3 tables
//	third table will contain primary keys of the both tables
//	to resolve this we used join column annotation
//	this will join the bank's primary key in employee table as foreign key
//	employees are more than one so in order to save them we used list
	@OneToMany
	@JoinColumn (name= "bank_id")
	private List<Employee> emp;
	
	public List<Employee> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", bankName=" + bankName + ", branch=" + branch + ", emp=" + emp + "]";
	}
}
