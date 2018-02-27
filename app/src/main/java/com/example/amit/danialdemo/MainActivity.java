package com.example.amit.danialdemo;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{




    SeekBar seekBar1,seekBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar1=findViewById(R.id.rowNum);
        seekBar2=findViewById(R.id.colNum);
        //addData(4,4);
        findViewById(R.id.populate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("+++++++++",seekBar1.getProgress()+"");

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TableLayout tl = findViewById(R.id.table);
                        tl.removeAllViews();
                        addData(seekBar1.getProgress(),seekBar2.getProgress());

                    }
                });
            }
        });


    }
    private TextView getTextView(int id, String title, int color, int typeface, int bgColor) {
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText(title.toUpperCase());
        tv.setTextColor(color);
        tv.setPadding(40, 40, 40, 40);
        tv.setTypeface(Typeface.DEFAULT, typeface);
        tv.setBackgroundColor(bgColor);
        tv.setLayoutParams(getLayoutParams());
        tv.setOnClickListener(this);
        return tv;
    }

    @NonNull
    private LayoutParams getLayoutParams() {
        LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        params.setMargins(2, 2, 2, 2);
        return params;
    }

    @NonNull
    private TableLayout.LayoutParams getTblLayoutParams() {
        return new TableLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
    }



    /**
     * This function add the data to the table
     **/
    public void addData(int x,int y) {

        TableLayout tl = findViewById(R.id.table);
        for (int i = 0; i < x; i++) {
            TableRow tr = new TableRow(this);
            tl.addView(tr, getTblLayoutParams());


            tr.setLayoutParams(getLayoutParams());
            for (int j = 0; j < y; j++) {

                tr.addView(getTextView(i + 1, "", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent)));

            }

        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        TextView tv = findViewById(id);
        if (null != tv) {
            Log.i("onClick", "Clicked on row :: " + id);
            Toast.makeText(this, "Clicked on row :: " + id + ", Text :: " + tv.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}
