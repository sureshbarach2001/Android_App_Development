//package com.example.pmd_se_a_java_2nd_file.RestAPI;
//
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.example.pmd_se_a_java_2nd_file.R;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//public class RestAPIMainActivity extends AppCompatActivity {
//
//    MyRetrofitInterface myRetrofitInterface;
//    RecyclerView recyclerView;
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rest_apimain);
//        recyclerView = findViewById(R.id.myretrofitrecyclerview);
//
//        myRetrofitInterface = MyRetrofit.getRetrofit().create(MyRetrofitInterface.class);
////        GetMyRetrofit();
////        GetMyComments();
////        GetMyCommentsBy();
//        CreatePost();
//    }
//
//    private void CreatePost() {
//        MyRestAPIModel model = new MyRestAPIModel(10, 2, "Title", "This is my post BODY");
//        myRetrofitInterface.createPost(model);
//        Call<MyRestAPIModel> myPost = myRetrofitInterface.createPost(model);
//        myPost.enqueue(new Callback<MyRestAPIModel>() {
//            @Override
//            public void onResponse(Call<MyRestAPIModel> call, Response<MyRestAPIModel> response) {
//                if ( response.isSuccessful() ){
//                    Log.d("TAG", "" + response.body().getUserId()
//                                    + " \n " + response.body().getTitle()
//                                    + " \n " + response.body().getBody()
//                    );
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MyRestAPIModel> call, Throwable t) {
//
//            }
//        });
//
//    }
//
//
//    private void GetMyCommentsBy(){
//        Map<String, String> arguments = new HashMap<>();
//        arguments.put("postId","3");
//        arguments.put("_sort","id");
//        arguments.put("_order","desc");
//
//        Call<List<MyCommentsModel>> list = myRetrofitInterface.getMyCommentsByArgument(arguments);
//
////        Call<List<MyCommentsModel>> list = myRetrofitInterface.getMyCommentsQuery(5, "id", "desc");
//        list.enqueue(new Callback<List<MyCommentsModel>>() {
//            @Override
//            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
//                if ( response.isSuccessful() ){
//                    for ( MyCommentsModel comments: response.body() ){
//                        Log.d("TAG"," ID " + comments.getId() + " PostID " + comments.getPostId() + " User " + comments.getName() + " Email " + comments.getEmail());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {
//
//            }
//        });
//
//    }
//
////
////    private void GetMyComments(){
////        Call<List<MyCommentsModel>> list = myRetrofitInterface.getMyCommentsQuery(4);
////        list.enqueue(new Callback<List<MyCommentsModel>>() {
////            @Override
////            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
////                if ( response.isSuccessful() ){
////                    for ( MyCommentsModel comments: response.body() ){
////                        Log.d("TAG"," ID " + comments.getId() + " PostID " + comments.getPostId() + " User " + comments.getName() + " Email " + comments.getEmail());
////                    }
////                }
////            }
////
////            @Override
////            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {
////
////            }
////        });
////    }
//
//    private void GetMyRetrofit() {
//        myRetrofitInterface.getList().enqueue(new Callback<List<MyRestAPIModel>>() {
//            @Override
//            public void onResponse(Call<List<MyRestAPIModel>> call, Response<List<MyRestAPIModel>> response) {
//                if ( response.body().size() > 0 ){
//
//                    List<MyRestAPIModel> list = response.body();
//                    MyRestAdapter adapter = new MyRestAdapter(list, RestAPIMainActivity.this);
//                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RestAPIMainActivity.this);
//                    recyclerView.setLayoutManager(linearLayoutManager);
//                    recyclerView.setAdapter(adapter);
//
//                    Toast.makeText(RestAPIMainActivity.this, "Data Retrieved", Toast.LENGTH_LONG).show();
//                }
//                else Toast.makeText(RestAPIMainActivity.this, "List is Empty", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onFailure(Call<List<MyRestAPIModel>> call, Throwable t) {
//                Toast.makeText(RestAPIMainActivity.this, "Failure", Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//
//
//}