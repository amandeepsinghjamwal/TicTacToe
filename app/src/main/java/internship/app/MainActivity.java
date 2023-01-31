package internship.app;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.*;

import org.jetbrains.annotations.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText email,password;
    SharedPreferences sp;
    TextView signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        sp=getSharedPreferences(ConstantSp.PREF,MODE_PRIVATE);
        login = findViewById(R.id.login_but);
        email = findViewById(R.id.email);
        password=findViewById(R.id.pswd);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String em="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
                Pattern pattern = Pattern.compile(em);
                Matcher ema=pattern.matcher(email.getText().toString());
                if(email.getText().toString().equals("")|| email.getText().toString().trim().equals("")){
                    email.setError("Email id required");
                }
                else if(!ema.matches()){
                    email.setError("Enter valid email");
                }
                else if(password.getText().toString().equals("") ){
                    password.setError("Password required");
                }
                else {
                    if(email.getText().toString().equals("admin007@gmail.com")&&password.getText().toString().equals("Qwerty@901")){

                    //for dev purpose
                    System.out.println("login successful");
                    Log.d("RESPONSE", "Successful");
                    Log.e("RESPONSE", "Successful");
                    //for user
                    new CommonMethod(MainActivity.this, "Login Successful");


                        sp.edit().putString(ConstantSp.EMAIL,email.getText().toString()).commit();
                        sp.edit().putString(ConstantSp.PASSWORD,password.getText().toString()).commit();
                        Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(intent);
                    }

                    else{
                        System.out.println("login successful");
                        Log.d("RESPONSE", "Successful");
                        Log.e("RESPONSE", "Successful");
                        //for user
//                Toast.makeText(MainActivity.this,"Login successful",Toast.LENGTH_SHORT).show();
                        new CommonMethod(MainActivity.this, "Wrong email or passsword");
//                        new CommonMethod(view, "Login unsuccessful");
                    }

                }

            }
        });
        signup=findViewById(R.id.sinup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(MainActivity.this,SignupActivity.class);
                startActivity(intent2);
            }
        });

    }
}