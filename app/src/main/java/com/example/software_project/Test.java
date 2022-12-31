package com.example.software_project;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        NewPhoneFragment newPhone = new NewPhoneFragment();
        FragmentManager fragmentManager= getSupportFragmentManager();



        Button btnNewBooks = findViewById(R.id.btnNew);
        btnNewBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, NewPhoneFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });

        Button btnUsedBooks=findViewById(R.id.btnUsed);

        btnUsedBooks.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, UsedPhoneFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //   getMenuInflater().inflate(R.menu.main, menu);
//        MenuInflater inflater= getMenuInflater();
//        inflater.inflate(R.menu.activity_main_drawer, menu);
        return true;
    }
    // @Override
    //   public boolean onOptionsItemSelected(@Nullable MenuItem item) {
    //switch (item.getItemId()) {
    //case R.id.action_settings:
    //  startActivity(new Intent(Test.this, Settings.class));
    // break;
    // case R.id.switchAccount:
    //   startActivity(new Intent(Test.this, Login.class));
    // break;
    //case R.id.logout:
    //  startActivity(new Intent(Test.this, Login.class));
    // break;
    //case R.id.cart:
    //  startActivity(new Intent(Test.this, Cart.class));
    //break;

    // case R.id.maps:
    //startActivity(new Intent(Test.this, Map.class));
    //break;

    //case R.id.about:
    //  startActivity(new Intent(Test.this, AboutUs.class));
    //default:
    //  break;
    //}
    //return super.onOptionsItemSelected(item);
    // }
}