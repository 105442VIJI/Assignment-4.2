package com.example.acadgild.customlistview;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Vijailakshmi on 09-03-2016.
 */
public class CAdapter extends ArrayAdapter<String>{

    Activity context;
    String[] itemname;
    String[] numbers;
    Integer[] imageId;

    public CAdapter(Activity context, String[] itemname, String[] numbers, Integer[] imageId)
    {
        super(context,R.layout.list_items,numbers);
        Log.d("Msg: ", "Custom Adapter Constructor");
        this.context=context;
        this.itemname=itemname;
        this.numbers=numbers;
        this.imageId=imageId;
    }

    public View getView(int position,View view,ViewGroup parent)
    {
        Log.d("Msg: ", "myView");

        LayoutInflater inflater=context.getLayoutInflater();
        View customView = inflater.inflate(R.layout.list_items, null, true);

        Log.d("Msg: ", "Layout Inflated");

        ImageView listViewImage = (ImageView)customView.findViewById(R.id.listViewImage);
        TextView listViewText = (TextView)customView.findViewById(R.id.listViewText);
        TextView listViewNumber = (TextView)customView.findViewById(R.id.listViewNumber);

        Log.d("Msg: ", "Setting Resources");

        listViewImage.setImageResource(imageId[position]);
        listViewText.setText(itemname[position]);
        listViewNumber.setText(numbers[position]);

        Log.d("Msg: ", "Returning View");

        return customView;
    }
}
