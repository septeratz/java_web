package step01.nonjoin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

//@Entity
public class Member1 {

	@Id
	@GeneratedValue
	@Column(name="member_id") 
	private long memberId; 
	
	@NonNull //name 변수에 null 불허, 실행시 NullPointerException
	@Column(length = 20, nullable = false) //컬럼 사이즈 
	private String name;
	
	@NonNull
	@Column(name="team_id")
	private long teamId; 	
}
