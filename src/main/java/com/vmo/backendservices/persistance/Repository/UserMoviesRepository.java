package com.vmo.backendservices.persistance.Repository;

import com.vmo.backendservices.persistance.Domain.UserMovieKey;
import com.vmo.backendservices.persistance.Domain.UserMovies;
import com.vmo.backendservices.persistance.Domain.UserRoleKey;
import com.vmo.backendservices.persistance.Domain.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMoviesRepository extends JpaRepository<UserMovies, UserMovieKey> {
}
