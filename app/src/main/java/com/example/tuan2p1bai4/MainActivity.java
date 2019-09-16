package com.example.tuan2p1bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {
EditText ht,cmnd,ttbs;
RadioGroup group;
CheckBox db,ds,dc;
Button gui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ht=findViewById(R.id.editText_ht);
        cmnd=findViewById(R.id.editText_cmnd);
        ttbs=findViewById(R.id.editText_ttbs);
        group=findViewById(R.id.group);
        db= (CheckBox) findViewById(R.id.checkBox_db);
        ds= (CheckBox)findViewById(R.id.checkBox_ds);
        dc= (CheckBox)findViewById(R.id.checkBox_dc);
        gui=findViewById(R.id.button_gui);

        gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String hoten=ht.getText().toString();
                    String cmndan=cmnd.getText().toString();
                if(!checkname(hoten)){
                    Toast toast = Toast.makeText(MainActivity.this,"Tên người không được để trống và phải có ít nhất 3 ký tự",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(!checkcmnd(cmndan)){
                    Toast toast = Toast.makeText(MainActivity.this,"Chứng minh nhân dân chỉ được nhập kiểu số và phải có đúng 9 chữ số",Toast.LENGTH_SHORT);
                    toast.show();
                }else if(!sothich(db,ds,dc)){
                    Toast toast = Toast.makeText(MainActivity.this,"Sở thích phải chọn ít nhất 1 chọn lựa",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    public boolean checkname(String hoten){
        if(hoten.isEmpty() || hoten.length()<3){

            return false;
        }
        return true;
    }
    public boolean checkcmnd(String cmnd){
        if(cmnd.matches("[0-9]{9}")){
            return true;
        }
        return false;
    }
    public boolean sothich(CheckBox check1,CheckBox check2,CheckBox check3){
        if(check1.isChecked() || check2.isChecked() || check3.isChecked()){
            return true;
        }
        return false;
    }
}
