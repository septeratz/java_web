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
public class Team1 {

	@Id  //pk
	@GeneratedValue  //sequence or auto_increment
	@Column(name = "team_id")  //team_id
	private long teamId;
	
	@NonNull   //?
	@Column(name="team_name", length = 20)
	private String teamName;
	
}
