package com.springboot.apiurl.services;

import com.springboot.apiurl.model.UrlModel;
import com.springboot.apiurl.repositories.UrlRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class UrlService{
    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private HashService hashService;

    @Transactional
    public UrlModel saveUrl(UrlModel urlModel){
        try{
            urlModel.setHash(hashService.getOneHash().getHash());
            return urlRepository.save(urlModel);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());

        }
        return null;
    }

    public ArrayList<UrlModel> getAllUrl(){
        try{
            return (ArrayList<UrlModel>) urlRepository.findAll();
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Optional<UrlModel> getUrlById(UUID uuid){
        try{
            return urlRepository.findById(uuid);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
