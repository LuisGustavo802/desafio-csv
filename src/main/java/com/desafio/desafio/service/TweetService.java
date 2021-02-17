package com.desafio.desafio.service;

import com.desafio.desafio.dao.TweetDao;
import com.desafio.desafio.entity.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TweetService {

    @Autowired
    private TweetDao tweetDao;

    public ResponseEntity getTweetByFilter() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity insertTweets(MultipartFile file) {
        String line;
        BufferedReader br;
        Integer count = 0;
        Tweet tweet = null;
        List lista = null;

        try {
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                if (!(count == 0)) {
                    lista = Arrays.asList(line.split(",", 5));
                    tweet = new Tweet();

                    tweet.setDate  ( new Date(lista.get(1).toString()) );
                    tweet.setTarget( lista.get(2).toString() );
                    tweet.setInsult( lista.get(3).toString() );
                    tweet.setTweet ( lista.get(4).toString() );

                    tweetDao.insert(tweet);
                }
                count++;
            }
        } catch (IOException e) {
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
