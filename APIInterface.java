package com.example.andre.dsa_minim_2;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET ("/books/{book}")
    Call<Book> getBooks();

}
