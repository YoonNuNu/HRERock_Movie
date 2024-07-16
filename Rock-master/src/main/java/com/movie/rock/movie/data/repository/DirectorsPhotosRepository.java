package com.movie.rock.movie.data.repository;

import com.movie.rock.movie.data.entity.DirectorsPhotosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorsPhotosRepository extends JpaRepository<DirectorsPhotosEntity, Long> {
//    List<DirectorsPhotosEntity> findByDirectorIdIn(List<Long> directorIds);
}
