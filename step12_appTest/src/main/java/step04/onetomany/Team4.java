package step04.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

@Getter
@Setter
@ToString

@SequenceGenerator(name = "team3_seq", sequenceName = "team3_seq_id",
				   initialValue = 1, allocationSize = 50)
@Entity
public class Team4{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team3_seq")
	@Column(name = "team_id")  //team_id number(19,0) not null, 
	private long teamId;
	
	@NonNull
	@Column(name="team_name", length = 20) //team_name varchar2(20), 
	private String teamName;
	
	/*
	 * mappedBy에는 컬럼명이 아니라 연관관계의 필드명
	 */
	@OneToMany(mappedBy = "team")
	private List<Member4> members = new ArrayList<>();	
}
/*
create table Team4 (
	team_id number(19,0) not null, 
	team_name varchar2(20), 
	primary key (team_id)
);

 */

