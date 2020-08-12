package com.example.demotruyendulieucacactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button_NhapThongTin, button_ChonSoThich, button_Xong;
    //private ListView listView;
    private TextView ten, diachi;
    private CheckBox checkBox_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String ten = intent.getStringExtra("ten");

        AnhXa();
        XuLy();
        Show();
    }

    public void AnhXa() {
        button_NhapThongTin = (Button) findViewById(R.id.button_NhapThongTin);
        button_ChonSoThich = (Button) findViewById(R.id.button_ChonSoThich);
        //listView = (ListView) findViewById(R.id.listView);
        ten = (TextView) findViewById(R.id.textView_ten);
        diachi = (TextView) findViewById(R.id.textView_diachi);


    }

    public void XuLy() {
        button_NhapThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        button_ChonSoThich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
                dialog.setContentView(R.layout.dialog_sothich);
                dialog.getWindow().setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
                dialog.show();

                button_Xong = (Button) dialog.findViewById(R.id.button_Xong);
                checkBox_1 = (CheckBox) dialog.findViewById(R.id.checkBox_1);

                button_Xong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (checkBox_1.isChecked()) {
                            String sothich;
                            sothich = checkBox_1.getText().toString();
                            ten.setText(sothich);
//                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                    intent.putExtra("sothich", sothich);
//                    startActivity(intent);
                        }
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    public void Show() {
        Intent intent = getIntent();
        String tenchuoi = intent.getStringExtra("ten");
        String diachichuoi = intent.getStringExtra("diachi");
        ten.setText(tenchuoi);
        diachi.setText(diachichuoi);
    }

}
