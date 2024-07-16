package com.movie.rock.admin.data.request;


import com.movie.rock.movie.data.entity.MovieEntity;
import com.movie.rock.movie.data.entity.MoviePostersEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AdminPosterRequestDTO {

    private MovieEntity movie;  //영화ID
    private Long posterId;

    //생성자
    private AdminPosterRequestDTO(Long posterId, MovieEntity movie){
        this.posterId = posterId;
        this.movie = movie;
    }

    //생성자에 넣을 데이터
    @Builder
    public static MoviePostersEntity ofEntity(AdminPosterRequestDTO adminPosterRequestDTO){
        return MoviePostersEntity.builder()
                .posterId(adminPosterRequestDTO.getPosterId())
                .movie(adminPosterRequestDTO.getMovie())
                .build();
    }

}
