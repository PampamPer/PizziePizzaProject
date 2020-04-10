package com.example.pizziepizza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity<mAuth> extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    final EditText newuser = (EditText)findViewById(R.id.newuser);
    final EditText newpass = (EditText)findViewById(R.id.newpass);
    final EditText cardno = (EditText)findViewById(R.id.cardno);
    final EditText csv = (EditText)findViewById(R.id.csv);
    Button signup = (Button)findViewById(R.id.signup2);

        //Toast.makeText(getApplicationContext(),"j0002k", Toast.LENGTH_LONG).show();

    mAuth = FirebaseAuth.getInstance();

    signup.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                //currentUser userID = mAuth.uid();
                /*String userId = mAuth.getCurrentUser().getUid()//currentUser!!.uid
                DatabaseReference currentUserDb = mDatabaseReference.child(userId);*/
               // Log.d("test1", "c111ess");

                String username = newuser.getText().toString()+"@a.com";
                String password = newpass.getText().toString();
                if(newpass.length()<6) {
                    Toast.makeText(Main2Activity.this,"Your password is too short. Your password must have more than 5 characters.",Toast.LENGTH_LONG).show();
                    return;}

                try {
                mAuth.createUserWithEmailAndPassword(username, password)
                        .addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {



                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    //FirebaseUser user = mAuth.getCurrentUser();



                                        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
                                        DatabaseReference mUsersRef = mRootRef.child("users");

                                        String userId = mAuth.getCurrentUser().getUid();

                                        DatabaseReference mInformationRef = mUsersRef.child(userId); //newuser.getText().toString()


                                        mInformationRef.child("Card_No").setValue(cardno.getText().toString());
                                        mInformationRef.child("CSV").setValue(csv.getText().toString());

                                    Toast.makeText(Main2Activity.this, "Sign up success",
                                            Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("test1", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(Main2Activity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });
            }
            catch (Exception e){
            Toast.makeText(getApplicationContext(),"error: "+e, Toast.LENGTH_LONG).show();
        }

            /*if(newpass.length()<6) {
                Toast.makeText(Main2Activity.this,"Your password is too short. Please enter a password which is greater than or equal to 6 characters",Toast.LENGTH_LONG).show();
                return;}

                try {
                    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
                    DatabaseReference mUsersRef = mRootRef.child("users");

                    String userId = mAuth.getCurrentUser().getUid()

                    DatabaseReference mInformationRef = mUsersRef.child(userId); //newuser.getText().toString()

                    mInformationRef.child("password").setValue(newpass.getText().toString());
                    mInformationRef.child("Card_No").setValue(cardno.getText().toString());
                    mInformationRef.child("CSV").setValue(csv.getText().toString());
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"error: "+e, Toast.LENGTH_LONG).show();
                }*/
            }
        });










    }
}
