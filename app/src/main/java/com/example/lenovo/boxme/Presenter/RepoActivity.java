            package com.example.lenovo.boxme.Presenter;

            import android.app.ActivityOptions;
            import android.app.ProgressDialog;
            import android.content.Intent;
            import android.os.Bundle;
            import android.support.v4.view.ViewCompat;
            import android.support.v7.app.AppCompatActivity;
            import android.support.v7.widget.DefaultItemAnimator;
            import android.support.v7.widget.LinearLayoutManager;
            import android.support.v7.widget.RecyclerView;
            import android.support.v7.widget.Toolbar;
            import android.util.Log;
            import android.view.View;
            import android.widget.ProgressBar;

            import com.android.volley.RequestQueue;
            import com.android.volley.Response;
            import com.android.volley.VolleyError;
            import com.android.volley.VolleyLog;
            import com.android.volley.toolbox.JsonArrayRequest;
            import com.example.lenovo.boxme.Adapter.RepoAdapter;
            import com.example.lenovo.boxme.Utils.AppController;
            import com.example.lenovo.boxme.Model.RepoDesc;
            import com.example.lenovo.boxme.Model.RepoList;
            import com.example.lenovo.boxme.R;

            import org.json.JSONArray;
            import org.json.JSONException;
            import org.json.JSONObject;

            import java.io.Serializable;
            import java.util.ArrayList;
            import java.util.List;

            public class RepoActivity extends AppCompatActivity implements Serializable {

                private static final String TAG = MainActivity.class.getSimpleName();
                private ProgressDialog pDialog;
                private List<RepoList> repoList = new ArrayList<>();
               public static String id,fork,star,watch,imageUrl,data;
                String str;
                private static String url;
                private RepoAdapter adapter;
                RecyclerView recyclerView;

                RecyclerView.LayoutManager recyclerViewlayoutManager;

                RecyclerView.Adapter recyclerViewadapter;

                ProgressBar progressBar;

                String JSON_NAME = "name";
                String JSON_DESC="description";

                JsonArrayRequest jsonArrayRequest ;
                String desc;
                RequestQueue requestQueue ;

                @Override
                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_repo);

                    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                    setSupportActionBar(toolbar);

                    Bundle bundle = getIntent().getExtras();
                    String message = bundle.getString("message");
                    adapter = new RepoAdapter(repoList);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    final View androidRobotView = findViewById(R.id.circle_transit);

                    recyclerView.setAdapter(adapter);
                    recyclerView.addOnItemTouchListener(
                            new RecyclerTouchListener(this, recyclerView ,new RecyclerTouchListener.OnItemClickListener() {
                                @Override public void onItemClick(View view, int position) {

                                    View transitionView = view.findViewById(R.id.circle);
                                    ViewCompat.setTransitionName(transitionView,"MYTRANSITIONVIEW" );
                                    Intent i = new Intent(RepoActivity.this,RepoDetailsActivity.class);
                                    RepoList r = repoList.get(position);

                                    Log.d("id",id);
                                    data = "Repo Name:" + r.getRepoName() + "Repo Desc:" + r.getRepoDesc()
                                            + "iamgeUrl:" + imageUrl + "id:" + id + "star:" + star + "fork:" + fork + "watch:" + watch;
                                    RepoDesc rep = new RepoDesc(fork, id, imageUrl, r.getRepoDesc(),  r.getRepoName(), star, watch);
                                    i.putExtra("data",rep);
                                    Bundle bundle = null;

                                    ActivityOptions options = ActivityOptions
                                            .makeSceneTransitionAnimation(RepoActivity.this, transitionView, "MYTRANSITIONVIEW");
                                    // start the new activity
                                    startActivity(i, options.toBundle());


                                }

                                @Override public void onLongItemClick(View view, int position) {
                                    // do whatever
                                }
                            })
                    );
                    url = "https://api.github.com/users/" + message + "/repos";
                    parsingMethod();
                }

                private void parsingMethod() {

                    Log.d("hello1", url);
                    pDialog = new ProgressDialog(this);
                    // Showing progress dialog
                    pDialog.setMessage("Loading...");
                    pDialog.setCancelable(false);
                    pDialog.show();

                    // Creating volley request obj
                    JsonArrayRequest cityReq = new JsonArrayRequest(url,
                            new Response.Listener<JSONArray>() {

                                @Override
                                public void onResponse(JSONArray jsonArray) {
                                    hidePDialog();
                                    // Parsing json
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        RepoList repo= new RepoList();
                                        JSONObject obj = null;
                                        try {
                                            obj = jsonArray.getJSONObject(i);
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }


                                        try {

                                            repo.setRepoName(obj.getString("name"));
                                            Log.d("zxcv",obj.getString("name") );
                                            desc = obj.getString("description");
                                            if(desc.length()>100) {
                                                desc = desc.substring(0, 100);
                                                repo.setRepoDesc(desc+ "...");
                                            }
                                            else
                                            repo.setRepoDesc(desc);
                                            Log.d("zxcv",obj.getString("description") );

                                            fork=obj.getString("forks_count");
                                            watch=obj.getString("watchers_count");
                                            star=obj.getString("stargazers_count");

                                            JSONObject obj1 = obj.getJSONObject("owner");
                                            imageUrl = obj1.getString("avatar_url");
                                            id=obj1.getString("id");


                                            repoList.add(repo);
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }


                                    adapter.notifyDataSetChanged();

                                }

                            },new  Response.ErrorListener()

                    {
                        @Override
                        public void onErrorResponse (VolleyError error){
                            VolleyLog.d("hey", "Error: " + error.getMessage());
                            hidePDialog();

                        }

                    });


                    // Adding request to request queue
                    AppController.getInstance().addToRequestQueue(cityReq);
                }

                @Override
                public void onDestroy() {
                    super.onDestroy();
                    hidePDialog();
                }

                private void hidePDialog() {
                    if (pDialog != null) {
                        pDialog.dismiss();
                        pDialog = null;
                    }
                }
            }





