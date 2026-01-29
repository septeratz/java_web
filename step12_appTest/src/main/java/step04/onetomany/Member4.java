package step04.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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

@SequenceGenerator(name = "member4_seq", sequenceName = "member4_seq_id", 
				   allocationSize = 50, initialValue = 1)

@Entity
public class Member4 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member4_seq") 
	@Column(name="member_id")  //member_id number(19,0) not null,
	private long memberId;
	
	@NonNull
	@Column(length = 20, nullable = false)
	private String name; //name varchar2(20) not null, 
	
	//Team4 vs Member4 = 1:N
	@NonNull
	@ManyToOne// Member 하나는 Team 하나에 소속, 멤버 다수는 하나의 팀에 소속
//	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="team_id")   //team_id number(19,0), Team4 table의 pk를 참조하는 설정
	private Team4 team;
}
/*
create table Member4 (
	member_id number(19,0) not null, 
	name varchar2(20) not null, 
	team_id number(19,0), 
	primary key (member_id)
);

create table Team4 (
	team_id number(19,0) not null, 
	team_name varchar2(20), 
	primary key (team_id)
);

 */







