package com.movie.rock.admin.data.response;

import com.movie.rock.movie.data.entity.MovieEntity;
import com.movie.rock.movie.data.response.MovieInfoResponseDTO.ActorResponseDTO;
import com.movie.rock.movie.data.response.MovieInfoResponseDTO.DirectorResponseDTO;
import com.movie.rock.movie.data.response.MovieInfoResponseDTO.GenreResponseDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class AdminMovieFirstInfoResponseDTO {
    private Long movieId;
    private String movieTitle;
    private List<GenreResponseDTO> movieGenres;
    private int runTime;
    private Integer openYear;
    private String movieRating;
    private String movieDescription;
    private List<ActorResponseDTO> movieActors;
    private List<DirectorResponseDTO> movieDirectors;


    //생성자
    @Builder
    public AdminMovieFirstInfoResponseDTO(Long movieId, String movieTitle, List<GenreResponseDTO> movieGenres
                                          , int runTime, Integer openYear, String movieRating, String movieDescription
                                          , List<ActorResponseDTO>movieActors , List<DirectorResponseDTO> movieDirectors){
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieGenres =movieGenres;
        this.runTime = runTime;
        this.openYear = openYear;
        this.movieRating = movieRating;
        this.movieDescription = movieDescription;
        this.movieActors = movieActors;
        this.movieDirectors = movieDirectors;
    }

    //생성자에 넣을 데이터
    public static AdminMovieFirstInfoResponseDTO fromEntity(MovieEntity movieEntity){
        return AdminMovieFirstInfoResponseDTO.builder()
                .movieId(movieEntity.getMovieId())
                .movieTitle(movieEntity.getMovieTitle())
                .movieGenres(movieEntity.getGenres().stream()
                        .map(movieGenre -> GenreResponseDTO.builder()
                                .genreId(movieGenre.getGenre().getGenreId())
                                .genreName(movieGenre.getGenre().getGenreName())
                                .build())
                        .collect(Collectors.toList()))
                .runTime(movieEntity.getRunTime())
                .movieRating(movieEntity.getMovieRating())
                .movieDescription(movieEntity.getMovieDescription())
                .movieActors(movieEntity.getMovieActors().stream()
                        .map(movieActors -> ActorResponseDTO.builder()
                                .actorId(movieActors.getActor().getActorId())
                                .actorName(movieActors.getActor().getActorName())
                                .build())
                        .collect(Collectors.toList()))
                .movieDirectors(movieEntity.getMovieDirectors().stream()
                        .map(movieDirectors -> DirectorResponseDTO.builder()
                                .directorId(movieDirectors.getDirector().getDirectorId())
                                .directorName(movieDirectors.getDirector().getDirectorName())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

}
