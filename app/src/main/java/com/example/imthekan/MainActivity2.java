package com.example.imthekan;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    TextView first,last,age;
    FirebaseFirestore dbroot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        first=findViewById(R.id.textView);
        last=findViewById(R.id.textView2);
        age=findViewById(R.id.textView3);

        dbroot = FirebaseFirestore.getInstance();

        Random ra = new Random();
        int r = ra.nextInt(17);
        String abc = String.valueOf(r);
        DocumentReference document = dbroot.collection("user").document(abc);
        document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists())
                        {
                            first.setText(documentSnapshot.getString("que"));
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Row not found",Toast.LENGTH_LONG).show();
                    }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Failed to fetch data",Toast.LENGTH_LONG).show();
                    }
                })  ;
        int v = ra.nextInt(17);
        String xyz = String.valueOf(v);
        DocumentReference document1 = dbroot.collection("user").document(xyz);
        document1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists())
                        {
                            last.setText(documentSnapshot.getString("que"));
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Row not found",Toast.LENGTH_LONG).show();
                    }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Failed to fetch data",Toast.LENGTH_LONG).show();
                    }
                })  ;
        int s = ra.nextInt(17);
        String pqr = String.valueOf(s);
        DocumentReference document2 = dbroot.collection("user").document(pqr);
        document2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists())
                        {
                            age.setText(documentSnapshot.getString("que"));
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Row not found",Toast.LENGTH_LONG).show();
                    }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Failed to fetch data",Toast.LENGTH_LONG).show();
                    }
                })  ;
    }

}