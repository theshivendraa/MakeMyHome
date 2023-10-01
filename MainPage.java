package com.example.makemyhome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
 
import com.example.makemyhome.databinding.ActivityMainPageBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainPage extends AppCompatActivity {
    ActivityMainPageBinding binding;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        binding= ActivityMainPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth = com.google.firebase.auth.FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        binding.btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainPage.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        binding.btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= binding.etEmail.getText().toString();
                String password= binding.etPass.getText().toString();
                String name=binding.etName.getText().toString();
                String city=binding.etCity.getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            saveUser(email,password,name,city);
                            Toast.makeText(MainPage.this, "User is created", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(MainPage.this, "User is not created", Toast.LENGTH_SHORT).show();
                            Toast.makeText(MainPage.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }

    private void saveUser(String email, String password, String city, String name) {

        String uuid=firebaseAuth.getCurrentUser().getUid();
        UserData data= new UserData(city,name,email,uuid,password);
        firebaseDatabase.getReference( )
                .child("UserData")
                .child(uuid)
                .setValue(data)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainPage.this, "User Saved", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainPage.this, "User not Saved", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }


}
