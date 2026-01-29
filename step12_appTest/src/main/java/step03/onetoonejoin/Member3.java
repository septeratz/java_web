package step03.onetoonejoin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

@SequenceGenerator(name = "member3_seq", sequenceName = "member3_seq_id", 
				   allocationSize = 50, initialValue = 1)
//@Entity
public class Member3 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member3_seq") 
	@Column(name="member_id")
	private long memberId;
	
	@NonNull
	@Column(length = 20, nullable = false) //컬럼 사이즈 20byte
	private String name;
	
	//alter table Member3 add constraint FKbnxffxdlb8ioisb6e1vekrc4n foreign key (team_id) references Team3
	@NonNull
	@OneToOne  //현재 엔티티와 Team3 엔티티가 1:1 관계
	@JoinColumn(name="team_id")  //team_id는 현재 엔티티가 관리하는 외래 키, Team3의 pk와 join 형성
	private Team3 teamId;
	
}