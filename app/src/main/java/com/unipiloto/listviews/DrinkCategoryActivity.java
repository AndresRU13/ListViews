package com.unipiloto.listviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<Drink>(
                this,
                android.R.layout.simple_list_item_1,
                Drink.dirnks);
        ListView listDrinks = (ListView) findViewById(R.id.list_options);
        listDrinks.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?> listView,
                                            View itemView,
                                            int position,
                                            long id) {
                            Intent intent = new Intent(DrinkCategoryActivity.this, Activity_Drink.class);
                            intent.putExtra(Activity_Drink.EXTRA_DRINKID, (int) id);
                            startActivity(intent);
                    }
                };
        listDrinks.setOnItemClickListener(itemClickListener);
    }
}