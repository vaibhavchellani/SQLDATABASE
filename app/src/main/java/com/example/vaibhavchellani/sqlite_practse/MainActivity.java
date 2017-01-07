package com.example.vaibhavchellani.sqlite_practse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    MyDBdatabse db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        textView=(TextView)findViewById(R.id.largetextview);
        db=new MyDBdatabse(this,null,null,1);
        printdatabase();
    }

    public void addButtonCLicked(View view){
        products product=new products(editText.getText().toString());
        db.addProduct(product);
        printdatabase();
    }
    public void removeButtonCLicked(View view){
        String product=editText.getText().toString();
        db.deleteProduct(product);
        printdatabase();
    }
    public void printdatabase(){
        String dbString=db.databaseToString();
        Toast.makeText(this, dbString, Toast.LENGTH_SHORT).show();
        textView.setText(dbString);
        editText.setText("");

    }

}
