package com.example.gulbe.movieinfomvp;

import android.app.Activity;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by gulbe on 7.08.2018.
 */

public class CustomAdapter extends ArrayAdapter<String> {

    private final ArrayList<String> name;
    private final ArrayList<String> images;
    private final ArrayList<Float> popularityScore;
    private final Activity context;

    public CustomAdapter(Activity context, ArrayList<String> name, ArrayList<String> images, ArrayList<Float> popularityScore) {
        super(context, R.layout.custom_list, name);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.name=name;
        this.images=images;
        this.popularityScore=popularityScore;

    }

    public View getView(int position, View view, ViewGroup parent) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.custom_list, null,true);

        ImageView imgOfActor=(ImageView) rowView.findViewById(R.id.actorImg);
        TextView nameOfActor=(TextView) rowView.findViewById(R.id.actorName);
        TextView scoreOfActor=(TextView) rowView.findViewById(R.id.actorScore);

        String img_url=images.get(position);

        if (!img_url.equals("")){
            Picasso.with(context).load(img_url).into(imgOfActor);
        }
        nameOfActor.setText(name.get(position));
        scoreOfActor.setText("Popularity Score:"+popularityScore.get(position));

        return rowView;

    }


}
