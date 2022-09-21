package com.github.lorellw.socialNetworkRest.repositories;

import com.github.lorellw.socialNetworkRest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, String> {
}
