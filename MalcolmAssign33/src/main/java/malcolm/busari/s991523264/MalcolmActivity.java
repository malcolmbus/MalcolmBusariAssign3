package malcolm.busari.s991523264;
/**
 * Name: Malcolm Busari
 * Student ID: 991523264
 * Section No: 1211_34780
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MalcolmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.malcolmNavView);
    }
}