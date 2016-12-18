package com.example.lenovo.boxme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class RepoDetailsActivity extends AppCompatActivity {

    TextView repon , repod ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        repon = (TextView)findViewById(R.id.repo_name);
        repod=(TextView)findViewById(R.id.repo_desc);

        Bundle bundle = getIntent().getExtras();
        String reponame = bundle.getString("reponame");
        String repoDesc = bundle.getString("repodesc");

        repon.setText(reponame);
        repod.setText(repoDesc);
    }

}
