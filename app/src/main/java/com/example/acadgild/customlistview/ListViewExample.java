package com.example.acadgild.customlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewExample extends AppCompatActivity {

    ListView listView;

    String [] itemname = {"Vijailakshmi", "Venkat Vivek", "Android", "Home", "Papa", "Mummy", "Bhai"};

    String [] numbers = {"1234124988","1234567890","0987654321","1243857609","1212121212","2323232323","0909090909"};

    Integer [] imageId = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic1,
            R.drawable.pic2, R.drawable.pic3, R.drawable.pic3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Log.d("Msg: ", "onCreate");
        Log.d("Msg: ", "set Adapter");
        CAdapter adapter= new CAdapter(this,itemname,numbers,imageId);
        Log.d("Msg: ", "Adapter set");
        listView = (ListView)findViewById(R.id.listview);
        Log.d("Msg: ", "List View object");
        listView.setAdapter(adapter);
        Log.d("Msg: ", "Adapter assigned to List View");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Log.d("Msg: ","Item Clicked");
                StringBuilder Display = new StringBuilder().append("Name: ").append(itemname[position]).append(" Number: ").append(numbers[position]);
                Toast.makeText(ListViewExample.this,Display,Toast.LENGTH_LONG).show();
                Log.d("Msg: ", "Toast Created");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view, menu);
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
