//package com.example.pmd_se_a_java_2nd_file.RestAPI;
//
//import java.util.List;
//import java.util.Map;
//
//import retrofit2.Call;
//import retrofit2.http.Body;
//import retrofit2.http.GET;
//import retrofit2.http.POST;
//import retrofit2.http.Path;
//import retrofit2.http.Query;
//import retrofit2.http.QueryMap;
//
//public interface MyRetrofitInterface {
//    @GET("posts")
//    Call<List<MyRestAPIModel>> getList();
//    @GET("posts/1/comments")
//    Call<List<MyCommentsModel>> getComments();
//    @GET("posts/{id}/comments")
//    Call<List<MyCommentsModel>> getMyComments(@Path("id") int id);
//    @GET("comments")
//    Call<List<MyCommentsModel>> getMyCommentsQuery(@Query("postId") int id,
//                                                   @Query("_sort") String sort,
//                                                   @Query("_order") String orderby);
//    @GET("comments")
//    Call<List<MyCommentsModel>> getMyCommentsByArgument(@QueryMap Map<String, String> Argument);
//
//
//    @POST("posts")
//    Call<MyRestAPIModel> createPost(@Body MyRestAPIModel post);
//}
