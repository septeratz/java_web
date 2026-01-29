package step02.onetoonejoin;

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

/* sequence값은 기본은 1씩 증가
 * 
 * allocationSize = 50 설정 - 초기에 50개 사전에 만들어 놓고 50개 사용 후에
 * 				    51번째 요청시 51~100까지 사전에 만들어서 사용
 * 					DB의 성능 향상을 위한 사전 생성 
 * 				 	메모리에 50개씩 사전에 저장해 놓고 사용하기 때문에 성능 고려한 설정
 */
//create sequence member_seq_id start with 1 increment by 50
@SequenceGenerator(name = "member_seq", sequenceName = "member_seq_id", 
				   allocationSize = 50, initialValue = 1)
//@Entity
public class Member2 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq") 
	@Column(name="member_id")
	private long memberId;
	
	@NonNull
	@Column(length = 20) //컬럼 사이즈 20byte
	private String name;
	
	@NonNull
	@Column(name="team_id")
	private long teamId; //64비트의 모든 숫자값 다 수용
	
}
