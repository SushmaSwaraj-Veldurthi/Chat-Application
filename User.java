package com.chatapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(length = 15)
    private String phoneNumber;

    private String profilePicture;

    @Column(length = 500)
    private String bio;

    @Builder.Default
    private boolean online = false;

    @Builder.Default
    private boolean enabled = true;

    @Builder.Default
    private boolean accountNonLocked = true;

    private LocalDateTime lastSeen;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "role")
    @Builder.Default
    private Set<String> roles = new HashSet<>();

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        if (lastSeen == null) {
            lastSeen = LocalDateTime.now();
        }

        if (roles.isEmpty()) {
            roles.add("ROLE_USER");
        }
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}