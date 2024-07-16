package com.movie.rock.admin.member.data;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "password_reset_token")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PasswordResetTokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private LocalDateTime expiryDate;

    @OneToOne(targetEntity = MemberEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "mem_id", unique = true)
    private MemberEntity member;
}
