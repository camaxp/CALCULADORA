package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button suma;
    public Button resta;
    public Button multiplicacion;
    public Button division;
    public TextView total;
    public EditText num1;
    public EditText num2;

    private double numero1,numero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        suma=(Button)findViewById(R.id.suma);
        suma.setOnClickListener(this);
        resta=(Button)findViewById(R.id.resta);
        resta.setOnClickListener(this);
        multiplicacion=(Button)findViewById(R.id.multiplicacion);
        multiplicacion.setOnClickListener(this);
        division=(Button)findViewById(R.id.division);
        division.setOnClickListener(this);
        total=(TextView)findViewById(R.id.total);
        num1=(EditText)findViewById(R.id.num1);
        num2=(EditText)findViewById(R.id.num2);


        total.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // obtenemos el texto del textView3
                String text = total.getText().toString();
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("text",  text);
                clipboard.setPrimaryClip(clip);
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Resultado copiado en el portapapeles", Toast.LENGTH_SHORT);

                toast1.show();
                return false;
            }
        });




    }

    @Override
    public void onClick(View view) {
        numero1=Double.parseDouble(num1.getText().toString());
        numero2=Double.parseDouble(num2.getText().toString());
        switch(view.getId()){

            case R.id.suma:
                total.setText((numero1+numero2)+"");
                total.requestFocus();
                break;

            case R.id.resta:
                total.setText((numero1-numero2)+"");
                total.requestFocus();
                break;

            case R.id.multiplicacion:
                total.setText((numero1*numero2)+"");
                total.requestFocus();
                break;

            case R.id.division:
                total.setText((numero1/numero2)+"");
                total.requestFocus();
                break;


        }

    }




}
