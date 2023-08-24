package com.springboot.apiurl.services;

import com.springboot.apiurl.model.HashModel;
import com.springboot.apiurl.model.UrlModel;
import com.springboot.apiurl.repositories.HashRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.springboot.apiurl.services.HashGenerator.generateSetString;

@Service
public class HashService {
    @Autowired
    private HashRepository hashRepository;

    @Transactional
    public void saveHash() {
        var hashModel = new HashModel();
        Set<String> hashList = new HashSet<>();
        hashList = generateSetString();

        for (String hash : hashList) {
            hashModel.setHash(hash);
            hashModel.setAvailable(true);
            hashRepository.save(hashModel);
        }
    }

    public HashModel getOneHash() {
        List<HashModel> hashModelList = new ArrayList<>();
        hashModelList = hashRepository.findAllByAvailable(true);

        if (!hashModelList.isEmpty()) {
            hashModelList.get(0).setAvailable(false);
            hashRepository.save(hashModelList.get(0));
            return hashModelList.get(0);
        } else {
            saveHash();
            getOneHash();
        }

        return null;
    }


    //Método para teste
    public ArrayList<HashModel> getAllHash() {
        try {
            return (ArrayList<HashModel>) hashRepository.findAll();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
