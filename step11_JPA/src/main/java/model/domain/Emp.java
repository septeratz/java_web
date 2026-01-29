package model.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity		
@Table(name = "employeeee")
@Getter
@Setter
@ToString 
public class Emp {

    @Id
    @Column(name = "emp_no")
    private Long empNo;

    @Column(name = "ename", length = 20)
    private String ename;

    @Column(name = "job", length = 20)
    private String job;

    @Column(name = "mgr")
    private Integer mgr;
    
    @Column(name = "hiredate")
    private LocalDate hiredate;

    @Column(name = "sal")
    private Integer sal;

    @Column(name = "comm")
    private Integer comm;

    @Column(name = "deptno")
    private Integer deptno;
    
    

}
