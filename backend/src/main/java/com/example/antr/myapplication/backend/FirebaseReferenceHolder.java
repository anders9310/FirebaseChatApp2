package com.example.antr.myapplication.backend;

import com.example.antr.myapplication.backend.data.ChatMessage;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Session;

public class FirebaseReferenceHolder {

    private static DatabaseReference databaseReference = setupFirebaseReference();

    private static DatabaseReference setupFirebaseReference(){
        File file = new File("./WEB-INF/cs550-finalproject-98c9d0cb7b4b.json");
        FirebaseOptions options = null;

        try {
            options = new FirebaseOptions.Builder().setServiceAccount(new FileInputStream(file)).setDatabaseUrl("https://fir-chatapp2-d2d07.firebaseio.com/").build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FirebaseApp.getInstance();
        }
        catch (Exception error){
            //Log.info("doesn't exist...");
        }

        try {
            FirebaseApp.initializeApp(options);
        }
        catch(Exception error){
            //Log.info("already exists...");
        }

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("messages");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object document = dataSnapshot.getValue();
                //Log.info("new value: "+ document);

                String todoText = "Don't forget to...\n\n";

                Iterator<DataSnapshot> children = dataSnapshot.getChildren().iterator();

                while(children.hasNext()){
                    DataSnapshot childSnapshot = (DataSnapshot) children.next();
                    todoText = todoText + " * " + childSnapshot.getValue().toString() + "\n";
                }
            }

            @Override
            public void onCancelled(DatabaseError error){
                System.out.println("Error: "+error);
            }
        });

        return ref;
    }

    public static void postMessage(ChatMessage chatMessage){
        databaseReference.push().setValue(chatMessage);
    }

    public static List<ChatMessage> getMessagesSince(long lastMessageTime) {
        List<ChatMessage> messages = new ArrayList<>();
        Query query = databaseReference;
        databaseReference.limitToFirst(1).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                ChatMessage chatMessage = dataSnapshot.getValue(ChatMessage.class);
                System.out.println(dataSnapshot.getKey() + " was sent at " + chatMessage.getMessageTime() + " milliseconds.");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return messages;
    }
}
