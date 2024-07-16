package com.movie.rock.movie.controller;

import com.movie.rock.member.data.MemberEntity;
import com.movie.rock.member.data.MemberRepository;
import com.movie.rock.member.service.CustomUserDetails;
import com.movie.rock.movie.data.request.MovieReviewRequestDTO;
import com.movie.rock.movie.data.response.MovieReviewPageResponseDTO;
import com.movie.rock.movie.data.response.MovieReviewResponseDTO;
import com.movie.rock.movie.service.MovieReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies/{movieId}/reviews")
@RequiredArgsConstructor
public class MovieReviewController {

    private final MovieReviewServiceImpl movieReviewService;
    private final MemberRepository memberRepository;

    @GetMapping
    public ResponseEntity<MovieReviewPageResponseDTO> getMovieReviews(
            @PathVariable("movieId") Long movieId,
            @RequestParam(defaultValue = "1") int page,
            @AuthenticationPrincipal CustomUserDetails userDetails) {

        MemberEntity member = userDetails.memberEntity();

        MovieReviewPageResponseDTO reviewPage = movieReviewService.getMovieReviews(movieId, page, member);
        return ResponseEntity.ok(reviewPage);
    }

    @PostMapping
    public ResponseEntity<MovieReviewResponseDTO> createMovieReview(
            @PathVariable("movieId") Long movieId,
            @RequestBody MovieReviewRequestDTO requestDTO,
            @AuthenticationPrincipal CustomUserDetails userDetails) {

        MemberEntity member = userDetails.memberEntity();

        MovieReviewResponseDTO review = movieReviewService.createMovieReview(movieId, requestDTO, member);
        return ResponseEntity.status(HttpStatus.CREATED).body(review);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<MovieReviewResponseDTO> updateMovieReview(
            @PathVariable("movieId") Long movieId,
            @PathVariable("reviewId") Long reviewId,
            @RequestBody MovieReviewRequestDTO requestDTO,
            @AuthenticationPrincipal CustomUserDetails userDetails) {

        MemberEntity member = userDetails.memberEntity();

        MovieReviewResponseDTO review = movieReviewService.updateMovieReview(movieId, reviewId, requestDTO, member);
        return ResponseEntity.ok(review);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteMovieReview(
            @PathVariable("movieId") Long movieId,
            @PathVariable("reviewId") Long reviewId,
            @AuthenticationPrincipal CustomUserDetails userDetails) {

        MemberEntity member = userDetails.memberEntity();

        movieReviewService.deleteMovieReview(movieId, reviewId, member);
        return ResponseEntity.noContent().build();
    }
}

