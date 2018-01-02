package com.example.abhilashayadav.firebasebasics.Activities;

import android.content.Context;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.example.abhilashayadav.firebasebasics.Adapter.MessageAdapter;
import com.example.abhilashayadav.firebasebasics.Model.ChatMessage;
import com.example.abhilashayadav.firebasebasics.R;


import com.firebase.ui.database.FirebaseListAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;


import java.util.ArrayList;

import butterknife.BindView;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private DatabaseReference myRef;
    private EditText mEtMessage;
    private Button btnSubmit;
    protected ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<ChatMessage> chatMessagesArraylist = new ArrayList<ChatMessage>();
    private ListView listOfMessages;
    private MessageAdapter messageAdapter;
    private FirebaseDatabase database;
    private String token;
    private String android_id;
    Context context;
    private ChatMessage chatMsg;
    ArrayAdapter<String> adapt;
    private DatabaseReference mDatabase;
    private FirebaseListAdapter<ChatMessage> adapter;
/*
    @BindView(R.id.recyclerViewMsg)
    RecyclerView recyclerView;
    @BindView(R.id.fab)
    Button fab;
    @BindView(R.id.input)
    EditText input;*/

    EditText input;
    RecyclerView recyclerView;
    Button fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();

        mDatabase = database.getReference("users");

        recyclerView = findViewById(R.id.recyclerViewMsg);
        fab = findViewById(R.id.fab);
        input = findViewById(R.id.input)  ;

        android_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);

        token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "token is: " + token);

     if (!input.getText().toString().equals("")) {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mDatabase
                        .push()
                        .setValue(new ChatMessage(input.getText().toString(),
                                "abhilasha", "" + System.currentTimeMillis(), android_id)
                        );

                input.setText("");
            }
        });


          }


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ChatMessage user2 = dataSnapshot.getValue(ChatMessage.class);

                if (usernames != null) {
                    usernames.clear();
                }
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    String device = (String) child.child("deviceToken").getValue();
                    String username = (String) child.child("messageText").getValue().toString();
                    String name = (String) child.child("messageUser").getValue().toString();
                    String time =  ""+child.child("messageTime").getValue().toString();
                    chatMsg = new ChatMessage();
                    chatMsg.setMessageText(username);
                    chatMsg.setMessageUser(name);
                    chatMsg.setMessageTime(time);
                    chatMessagesArraylist.add(chatMsg);
                }


                // adapt = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, usernames);

                messageAdapter = new MessageAdapter(MainActivity.this,chatMessagesArraylist);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(messageAdapter);
                messageAdapter.notifyDataSetChanged();

                //listOfMessages.setAdapter(adapt);
                dataSnapshot.child("messageText");
                dataSnapshot.getChildrenCount();


            }


            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }


}



























































/*
                for (DataSnapshot child: dataSnapshot.getChildren()) {
                    String username = (String) child.child("username").getValue();
                    usernames.add(username);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        MainActivity.this,
                        android.R.layout.simple_list_item_multiple_choice,
                        usernames);

                listOfMessages.setAdapter(adapter);
*/


               /* Query query = mDatabase
                        .orderByValue();


                FirebaseListOptions<ChatMessage> options = new FirebaseListOptions.Builder<ChatMessage>()
                        .setLayout(R.layout.message)
                        .setQuery(query,ChatMessage.class)
                        .build();


                listOfMessages = findViewById(R.id.list_of_messages);

                adapter = new FirebaseListAdapter<ChatMessage>(options) {

                    @Override
                    protected void populateView(View view, ChatMessage model, int position) {
                        // Get references to the views of message.xml
                        TextView messageText = view.findViewById(R.id.message_text);
                        TextView messageUser = view.findViewById(R.id.message_user);
                        TextView messageTime = view.findViewById(R.id.message_time);

                        // Set their text
                        messageText.setText(model.getMessageText());
                        messageUser.setText(model.getMessageUser());
                        Log.d(TAG, "Value is: " + model.getMessageText());
                        Log.d(TAG, "Value is: " + model.getMessageUser());
                        // Format the date before showing it
                        messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                                model.getMessageTime()));
                    }
                };

                listOfMessages.setAdapter(adapter);*/
      /*  mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                try {

                    // String value =dataSnapshot.getValue(String.class);
                    User user = dataSnapshot.child("users").getValue(User.class);
                    // do your stuff here with value
                    Log.d(TAG, "Value is: " + user.email);
                    Log.d(TAG, "Value is: " + user.name);

                } catch (Throwable e) {
                    Log.w(TAG, "Failed to read value.", e);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }*/
      /*
     /*   btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.setValue(mEtMessage.getText().toString());

                User user = new User("ria", "kajal.yliadav71995@gmail.com");

                // pushing user to 'users' node using the userId
                mDatabase.child("users").setValue(user);
                //   mDatabase.child("school").setValue("hiiiiiiiiiiiii");
                input.setText("");
            }
        });*/