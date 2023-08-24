package com.springboot.apiurl.services;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HashGenerator {
    private static final String CHARACTERES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@";
    private static final int STRING_LENGTH = 7;
    private static final String URL = "bit.ly/";
    private static final int QTD_HASH = 20;

    public static String generateUniqueString(){
        var random = new Random();
        var sb = new StringBuilder();
        for(int i=0; i<STRING_LENGTH; i++){
            int randomIndex = random.nextInt(CHARACTERES.length());
            char randomChar = CHARACTERES.charAt(randomIndex);
            sb.append(randomChar);
        }
        return URL+sb.toString();
    }

    public static Set<String> generateSetString(){
        Set<String> hashList = new HashSet<>();

        while(hashList.size()!=QTD_HASH){
            hashList.add(generateUniqueString());
        }

        return hashList;
    }

}
