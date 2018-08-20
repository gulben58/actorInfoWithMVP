package com.example.gulbe.movieinfomvp;

import com.example.gulbe.movieinfomvp.MainActivityContract.Model;
import com.example.gulbe.movieinfomvp.MainActivityContract.View;

import java.util.ArrayList;

/**
 * Created by gulbe on 7.08.2018.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private View mView;
    private Model mModel;
    String searchWord;
    ArrayList<String> listOfNames;
    ArrayList<String> listOfImages;
    ArrayList<Float>  listOfScores;
    ArrayList<String> listOfSearchedNames=new ArrayList<>();
    ArrayList<String> listOfSearchedImages=new ArrayList<>();
    ArrayList<Float>  listOfSearchedScores=new ArrayList<>();


    public MainActivityPresenter(View view) {
        mView = view;
        initPresenter();
    }

    public void initPresenter() {
        mModel = new MainActivityModel();
        mView.initView();
    }

    @Override
    public void onShowClick() {
          listOfNames=mModel.getListOfNames();
          listOfImages=mModel.getListOfImages();
          listOfScores=mModel.getListOfScores();


          mView.setList(listOfNames,listOfImages,listOfScores);
          mView.setCountOfResultsText(listOfNames.size());

    }

    @Override
    public void onSearchClick() {

        searchWord=mView.getSearchKeyword();

        if(searchWord.isEmpty()){
            mView.showSearchError(R.string.search_error);

        }
        else {
            listOfSearchedNames.clear();
            listOfSearchedImages.clear();
            listOfSearchedScores.clear();
            listOfNames = mModel.getListOfNames();
            listOfImages = mModel.getListOfImages();
            listOfScores = mModel.getListOfScores();

            for (int i = 0; i < listOfNames.size(); i++) {

                if (listOfNames.get(i).toLowerCase().contains(searchWord.toLowerCase())) {

                    listOfSearchedNames.add(listOfNames.get(i));
                    listOfSearchedImages.add(listOfImages.get(i));
                    listOfSearchedScores.add(listOfScores.get(i));
                }
            }

            mView.setList(listOfSearchedNames, listOfSearchedImages, listOfSearchedScores);
            mView.setCountOfResultsText(listOfSearchedNames.size());
            listOfScores.clear();
            listOfNames.clear();
            listOfImages.clear();

        }
    }
}
