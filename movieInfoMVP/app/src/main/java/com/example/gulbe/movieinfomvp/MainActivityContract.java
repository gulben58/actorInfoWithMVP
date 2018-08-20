package com.example.gulbe.movieinfomvp;

import java.util.ArrayList;

/**
 * Created by gulbe on 7.08.2018.
 */

public interface MainActivityContract {

    interface View{

        void initView();

        void setList(ArrayList<String> name, ArrayList<String> image, ArrayList<Float> score);

        String getSearchKeyword();

        void showSearchError(int resId);

        void setCountOfResultsText(int count);
    }

    interface Model{

        ArrayList getListOfNames();

        ArrayList getListOfImages();

        ArrayList getListOfScores();
    }

    interface Presenter{

        void onShowClick();

        void onSearchClick();
    }
}
