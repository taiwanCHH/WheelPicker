package com.kao.icespot.wheelpicker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kaoice.stringpicker.DataModel;
import kaoice.stringpicker.StringPickerDialog;


public class MainActivity extends ActionBarActivity implements

        View.OnClickListener, StringPickerDialog.OnClickListener {

    private static final String TAG = StringPickerDialog.class.getSimpleName();

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.text);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(getString(R.string.string_picker_dialog_values), new DataModel(getFirst(), getSecond()));
        StringPickerDialog dialog = new StringPickerDialog();
        dialog.setArguments(bundle);
        dialog.show(getSupportFragmentManager(), TAG);
    }

    @Override
    public void onClick(String pickerOneValue, String pickerTwoValue) {
        mTextView.setText(pickerOneValue + pickerTwoValue);
    }


    private List<String> getFirst() {
        List firstList = new ArrayList();
        firstList.add("台北市");
        firstList.add("基隆市");
        firstList.add("連江縣");
        return firstList;
    }

    private HashMap<String, List<String>> getSecond() {
        HashMap hp = new HashMap<String, List<String>>();
        List one = new ArrayList();
        one.add("中正區");
        one.add("大同區");
        one.add("中山區");
        one.add("松山區");
        hp.put("台北市", one);
        List two = new ArrayList();
        two.add("仁愛區");
        two.add("七堵區");
        two.add("中正區");
        two.add("暖暖區");
        hp.put("基隆市", two);
        List three = new ArrayList();
        three.add("南竿");
        three.add("北竿");
        three.add("莒光");
        three.add("東引");
        hp.put("連江縣", three);
        return hp;

    }


}