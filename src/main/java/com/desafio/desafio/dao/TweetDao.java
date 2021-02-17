package com.desafio.desafio.dao;

import com.desafio.desafio.entity.Tweet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TweetDao {

    @PersistenceContext
    private EntityManager em;

    public void insert(Tweet tweet) {
        em.persist(tweet);
    }

}
