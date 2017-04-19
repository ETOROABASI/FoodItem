package com.example.android.fooditem;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    ListView listView;



    String[] foodName = {"Rice", "Beans", "Afang Soup", "Ekpang", "Garri", "Vegetable Soup", "Okra Soup"};

    String[] ingredients = {"Rice, Onions, Spice", "Beans, Maggie, Onions, Spice", "Afang Leaf, Water Leaf, Maggie, Fish",
                            "Cocoyam, Cocoyam leaf, Spice", "Cassava", "Vegetable Lef, Water Leaf", "Melon, Okra, Fish"};

    String[] balanced = {"Balanced", "Balanced"," Not Balanced","Balanced","Balanced"," Not Balanced","Balanced"};

    int [] foodImage = {R.drawable.rice, R.drawable.beans, R.drawable.afang, R.drawable.ekpang, R.drawable.garri,
                        R.drawable.vegetable, R.drawable.okra};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listViewId);

        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, foodName, ingredients,balanced, foodImage);

        listView.setAdapter(customAdapter);

        // sets a listener so that when an item i clicked, it goes to the next activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                //To get the toast

                TextView textView = (TextView) view.findViewById(R.id.foodName);

                Context context = getApplicationContext();
                CharSequence text = "You have clicked on "+ textView.getText() + " item";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }


}
