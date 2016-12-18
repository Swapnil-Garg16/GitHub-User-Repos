package com.example.lenovo.boxme.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.boxme.Model.RepoDesc;
import com.example.lenovo.boxme.R;

public class RepoDetailsActivity extends AppCompatActivity {

    TextView repon, repod, id, watch, star, fork;
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        repon = (TextView) findViewById(R.id.repo_name);
        repod = (TextView) findViewById(R.id.repo_desc);
        id = (TextView) findViewById(R.id.owner_id);
        watch = (TextView) findViewById(R.id.watchers);
        star = (TextView) findViewById(R.id.starred);
        fork = (TextView) findViewById(R.id.fork);
        pic = (ImageView) findViewById(R.id.profile_image);

        Bundle bundle = getIntent().getExtras();
        Intent i = getIntent();
        RepoDesc d = (RepoDesc) i.getSerializableExtra("data");

        repon.setText(d.getRepoName());
        repod.setText(d.getRepoDesc());
        id.setText(d.getId());
        watch.setText(d.getWatch());
        star.setText(d.getStar());
        fork.setText(d.getFork());


       /* try {

            Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(d.getImageUrl()).getContent());
            pic.setImageBitmap(bitmap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
