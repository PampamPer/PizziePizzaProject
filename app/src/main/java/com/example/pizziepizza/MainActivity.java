package com.example.pizziepizza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity<mAuth> extends AppCompatActivity {

    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mAuth = FirebaseAuth.getInstance();
        final EditText username = (EditText)findViewById(R.id.username) ;
        final EditText password = (EditText)findViewById(R.id.password) ;
        Button loginPizza = (Button)findViewById(R.id.login) ;
        TextView SignUp = (TextView)findViewById(R.id.SignUp);

        SignUp.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        loginPizza.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                login(username.getText().toString(), password.getText().toString());


            }
        });






    }

    private void login(String username,String password) {

        //final Intent intent = new Intent(MainActivity.this, Main3Activity.class);
        final Intent intent = new Intent(MainActivity.this, Mainmenu.class);


        final ProgressDialog dialog = ProgressDialog.show(MainActivity.this, "Logining",
                "Loading. Please wait...", true);

        //String x = username+" "+password;

        mAuth.signOut();

        //Toast.makeText(MainActivity.this,x,Toast.LENGTH_LONG).show();

        mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task){
                dialog.dismiss();

                if (task.isSuccessful()) {

                    //Toast.makeText(MainActivity.this,"Authentication success.",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
                else {

                    Toast.makeText(MainActivity.this,"User id or Password is incorrect.",Toast.LENGTH_SHORT).show();

                }
            }
        });




        /*mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
            if (task.isSuccessful()) {
                // Sign in success, update UI with the signed-in user's information
                // Log.d(TAG, "signInWithEmail:success");
                Toast.makeText(MainActivity.this,"Authentication success.",Toast.LENGTH_SHORT).show();
                //FirebaseUser user = mAuth.getCurrentUser();
                //updateUI(user);
            }
            else {
                // If sign in fails, display a message to the user.
                //Log.w(TAG, "signInWithEmail:failure", task.getException());
                Toast.makeText(MainActivity.this,"Authentication failed.",Toast.LENGTH_SHORT).show();
                //updateUI(null);
                // ...
            }
        });*/
        }

}
