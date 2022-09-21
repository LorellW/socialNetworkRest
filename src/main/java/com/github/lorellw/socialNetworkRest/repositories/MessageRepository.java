package com.github.lorellw.socialNetworkRest.repositories;

import com.github.lorellw.socialNetworkRest.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
