package com.nishanth.promptdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.promt_dialog,null);
                final EditText hid = (EditText)view.findViewById(R.id.hostelid);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Enter the hostel ID of the student").setView(view)
                        .setPositiveButton("DISPLAY", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int ID = Integer.parseInt(hid.getText().toString());
                                if (ID==1){
                                    Toast.makeText(MainActivity.this, " Nishanth",Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(MainActivity.this, " Student Details does not exist",Toast.LENGTH_SHORT).show();
                                }

                            }
                        }).setNegativeButton("HELP", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int ID = Integer.parseInt(hid.getText().toString());
                        if(ID!=1){
                            Toast.makeText(MainActivity.this, " Year Back",Toast.LENGTH_SHORT).show();
                        }
                    }
                }).setCancelable(false);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}
