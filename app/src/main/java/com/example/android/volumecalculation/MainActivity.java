package com.example.android.volumecalculation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import static java.lang.Math.*;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    TextView textView;
    CheckBox checkboxMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        editText1  = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView  = (TextView) findViewById(R.id.textView4);
        checkboxMail = (CheckBox)findViewById(R.id.checkBox);



        final Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent;

                //Объявим числовые переменные
                double r,h,a;

                //Считаем с editText1 и editText2 текстовые значения

                String S1 = editText1.getText().toString();
                String S2 = editText2.getText().toString();

                //Преобразуем текстовые переменные в числовые значения
                r = Double.parseDouble(S1);
                h = Double.parseDouble(S2);

                //Проведем с числовыми переменными нужные действия

                    a = Math.PI * r * r * h / 3;

                //Преобразуем число в строку
                String S = Double.toString(a);

                //Выведем текст в textView4
                textView.setText(S);



                if(checkboxMail.isChecked()) {

                    intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"example@yahoo.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.Vcone));

                    intent.putExtra(Intent.EXTRA_TEXT, S);
                    intent.setType("message/rfc822");
                    startActivity(Intent.createChooser(intent, getString(R.string.Choose)));


                }

            }




        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
