package com.springboot.apiurl.services;

import com.springboot.apiurl.model.UrlModel;
import com.springboot.apiurl.repositories.UrlRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static com.springboot.apiurl.services.HashGenerator.generateUniqueString;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;


    @Transactional
    public String saveUrl(UrlModel urlModel) {
        try {
            String hashValid;
            boolean isExist;
            do {
                hashValid = generateUniqueString();
                isExist = urlRepository.findByHashContaining(hashValid).isEmpty();
            }while(isExist == false);
            urlModel.setHash(hashValid);
            urlModel.setDataTime(LocalDate.now());
            return urlRepository.save(urlModel).getHash();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());

        }
        return null;
    }

    public Optional<UrlModel> getUrlByHash(String hash) {
        try {
            return urlRepository.findByHashContaining(hash);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
