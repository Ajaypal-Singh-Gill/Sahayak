package com.gajab.sahayak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class DonorSignIn extends AppCompatActivity {

    EditText mobileno;
    Button OTP;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donor_sign_in);

        mobileno = findViewById(R.id.mobileno);
        OTP=findViewById(R.id.otpbtn);
        OTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobileNo=mobileno.getText().toString().trim();
                if(mobileNo.isEmpty())
                {
                    Toast.makeText(DonorSignIn.this,"Enter Mobile No",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    db.collection(mobileNo)
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()) {
                                        Log.d("SUCCESS", "USER FOUND");
//                                        WILL GO TO NEXT PAGE
//                                        Intent intent = new Intent(DonorSignIn.this, .class);
//                                        startActivity(intent);
                                    } else {
                                        Log.w("FAILURE", "REGISTER PLEASE");
                                        Toast.makeText(DonorSignIn.this,"Please Register",Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                    {

                    }


                }
            }
        });
    }
}