/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.antr.myapplication.backend;

import com.example.antr.myapplication.backend.data.ChatMessage;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.inject.Named;
import javax.mail.Session;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.antr.example.com",
                ownerName = "backend.myapplication.antr.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public ChatMessage sayHi(ChatMessage message) {

        FirebaseReferenceHolder.postMessage(message);

        return message;
    }

    @ApiMethod(name = "getMessages")
    public List<ChatMessage> getMessages(@Named("lastMessageTime") long lastMessageTime) {

        List<ChatMessage> messages = FirebaseReferenceHolder.getMessagesSince(lastMessageTime);

        return messages;
    }

}
