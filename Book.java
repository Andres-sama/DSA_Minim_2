package com.example.andre.dsa_minim_2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable{

    private String id;
    private String image;
    private String author;
    private String title;


    public String getId() {
        return id;
    }

    public  String getImage() { return  image;}

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


    // Returns a Book given the expected JSON
    public static Book fromJson(JSONObject jsonObject) {
        Book book = new Book();
        try {
            // Deserialize json into object fields

            book.id = jsonObject.has("_id") ? jsonObject.getString("id") : "";
            book.title = jsonObject.has("title") ? jsonObject.getString("title") : "";
            book.author = jsonObject.has("author") ? jsonObject.getString("author") : "";
            book.image= jsonObject.has("image") ? jsonObject.getString("image") : "";
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return book;
}

    // Decodes array of book json results into business model objects
    public static ArrayList<Book> fromJson(JSONArray jsonArray) {
        ArrayList<Book> books = new ArrayList<Book>(jsonArray.length());
        // Process each result in json array, decode and convert to business
        // object
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject bookJson = null;
            try {
                bookJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            Book book = Book.fromJson(bookJson);
            if (book != null) {
                books.add(book);
            }
        }
        return books;
    }
}