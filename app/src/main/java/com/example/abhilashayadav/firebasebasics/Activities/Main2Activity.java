package com.example.abhilashayadav.firebasebasics.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.abhilashayadav.firebasebasics.R;
import com.google.firebase.iid.FirebaseInstanceId;


public class Main2Activity extends AppCompatActivity {
 Button btnShowtoken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //btnShowtoken= (Button)findViewById(R.id.btn_show_token);
        btnShowtoken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get token
                String token= FirebaseInstanceId.getInstance().getToken();

                Log.d("MainActivity2",token);
                Toast.makeText(Main2Activity.this,token, Toast.LENGTH_SHORT).show();




            }
        });

    }

}
