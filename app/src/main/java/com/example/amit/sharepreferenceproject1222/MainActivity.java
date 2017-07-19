package com.example.amit.sharepreferenceproject1222;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText name,age,number,city;
    Button save,show;
    SharedPreferences pref;
    String Name,Age,Number,City;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);
        age=(EditText)findViewById(R.id.age);
        number=(EditText)findViewById(R.id.num);
        city=(EditText)findViewById(R.id.city);
        save=(Button)findViewById(R.id.btnsave);
        show=(Button)findViewById(R.id.btnshow);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name=name.getText().toString();
                Age=age.getText().toString();
                Number=number.getText().toString();
                City=city.getText().toString();
                pref=getSharedPreferences("My_Data",MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
                editor.putString("key_name",Name);
                editor.putString("key_age",Age);
                editor.putString("key_number",Number);
                editor.putString("key_city",City);
                editor.commit();
                Toast.makeText(MainActivity.this,"Data Succesfully Saved",Toast.LENGTH_SHORT).show();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref=getSharedPreferences("My_Data",MODE_PRIVATE);
                String getName=pref.getString("key_name"," ");
                String getAge=pref.getString("key_age"," ");
                String getNumber=pref.getString("key_number"," ");
                String getCity=pref.getString("key_city"," ");
Toast.makeText(MainActivity.this,"Name :"+getName+"\n"+"Age :"+getAge+"\n"+"Number :"+getNumber+"\n"+"City :"+getCity,Toast.LENGTH_LONG).show();






            }
        });
    }

}
