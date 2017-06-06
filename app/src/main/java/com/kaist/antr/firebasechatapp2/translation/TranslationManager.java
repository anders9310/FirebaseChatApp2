package com.kaist.antr.firebasechatapp2.translation;



import android.util.Log;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.translate.Translate;
import com.google.api.services.translate.TranslateRequestInitializer;
import com.google.api.services.translate.model.TranslationsListResponse;
import com.google.api.services.translate.model.TranslationsResource;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class TranslationManager {

    final static String KEY = "AIzaSyDN9jymPkVxyJNzAuNvtC6jvP0QnIvca2Y";


    public static String translate(String text){
        try{
            final TranslateRequestInitializer KEY_INITIALIZER = new TranslateRequestInitializer(KEY);

            HttpTransport httpTransport = new NetHttpTransport();
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

            final Translate translate = new Translate.Builder(httpTransport, jsonFactory, null)
                    .setApplicationName("My Project")
                    .setTranslateRequestInitializer(KEY_INITIALIZER)
                    .build();

            System.out.println(translate.languages().list().execute());

            final ImmutableList<String> phrasesToTranslate = ImmutableList.<String>builder().add(text).build();

            List<TranslationsResource> translationResponse = translate.translations().list(phrasesToTranslate, "en").execute().getTranslations();
            return translationResponse.get(0).getTranslatedText();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
