package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.testproject.databinding.ActivityMainBinding;
import com.example.testproject.databinding.ActivitySecondBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class secondActivity extends AppCompatActivity {
    private ActivitySecondBinding secondBinding;
    private Database mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        secondBinding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(secondBinding.getRoot());

        mDatabase = Database.getInstance();
        secondBinding.submit.setOnClickListener(v -> {

            HashMap<String, String> map = new HashMap<>();
            String name=secondBinding.emails.getText().toString();
            String pass=secondBinding.password.getText().toString();
            map.put("email",name);
            map.put("password",pass);

            mDatabase.uploadData("https://wasisoft.com/hms/api/login", map, new jsonCallBack() {
                @Override
                public void onSuccessCallback(JSONArray response) {

                }

                @Override
                public void onSuccessCallback(JSONObject response) {
                    Toast.makeText(secondActivity.this, "data"+response, Toast.LENGTH_SHORT).show();
                    secondBinding.value.setText("" +response);
                }

                @Override
                public void onFailedCallback(String error) {
                    Toast.makeText(secondActivity.this, "failed "+error, Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

}