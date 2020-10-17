package com.example.registration;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.AdapterView.*;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {
    Button btn1,btn2;

    EditText edtuser,edtemail,etdpassword;
    Button btn,btnget;

    TextView txt;

    FragmentManager fragmentManager;
    FragmentTransaction ft;

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        final PojoClass pojoClass= new PojoClass();

        edtuser=findViewById(R.id.edtname);
        edtemail=findViewById(R.id.email);
        etdpassword=findViewById(R.id.password);

        btn=findViewById(R.id.btn);
        btnget=findViewById(R.id.btnget);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                pojoClass.setName(edtuser.getText().toString());
                pojoClass.setEmail(edtemail.getText().toString());
                pojoClass.setPassword(etdpassword.getText().toString());
            }

        });

        Toast.makeText(getApplicationContext(),"Set Values in Pojo Class",Toast.LENGTH_LONG).show();

        btnget.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=pojoClass.getName();
                String email=pojoClass.getEmail();
                String password=pojoClass.getPassword();


                txt.setText("name:"+name+"  email:"+email+"  password:"+password);

            }
        });

        viewPager = findViewById(R.id.myviewpager);

        Spinner spinner=findViewById(R.id.spinner1);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.text,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        MyAdapter myAdapter=new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myAdapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager = getSupportFragmentManager();
                ft=fragmentManager.beginTransaction();
                ft.replace(R.id.mylinear,new RegistrationPage1());
                ft.commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager = getSupportFragmentManager();
                ft=fragmentManager.beginTransaction();
                ft.replace(R.id.mylinear,new RegistrationPage2());
                ft.commit();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}