package com.springboot.apiurl.services;

import com.springboot.apiurl.model.HashModel;
import com.springboot.apiurl.repositories.HashRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.springboot.apiurl.services.HashGenerator.generateSetString;
import static com.springboot.apiurl.services.HashGenerator.generateUniqueString;

@Deprecated
@Service
public class HashService {
    @Autowired
    private HashRepository hashRepository;


    public HashModel saveHash() {
        try{
            var hashModel = new HashModel();
            //Set<String> hashList = new HashSet<>();
            //hashList = generateSetString();
            String aux = generateUniqueString();

            hashModel.setHash(aux);
            hashModel.setAvailable(true);
            System.out.println(hashModel.toString());


            return hashRepository.save(hashModel);
        }catch (IllegalArgumentException ex){
            System.out.println(ex);
        }
        return null;
    }

    public String getOneHash() {


//        List<HashModel> hashModelList = new ArrayList<HashModel>();
//        hashModelList = hashRepository.findAll();
//        hashModelList.removeIf(n->n.isAvailable()==false);
//
//        if (!hashModelList.isEmpty()) {
//
//            hashModelList.get(0).setAvailable(false);
//            hashRepository.save(hashModelList.get(0));
//            return hashModelList.get(0);
//        } else {
//            saveHash();
//            getOneHash();
//        }


        String hash = generateUniqueString();

        return hash;
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
