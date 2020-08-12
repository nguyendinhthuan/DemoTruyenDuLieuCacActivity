package com.example.demotruyendulieucacactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private Button button_KetThuc;
    private EditText editText_Ten, editText_DiaChi;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        AnhXa();
        XuLy();
    }

    public void AnhXa() {
        button_KetThuc = (Button) findViewById(R.id.button_KetThuc);
        editText_Ten = (EditText) findViewById(R.id.editText_Ten);
        editText_DiaChi = (EditText) findViewById(R.id.editText_DiaChi);
    }

    public void XuLy() {
        button_KetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = editText_Ten.getText().toString();
                String diachi = editText_DiaChi.getText().toString();

                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                intent.putExtra("ten", ten);
                intent.putExtra("diachi", diachi);
                startActivity(intent);
            }
        });
    }
}
