package com.example.minor.repository;

import com.example.minor.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

    @Query(value = "select * from author where email=:email", nativeQuery = true)
    Author getAuthorWithEmailAddress(String email);

    @Query("select a from Author a where a.email=:email")
    Author getAuthorWithEmailAddressWithoutNative(String email);

    Author findByEmail(String email);

}
