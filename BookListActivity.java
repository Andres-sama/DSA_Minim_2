package com.example.andre.dsa_minim_2;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookListActivity extends AppCompatActivity {

    public void getBooks(View view){
        final EditText et = (EditText)findViewById(R.id.);
        API.getInstance().api.getBooks(et.getText().toString()).enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Trobat", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), Book.class);
                    Book b = (Book) response.body();
                    i.putExtra("avatarURL",b.getImage());
                    i.putExtra("title",b.getTitle());
                    i.putExtra("Author",b.getAuthor());
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "No trobat", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Problema connectant",Toast.LENGTH_SHORT).show();
            }
        });
}



