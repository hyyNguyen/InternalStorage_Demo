package com.example.asus.internalstorage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_save, btn_read;
    private TextView tv_show;
    private final String FILENAME = "huydeptrai";
    private final String content = "NOI DUNG FILE LUU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVIew();
    }

    private void initVIew() {
        btn_save = (Button) findViewById(R.id.btn_save_data);
        btn_read = (Button) findViewById(R.id.btn_read_data);
        tv_show = (TextView) findViewById(R.id.tv_show_data);
        btn_save.setOnClickListener(this);
        btn_read.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_save_data:
                //
                saveData();
                break;
            case R.id.btn_read_data:
                //
                readData();
                break;
            default:
                break;

        }
    }

    private void saveData() {
        //khai bao de luu
        //output la di xun.
        FileOutputStream outputStream = null;
        try {
            //mode_private la che do defaut. chỉ có ứng dung ms truy cập đến
            outputStream = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            //write vao
            //ko the luu string. chuyen doi qua byte
            outputStream.write(content.getBytes());
            outputStream.close();
            Toast.makeText(this, "Thành cmn công", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readData() {
        try {
            //mo luon
            FileInputStream inputStream = openFileInput(FILENAME);
            //doc dữ liệu đọc từng dòng
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer buffer = new StringBuffer();
            String line = null;
            //doc tung dong readline
            //line de luu sau khi doc dc dong dau tien
            while ((line= br.readLine()) != null){
                //append de gan cac file gắn kết các dòng với nhau. đọc khi hết dòng nữa
                //thoát file.
                //luu vào buffer
                buffer.append(line).append("\n");
                //show
                tv_show.setText(buffer.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readData2() {
        try {
            //mo luon
            FileInputStream inputStream = openFileInput(FILENAME);
            //doc dữ liệu đọc từng dòng
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer buffer = new StringBuffer();
            String line = null;
            //doc tung dong readline
            //line de luu sau khi doc dc dong dau tien
            while ((line= br.readLine()) != null){
                //append de gan cac file gắn kết các dòng với nhau. đọc khi hết dòng nữa
                //thoát file.
                //luu vào buffer
                buffer.append(line).append("\n");
                //show
                tv_show.setText(buffer.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
