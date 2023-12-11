package com.bhaskar.practiceSpring.repositories;

import com.bhaskar.practiceSpring.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {

    @Query(value = "{'username' : ?0}")
    User findByUsername(String username);

    @Query(value = "{'username' : ?0, 'password' : ?1}")
    User findbyUseernameAndPassword(String username, String password);

    @Query(value = "{'username' : ?0}", delete = true)
    User deleteByUsername(String username);
}
