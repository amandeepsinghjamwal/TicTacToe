package internship.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    SharedPreferences sp;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Dashboard");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_home);
        sp=getSharedPreferences(ConstantSp.PREF,MODE_PRIVATE);
        title= findViewById(R.id.home_title);
        title.setText("Welcome \n"+sp.getString(ConstantSp.EMAIL,"this"));

    }
}