package com.example.lenovo.boxme.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.boxme.R;

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
