            package com.example.lenovo.boxme.Adapter;

            import android.support.v7.widget.RecyclerView;
            import android.view.LayoutInflater;
            import android.view.View;
            import android.view.ViewGroup;
            import android.widget.TextView;

            import com.example.lenovo.boxme.R;
            import com.example.lenovo.boxme.Model.RepoList;

            import java.util.List;

            /**
             * Created by lenovo on 16-12-2016.
             */

            public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.MyViewHolder> {

                private List<RepoList> repoLists;


                @Override
                public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                    View itemView = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.repo_list_row, parent, false);

                    return new MyViewHolder(itemView);
                }

                @Override
                public void onBindViewHolder(MyViewHolder holder, int position) {
                    RepoList repoList = repoLists.get(position);
                    holder.repoName.setText(repoList.getRepoName());
                    holder.repoDesc.setText(repoList.getRepoDesc());
                }

                @Override
                public int getItemCount() {
                    return repoLists.size();
                }

                public class MyViewHolder extends RecyclerView.ViewHolder {
                    public TextView repoName, repoDesc;

                    public MyViewHolder(View view) {
                        super(view);
                        repoName = (TextView) view.findViewById(R.id.repoName);
                        repoDesc = (TextView) view.findViewById(R.id.repoDesc);
                    }
                }

                public RepoAdapter( List<RepoList> repoList) {
                    this.repoLists = repoList;
                }

            }
