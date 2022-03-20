package com.example.pharmpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Pharmfileld extends ListActivity {
    private ListView listView;
    private String countryNames[] = {
            "SEMESTER 1 NOTES",
            "SEMESTER 2 NOTES",
            "SEMESTER 3 NOTES",
            "SEMESTER 4 NOTES",
            "SEMESTER 5 NOTES",
            "SEMESTER 6 NOTES",
            "SEMESTER 7 NOTES",
            "SEMESTER 8 NOTES",
            "PHARMACY PAPERS",
            " B.PHARM SYLLABUS",


    };

    private String capitalNames[] = {
            "SEMESTER 1 NOTES",
            "SEMESTER 2 NOTES",
            "SEMESTER 3 NOTES",
            "SEMESTER 4 NOTES",
            "SEMESTER 5 NOTES",
            "SEMESTER 6 NOTES",
            "SEMESTER 7 NOTES",
            "SEMESTER 8 NOTES",
            "PHARMACY PAPERS",
            " B.PHARM SYLLABUS",


    };

    private Integer imageid[] = {
            R.drawable.semester1,
            R.drawable.semester2,
            R.drawable.semester3,
            R.drawable.semester4,
            R.drawable.semester5,
            R.drawable.semester6,
            R.drawable.semester7,
            R.drawable.semester8,
            R.drawable.gpat,
            R.drawable.syllabus,


    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmfileld);
        TextView textView = new TextView(this);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText("List of Countries");

        ListView listView=(ListView)findViewById(android.R.id.list);
        listView.addHeaderView(textView);

        // For populating list data
        CustomCountryList customCountryList = new CustomCountryList(this, countryNames, capitalNames, imageid);
        listView.setAdapter(customCountryList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 1) {
                    //clicked apple

                    startActivity(new Intent(Pharmfileld.this, semester1.class));
                }else if(position==2){
                    //clicked orange
                    startActivity(new Intent(Pharmfileld.this,semester2.class));
                }else if (position==3){

                    startActivity(new Intent(Pharmfileld.this, Semester3.class));

                }else if (position == 4){
                    startActivity(new Intent(Pharmfileld.this, semester4.class));

                }else if(position == 5){
                    startActivity(new Intent(Pharmfileld.this, semester5.class));

                }else if(position == 6){
                    startActivity(new Intent(Pharmfileld.this, semester6.class));

                }else if(position == 7){
                    startActivity(new Intent(Pharmfileld.this, semester7.class));

                }else if(position== 8){
                    startActivity(new Intent(Pharmfileld.this, semester8.class));
                }else if (position==9){
                    startActivity(new Intent(Pharmfileld.this,GPATPAPER.class));
                }else if (position==10){
                    startActivity(new Intent(Pharmfileld.this,syllabus.class));
                }



            }
        });


    }
}



