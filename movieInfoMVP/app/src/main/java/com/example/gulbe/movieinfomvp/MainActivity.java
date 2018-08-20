package com.example.gulbe.movieinfomvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.example.gulbe.movieinfomvp.MainActivityContract.Presenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {
    private Button showBtn;
    private EditText searchBar;
    private Button searchBtn;
    private Presenter mPresenter;
    ArrayAdapter<String> adapter;
    private ListView list;
    private TextView resultCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainActivityPresenter(this);
    }

    @Override
    public void initView() {
        resultCount=(TextView) findViewById(R.id.countOfResults);
        list=(ListView) findViewById(R.id.actorList);
        searchBar = (EditText) findViewById(R.id.searchBar);
        showBtn = (Button) findViewById(R.id.showBtn);
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

                mPresenter.onShowClick();
            }
        });
        searchBtn=(Button) findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                
                mPresenter.onSearchClick();
            }
        });
    }

    @Override
    public void setList(ArrayList<String> name, ArrayList<String> image, ArrayList<Float> score){
        list.setAdapter(null);
        adapter=new CustomAdapter(MainActivity.this,name,image,score);
        list.setAdapter(adapter);


    }

    @Override
    public String getSearchKeyword() {
        return searchBar.getText().toString();
    }

    @Override
    public void showSearchError(int resId) {
        searchBar.setError(getString(resId));

    }

    @Override
    public void setCountOfResultsText(int count){
        resultCount.setText(count+"results found.");

    }

}
