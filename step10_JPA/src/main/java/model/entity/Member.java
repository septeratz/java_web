package model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity		// Entity라는 명시, 생략 불가, DTO에 사용 금지
@Table(name = "member")
@Getter
@Setter
@ToString // 확인용으로 개발자가 직접 ai가 제시한 코드 대비 수정
public class Member {

    @Id		// pk, null 불허, 중복 불허
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment 자동증가 기술 적용
    private Long id; // ?

    // entity에선 컬럼명
    private String name;
}