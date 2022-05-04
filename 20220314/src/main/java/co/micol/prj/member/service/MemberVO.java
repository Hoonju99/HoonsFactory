package co.micol.prj.member.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberVO {
private String memberId;
private String memberPassword;
private String memberName;
private String memberPhone;
private String memberGrade;
private int subscription;
private int memberNum;
private String memberEmail;
}
