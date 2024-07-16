package com.movie.rock.movie.data.repository;

import com.movie.rock.movie.data.entity.MovieDirectorsEntity;
import com.movie.rock.movie.data.pk.MovieDirectorsPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MovieDirectorsRepository extends JpaRepository<MovieDirectorsEntity, Long> {
    // 단일 movieId로 검색하는 경우
//    List<MovieDirectorsEntity> findByMovieMovieId(Long movieId);

    // 여러 movieId로 검색하는 경우 (In 연산자 사용)
//    List<MovieDirectorsEntity> findByMovieMovieIdIn(Collection<Long> movieIds);;
}
