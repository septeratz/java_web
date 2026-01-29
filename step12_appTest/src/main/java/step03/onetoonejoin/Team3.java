package step03.onetoonejoin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

/* db들이 자동 숫자값 특정 컬럼에 생성 및 부여 
 * - oracle sequence
 * - mysql auto increment
 * 
 * db관점에서 performance를 고려한 작업
 * - 한번에 왕창 생성 후 부족시 또 왕창 생성해 놓는 작업
 * - allocationSize 속성 
 * - allocationSize = 50 : 한번에 50개씩 생성 해서 사용 하고 
 * 	 추가 필요시 또 50개씩 한번에 생성해서 부여
 * 
 * create table table명();
 * create sequence sequence명;
 * create sequence team3_seq_id;
 * 
 */
@SequenceGenerator(name = "team3_seq", sequenceName = "team3_seq_id",
				   initialValue = 1, allocationSize = 50)
//@Entity
public class Team3{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,  
					generator = "team3_seq")
	@Column(name = "team_id")
	private long teamId;
	
	@NonNull
	@Column(name="team_name", length = 20)
	private String teamName;
	
}
