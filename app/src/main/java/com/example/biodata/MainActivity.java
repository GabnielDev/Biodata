package com.example.biodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnTelp, btnEmail, btnAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initiation();
        klik();
    }

    private void klik() {
        //telp
        btnTelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:08814508817");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //email
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"daniluzairi69@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Membuat Biodata Android Studio");

                try {
                    startActivity(Intent.createChooser(intent, "Ingin Mengirim Email?"));
                } catch (android.content.ActivityNotFoundException ex) {

                }
            }
        });

        //Alamat
        btnAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:-6,8706474,107,5916906");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    private void initiation() {
        btnTelp = findViewById(R.id.btnTelp);
        btnEmail = findViewById(R.id.btnEmail);
        btnAlamat = findViewById(R.id.btnAlamat);
    }
}
