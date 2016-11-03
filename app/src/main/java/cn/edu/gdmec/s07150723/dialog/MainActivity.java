package cn.edu.gdmec.s07150723.dialog;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2,et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
    }
    public void characterpickerdialog(View v){
        final  String options = "123131231";
        CharacterPickerDialog cpd = new CharacterPickerDialog(this,new View(this),null,options,false){
            @Override
            public void onClick(View v) {
                et3.append(((Button)v).getText().toString());
                if(((Button)v).getText().toString().equals("")){
                    dismiss();
                }

            }
        };
        cpd.show();
    }
    public void datepickerdialog(View v){
        DatePickerDialog dpd = new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                et1.setText("日期:"+year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
            }
        },2015, 10 ,25);
        dpd.show();
    }
    public void timepickerdialog(View v){
        TimePickerDialog tpd = new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener(){

            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                et2.setText(hourOfDay+":"+minute);
            }
        },9,15,true);
        tpd.show();
    }
    public void progressdialog(View v){
        final ProgressDialog pg = ProgressDialog.show(this,"加载","加载中,请稍后.....",true);
        new Thread(){
            public void run(){
                try{
                    sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    pg.dismiss();
                }
            }
        }.start();
    }
}
