package com.movie.rock.admin.data;


import com.movie.rock.movie.data.entity.MovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMovieListRepository extends JpaRepository<MovieEntity,Long> {

    //관리자 영화 리스트 제목 검색
    @Query(value = "SELECT DISTINCT m FROM MovieEntity m WHERE m.movieTitle LIKE %:title%",
            countQuery = "SELECT COUNT(DISTINCT m) FROM MovieEntity m WHERE m.movieTitle LIKE %:title%")
    Page<MovieEntity> findAllMovieTitle(@Param("title") String title, Pageable pageable);

    //관리자 영화 감독 이름 검색
    @Query(value = "SELECT DISTINCT md FROM MovieDirectorsEntity md JOIN md.movie m JOIN md.director d WHERE d.directorName LIKE %:directorName%",
            countQuery = "SELECT COUNT(DISTINCT md) FROM MovieDirectorsEntity md JOIN md.director d WHERE d.directorName LIKE %:directorName%")
    Page<MovieEntity> findAllByDirectorName(@Param("directorName") String directorName, Pageable pageable);


    //관리자 영화 장르 검색
    @Query(value = "SELECT DISTINCT m FROM MovieEntity m JOIN m.genres mg JOIN mg.genre g WHERE g.genreName LIKE %:genreName%",
            countQuery = "SELECT COUNT(DISTINCT m) FROM MovieEntity m JOIN m.genres mg JOIN mg.genre g WHERE g.genreName LIKE %:genreName%")
    Page<MovieEntity> findAllGenres(@Param("genreName") String genreName, Pageable pageable);

    //
//    @Query("SELECT p.posterUrls FROM PostersEntity p WHERE p.movieId = :movieId")
//    List<String> findPosterUrlsByMovieId(@Param("movieId") Long movieId);
}
