package com.movie.rock.admin.member.data;

import lombok.Data;

@Data
public class FindPasswordRequestDTO {
    private String memId;

    private String memEmail;
}
