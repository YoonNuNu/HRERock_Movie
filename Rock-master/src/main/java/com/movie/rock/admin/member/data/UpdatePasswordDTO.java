package com.movie.rock.admin.member.data;

import lombok.Data;

@Data
public class UpdatePasswordDTO {
    private String memNewPassword;
    private String memNewPasswordCheck;
}
