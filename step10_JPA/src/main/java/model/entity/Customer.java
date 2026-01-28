package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity		
@Table(name = "customer")
@Getter
@Setter
@ToString 
public class Customer {

    @Id		
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;
    
    @Column(name = "cust_name")
    private String custName;
    
    @Column(name = "cust_grade")
    private String custGrade;
    

    public Customer() {
		// TODO Auto-generated constructor stub
	}
    
    // 편의 생성자
    public Customer(String custName, String custGrade) {
        this.custName = custName;
        this.custGrade = custGrade;
    }
    
}