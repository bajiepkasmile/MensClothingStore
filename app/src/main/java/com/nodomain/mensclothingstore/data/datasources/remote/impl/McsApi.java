package com.nodomain.mensclothingstore.data.datasources.remote.impl;


import com.nodomain.mensclothingstore.data.datasources.remote.impl.dtos.CategoryDto;
import com.nodomain.mensclothingstore.data.datasources.remote.impl.dtos.CommentDto;
import com.nodomain.mensclothingstore.data.datasources.remote.impl.dtos.ProductDto;
import com.nodomain.mensclothingstore.data.datasources.remote.impl.requestbodies.AddCommentRequestBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface McsApi {

    @GET("categories?format=json")
    Call<CategoryDto[]> getCategories();

    @GET("categories/{category_id}?format=json")
    Call<ProductDto[]> getProductsFromCategory(@Path("category_id") int categoryId);

    @GET("comments/{product_id}?format=json")
    Call<CommentDto[]> getCommentsForProduct(@Path("product_id") long productId);

    @Headers("Content-Type: application/json")
    @POST("comments/{product_id}/?format=json")
    Call<CommentDto> addCommentToProduct(@Path("product_id") long productId, @Body AddCommentRequestBody body);
}
