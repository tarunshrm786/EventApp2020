package com.example.partymakersapp2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.SharedMemory;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView image1,image2,image3;
    private ImageView imageView1,imageView2,imageView3;
    Button  btnNoInternetConnection;
    ProgressDialog progressDialog;
    ProgressBar progressBar;
    RelativeLayout relativeLayout;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
//    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//    private DatabaseReference databaseReference = firebaseDatabase.getReference();
//    private DatabaseReference childref = databaseReference.child("url");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Please Wait...");

//        btnNoInternetConnection = (Button)findViewById(R.id.btnN0Connection);
//
//        relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);

//        checkConnection();

        imageView1 = (ImageView) findViewById(R.id.imageview1);
        imageView2 = (ImageView) findViewById(R.id.imageview2);
        imageView3 = (ImageView) findViewById(R.id.imageview3);

        image1 = (TextView)findViewById(R.id.img1);
        image2 = (TextView)findViewById(R.id.img2);
        image3 = (TextView)findViewById(R.id.img3);

        progressBar.setVisibility(View.VISIBLE);
        setTitle("Loading...");
        progressDialog.show();

        DocumentReference user = db.collection("FILES").document("images");
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful())
                {
                    progressDialog.dismiss();

                    DocumentSnapshot doc = task.getResult();

                    StringBuilder img1 = new StringBuilder("");
                    img1.append(doc.get("image1"));
                    image1.setText(img1.toString());
                    String imageurl = image1.getText().toString();
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/partymakersapp2020.appspot.com/o/b1.jpg?alt=media&token=bb0342ae-babe-4df9-90b8-25e92516ba99").into(imageView1);


                    StringBuilder img2 = new StringBuilder("");
                    img1.append(doc.get("image2"));
                    image2.setText(img2.toString());
                    String image2url = image2.getText().toString();
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/partymakersapp2020.appspot.com/o/gh1.jpg?alt=media&token=a16d537d-f9ce-4716-a32d-b233d62c476c").into(imageView2);


                    StringBuilder img3 = new StringBuilder("");
                    img3.append(doc.get("image3"));
                    image2.setText(img3.toString());
                    String image3url = image3.getText().toString();
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/partymakersapp2020.appspot.com/o/w3.jpg?alt=media&token=eff9548d-6349-420b-b95e-012caba770f8").into(imageView3);

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.dashboard);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.dashboard:
                        return  true;

                    case R.id.portfolio:
                        startActivity(new Intent(getApplicationContext(),Gallery.class));

                        overridePendingTransition(0,0);
                        return true;

                    case R.id.aboutus:
                        startActivity(new Intent(getApplicationContext(),HomePage.class));

                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

//        btnNoInternetConnection.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                checkConnection();
//            }
//        });
    }

    public void Guesthouse(View view) {
        Intent intent = new Intent(MainActivity.this,GuestHouse.class);
        startActivity(intent);
    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//        childref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                String message = dataSnapshot.getValue(String.class);
//                text.setText(message);
//                Picasso.get().load(message).into(imageView);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }


//    public void checkConnection(){
//
//        ConnectivityManager connectivityManager = (ConnectivityManager)
//                this.getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//        NetworkInfo mobilenetwork = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//
//        if (wifi.isConnected())
//        {
//            relativeLayout.setVisibility(View.GONE);
//        }
//        else if (mobilenetwork.isConnected())
//        {
//            relativeLayout.setVisibility(View.GONE);
//        }
//        else {
//            relativeLayout.setVisibility(View.VISIBLE);
//        }
//    }

}