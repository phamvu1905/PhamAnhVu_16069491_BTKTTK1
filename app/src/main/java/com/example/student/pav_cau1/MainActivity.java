package com.example.student.pav_cau1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cbox_luu;
    Button btn_login, btn_exit;
    EditText edt_tk1, edt_tk2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFindViewByID();
        eventClickThoat();
        eventClickLogin();

    }

    private void eventClickThoat() {
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("Thông báo");
                mydialog.setMessage("Bạn muốn thoát không ?");
                mydialog.setCancelable(false);
                mydialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                mydialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog alertDialog = mydialog.create();
                alertDialog.show();
            }
        });
    }

    private void eventClickLogin() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tk1 = edt_tk1.getText().toString();
                String tk2 = edt_tk2.getText().toString();
                if(checkEmpty(tk1, tk2)){
                    if(cbox_luu.isChecked()){
                        Toast.makeText(getApplicationContext(), "Chào mừng bạn đăng nhập hệ thống, " +
                                "thông tin của bạn đã được lưu", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Chào mừng bạn đăng nhập hệ thống, " +
                                "thông tin của bạn không được lưu", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Tài khoản không được để trống", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void createFindViewByID() {
        cbox_luu = (CheckBox) findViewById(R.id.checkBox_luu);
        btn_login = (Button) findViewById(R.id.button_dangnhap);
        btn_exit = (Button) findViewById(R.id.button_exit);
        edt_tk1 = (EditText) findViewById(R.id.editText_tk1);
        edt_tk2 = (EditText) findViewById(R.id.editText_tk2);
    }

    private boolean checkEmpty(String tk1, String tk2){
        if(tk1.isEmpty() || tk2.isEmpty()){
            return false;
        }
        return true;
    }

}
