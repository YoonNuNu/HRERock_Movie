package com.movie.rock.admin.member.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// 김승준 - 회원
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private String memId;
    private String memPassword;
    private String memEmail;
    private String memTel;
    private String memGender;
    private LocalDate memBirth;
    private String memName;
    private RoleEnum memRole;

    public MemberEntity toEntity(String encodedPassword) {
        return MemberEntity.builder()
                .memId(memId)
                .memPassword(encodedPassword)
                .memEmail(memEmail)
                .memTel(memTel)
                .memGender(memGender)
                .memBirth(memBirth)
                .memName(memName)
                .memRole(RoleEnum.USER)
                .build();
    }

}
