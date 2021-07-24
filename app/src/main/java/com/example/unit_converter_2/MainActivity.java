package com.example.unit_converter_2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner inputU;
    Spinner outputU;
    TextView result;
    EditText inputSpace;
    double inputNo;

    String firstPrefix;
    String secondPrefix;
    double frate;
    double srate;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputU = findViewById(R.id.InputUnit);
        outputU = findViewById(R.id.OutputUnit);
        result = findViewById(R.id.Output);
        inputSpace = findViewById(R.id.InputNum);


        ArrayAdapter<CharSequence> adaptor = ArrayAdapter.createFromResource(this,R.array.Units,android.R.layout.simple_spinner_item);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputU.setAdapter(adaptor);
        outputU.setAdapter(adaptor);


    }


    @Override
    public void onClick(View v){
        try{
            firstPrefix= inputU.getSelectedItem().toString();
            secondPrefix= outputU.getSelectedItem().toString();
            //Toast.makeText(getApplicationContext(),firstPrefix,Toast.LENGTH_SHORT).show();

            String tempStr = inputSpace.getText().toString();
            inputNo=Double.parseDouble(tempStr);
            double final_num = calculate(inputNo);
            String final_output = String.valueOf(final_num);

            result.setText(final_output);

        }
        catch(NumberFormatException e){
            result.setText("Please write a number");

        }



    }

    public double calculate(double input){
        double frate;
        double srate;
        /**
        if(firstPrefix.equals("kilo(k)")){
            frate = 1.0 * Math.pow(10,3);
        }
        else if(firstPrefix.equals("N/A")){
            frate = 1.0;
        }
        else{
            frate = 5.0;
        }
         **/

        switch(firstPrefix){
            case "atto(a)":
                frate = 1.0 * Math.pow(10,-18);
                break;
            case "femto(f)":
                frate = 1.0 * Math.pow(10,-15);
                break;
            case "kilo(k)":
                frate = 1.0 * Math.pow(10,3);
                break;
            case "N/A":
                frate = 1.0;
                break;
            case "pico(p)":
                frate = 1.0 * Math.pow(10,-12);
                break;
            case "nano(n)":
                frate = 1.0 * Math.pow(10,-9);
                break;
            case "micro(μ)":
                frate = 1.0 * Math.pow(10,-6);
                break;
            case "milli(m)":
                frate = 1.0 * Math.pow(10,-3);
                break;
            case "centi(c)":
                frate = 1.0 * Math.pow(10,-2);
                break;
            case "deci(d)":
                frate = 1.0 * Math.pow(10,-1);
                break;
            case "deka(da)":
                frate = 1.0 * Math.pow(10,1);
                break;
            case "hecto(h)":
                frate = 1.0 * Math.pow(10,2);
                break;
            case "mega(M)":
                frate = 1.0 * Math.pow(10,6);
                break;
            case "giga(G)":
                frate = 1.0 * Math.pow(10,9);
                break;
            case "tera(T)":
                frate = 1.0 * Math.pow(10,12);
                break;
            case "peta(P)":
                frate = 1.0 * Math.pow(10,15);
                break;
            case "exa(E)":
                frate = 1.0 * Math.pow(10,18);
                break;
            default:
                frate = 5.0; // delete later




        }

        /**
        if(secondPrefix.equals("kilo(k)")){
            srate = 1.0 * Math.pow(10,-3);
        }
        else if(secondPrefix.equals("N/A")){
            srate = 1.0;
        }
        else{
            srate = 1.0;
        }
         **/

        switch(secondPrefix){
            case "atto(a)":
                srate = 1.0 * Math.pow(10,18);
                break;
            case "femto(f)":
                srate = 1.0 * Math.pow(10,15);
                break;
            case "kilo(k)":
                srate = 1.0 * Math.pow(10,-3);
                break;
            case "N/A":
                srate = 1.0;
                break;
            case "pico(p)":
                srate = 1.0 * Math.pow(10,12);
                break;
            case "nano(n)":
                srate = 1.0 * Math.pow(10,9);
                break;
            case "micro(μ)":
                srate = 1.0 * Math.pow(10,6);
                break;
            case "milli(m)":
                srate = 1.0 * Math.pow(10,3);
                break;
            case "centi(c)":
                srate = 1.0 * Math.pow(10,2);
                break;
            case "deci(d)":
                srate = 1.0 * Math.pow(10,1);
                break;
            case "deka(da)":
                srate = 1.0 * Math.pow(10,-1);
                break;
            case "hecto(h)":
                srate = 1.0 * Math.pow(10,-2);
                break;
            case "mega(M)":
                srate = 1.0 * Math.pow(10,-6);
                break;
            case "giga(G)":
                srate = 1.0 * Math.pow(10,-9);
                break;
            case "tera(T)":
                srate = 1.0 * Math.pow(10,-12);
                break;
            case "peta(P)":
                srate = 1.0 * Math.pow(10,-15);
                break;
            case "exa(E)":
                srate = 1.0 * Math.pow(10,-18);
                break;

            default:
                srate = 5.0;


        }
        return (input * frate) * srate;



    }


}
