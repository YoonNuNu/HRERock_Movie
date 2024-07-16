package com.movie.rock.movie.data.response;

import com.movie.rock.movie.data.entity.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MovieInfoResponseDTO {

    @Getter
    @NoArgsConstructor
    public static class ActorResponseDTO {

        private Long actorId;
        private String actorName;
        private Integer actorBirth;
        private String actorPhoto;

        @Builder
        public ActorResponseDTO(Long actorId, String actorName, Integer actorBirth, String actorPhoto) {
            this.actorId = actorId;
            this.actorName = actorName;
            this.actorBirth = actorBirth;
            this.actorPhoto = actorPhoto;
        }

        public static ActorResponseDTO fromEntity(ActorsEntity actors) {
            return ActorResponseDTO.builder()
                    .actorId(actors.getActorId())
                    .actorName(actors.getActorName())
                    .actorBirth(actors.getActorBirth())
                    .actorPhoto(actors.getActorPhotos().toString())
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class DirectorResponseDTO {

        private Long directorId;
        private String directorName;
        private Integer directorBirth;
        private String directorPhoto;

        @Builder
        public DirectorResponseDTO(Long directorId, String directorName, Integer directorBirth, String directorPhoto) {
            this.directorId = directorId;
            this.directorName = directorName;
            this.directorBirth = directorBirth;
            this.directorPhoto = directorPhoto;
        }

        public static DirectorResponseDTO fromEntity(DirectorsEntity director) {
            return DirectorResponseDTO.builder()
                    .directorId(director.getDirectorId())
                    .directorName(director.getDirectorName())
                    .directorBirth(director.getDirectorBirth())
                    .directorPhoto(director.getDirectorPhotos().toString())
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class GenreResponseDTO {
        private Long genreId;
        private String genreName;

        @Builder
        public GenreResponseDTO(Long genreId, String genreName) {
            this.genreId = genreId;
            this.genreName = genreName;
        }

        public static GenreResponseDTO fromEntity(GenresEntity genres) {
            return GenreResponseDTO.builder()
                    .genreId(genres.getGenreId())
                    .genreName(genres.getGenreName())
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class PosterResponseDTO {
        private Long posterId;
        private MovieEntity movie;

        @Builder
        public PosterResponseDTO(Long posterId, MovieEntity movie) {
            this.posterId = posterId;
            this.movie = movie;
        }

        public static PosterResponseDTO fromEntity(MoviePostersEntity poster) {
            return PosterResponseDTO.builder()
                    .posterId(poster.getPosterId())
                    .movie(poster.getMovie())
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class TrailerResponseDTO {
        private Long trailerId;
        private MovieEntity movie;

        @Builder
        public TrailerResponseDTO(Long trailerId, MovieEntity movie) {
            this.trailerId = trailerId;
            this.movie = movie;
        }

        public static TrailerResponseDTO fromEntity(MovieTrailersEntity trailer) {
            return TrailerResponseDTO.builder()
                    .trailerId(trailer.getTrailerId())
                    .movie(trailer.getMovie())
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class FilmResponseDTO {
        private Long filmId;
        private String movieFilm;

        @Builder
        public FilmResponseDTO(Long filmId, String movieFilm) {
            this.filmId = filmId;
            this.movieFilm = movieFilm;
        }

        public static FilmResponseDTO fromEntity(MovieFilmEntity movieFilm) {
            return FilmResponseDTO.builder()
                    .filmId(movieFilm.getFilmId())
                    .movieFilm(movieFilm.getMovieFilm())
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class ActorsPhotosResponseDTO {
        private Long actorPhotoId;
        private PhotosEntity photos;
        private ActorsEntity actors;

        @Builder
        public ActorsPhotosResponseDTO(Long actorPhotoId, PhotosEntity photos, ActorsEntity actors) {
            this.actorPhotoId = actorPhotoId;
            this.photos = photos;
            this.actors = actors;
        }

        public static ActorsPhotosResponseDTO fromEntity(ActorsPhotosEntity actorsPhotos) {
            return ActorsPhotosResponseDTO.builder()
                    .actorPhotoId(actorsPhotos.getActorPhotoId())
                    .photos(actorsPhotos.getPhotos())
                    .actors(actorsPhotos.getActor())
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class DirectorsPhotosResponseDTO {
        private Long directorPhotoId;
        private PhotosEntity photos;
        private DirectorsEntity directors;

        @Builder
        public DirectorsPhotosResponseDTO(Long directorPhotoId, PhotosEntity photos, DirectorsEntity directors) {
            this.directorPhotoId = directorPhotoId;
            this.photos = photos;
            this.directors = directors;
        }

        public static DirectorsPhotosResponseDTO fromEntity(DirectorsPhotosEntity directorsPhotos) {
            return DirectorsPhotosResponseDTO.builder()
                    .directorPhotoId(directorsPhotos.getDirectorPhotoId())
                    .photos(directorsPhotos.getPhotos())
                    .directors(directorsPhotos.getDirector())
                    .build();
        }
    }
}
