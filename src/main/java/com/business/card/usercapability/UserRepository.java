package com.business.card.usercapability;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import com.business.card.usercapability.model.User;

public interface UserRepository extends MongoRepository<User,String> {
    
    @Query("{'social.email': ?0,'status': 'CREATED'}")
    public User findByEmail(String email);

    @Query("{'social.email': ?0,'password': ?1,'status': 'CREATED'}")
    public User validateUser(String email, String password);

    @Query("{'social.email': ?0,'status': 'CREATED'}")
    @Update("{'$set': {'password': ?1}}")
    public Integer updatePassword(String email, String password);

    @Query("{'id': ?0,'status': 'CREATED'}")
    @Update("{'$set': {'status': ?1}}")
    public Integer updateStatusAsDeleted(String id, String status);
}
