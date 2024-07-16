package com.movie.rock.movie.data.entity;

import com.movie.rock.common.MovieException;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "directors_photos")
public class DirectorsPhotosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "director_photo_id")
    private Long directorPhotoId;

    @ManyToOne
    @JoinColumn(name = "photo_id", referencedColumnName = "photo_id")//중복 매핑 방지
    private PhotosEntity photos;

    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "director_id") //중복 매핑 방지
    private DirectorsEntity director;

    @Builder
    public DirectorsPhotosEntity(PhotosEntity photos, DirectorsEntity director) {
        this.photos = photos;
        this.director = director;
        if(photos != null && photos.getPhotoType() != PhotoType.DIRECTOR) {
            throw new MovieException.InvalidDirectorPhotoTypeException();
        }
    }
}
