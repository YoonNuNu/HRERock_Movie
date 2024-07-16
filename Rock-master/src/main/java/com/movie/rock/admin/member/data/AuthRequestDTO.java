package com.movie.rock.admin.member.data;

import lombok.Data;

// 김승준 - 회원
@Data
public class AuthRequestDTO {
    private String memId;
    private String memPassword;
}
