package com.movie.rock.movie.data.repository;

import com.movie.rock.movie.data.entity.MovieEntity;
import com.movie.rock.movie.data.response.MovieInfoResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    Optional<MovieEntity> findByMovieId(Long movieId);

    @Query("SELECT m " +
            "FROM MovieEntity m " +
            "WHERE m.movieId = :movieId")
    Optional<MovieEntity> findMovieById(@Param("movieId") Long movieId);

//    @Query("SELECT m " +
//            "FROM MovieEntity m " +
//            "LEFT JOIN FETCH m.movieActors ma " +
//            "LEFT JOIN FETCH ma.actor a " +
//            "LEFT JOIN FETCH a.actorPhotos " +
//            "LEFT JOIN FETCH m.movieDirectors md " +
//            "LEFT JOIN FETCH md.director d " +
//            "LEFT JOIN FETCH d.directorPhotos " +
//            "LEFT JOIN FETCH m.genres g " +
//            "LEFT JOIN FETCH m.poster " +
//            "LEFT JOIN FETCH m.trailer " +
//            "LEFT JOIN FETCH m.movieFilm " +
//            "LEFT JOIN FETCH m.reviews r " +
//            "LEFT JOIN FETCH r.member " +
//            "WHERE m.movieId = :movieId")
//    Optional<MovieEntity> findMovieById(@Param("movieId") Long movieId);
}
