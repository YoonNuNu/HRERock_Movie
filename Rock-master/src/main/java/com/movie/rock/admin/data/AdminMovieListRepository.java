package com.movie.rock.admin.data;


import org.springframework.stereotype.Repository;

@Repository
public interface AdminMovieListRepository {
    //
//    @Query(value = "SELECT m FROM MovieActorsEntity m  WHERE m.movie = :movieId AND m.actor = :actorId")
//    Optional<ActorsEntity> findByMovieIdAndActorId(Long actorId, Long movieId);
}
