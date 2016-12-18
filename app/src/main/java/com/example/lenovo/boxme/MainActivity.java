package com.example.lenovo.boxme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String user;
    EditText userName;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName= (EditText)findViewById(R.id.userName);
        submit = (Button)findViewById(R.id.submit);



        submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        user=userName.getText().toString();
        Log.d("hello", userName.getText().toString());
            if(user.length()==0)
                Toast.makeText(MainActivity.this, "Enter username" , Toast.LENGTH_SHORT).show();
            else {
                Intent intent = new Intent(MainActivity.this, RepoActivity.class);
                intent.putExtra("message", user);
                startActivity(intent);
            }
    }
});
    }


}
