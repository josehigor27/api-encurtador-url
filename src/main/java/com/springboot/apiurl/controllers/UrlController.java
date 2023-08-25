package com.springboot.apiurl.controllers;

import com.springboot.apiurl.dto.UrlRecord;
import com.springboot.apiurl.model.UrlModel;
import com.springboot.apiurl.services.UrlService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UrlController {
    @Autowired
    private UrlService urlService;

    @PostMapping("/url")
    public ResponseEntity<String> saveUrl(@RequestBody @Valid UrlRecord urlRecord){
        var urlModel = new UrlModel();
        BeanUtils.copyProperties(urlRecord,urlModel);
        urlService.saveUrl(urlModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(urlModel.getHash());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getUrlByHash(@PathVariable(value = "id") String hash){
        Optional<UrlModel> url = urlService.getUrlByHash(hash);
        if(url.isEmpty()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Url not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(url.get().getOriginalUrl());
    }

}
