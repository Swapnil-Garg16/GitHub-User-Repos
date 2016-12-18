            package com.example.lenovo.boxme;

            import android.media.Image;
            import android.widget.ImageView;

            /**
             * Created by lenovo on 16-12-2016.
             */

            public class RepoList {

                private String repoName,repoDesc;


                public RepoList(String repoDesc, String repoName) {
                    this.repoDesc = repoDesc;
                    this.repoName = repoName;
                }

                public RepoList(){};

                public String getRepoDesc() {
                    return repoDesc;
                }

                public void setRepoDesc(String repoDesc) {
                    this.repoDesc = repoDesc;
                }

                public String getRepoName() {
                    return repoName;
                }

                public void setRepoName(String repoName) {
                    this.repoName = repoName;
                }
            }
