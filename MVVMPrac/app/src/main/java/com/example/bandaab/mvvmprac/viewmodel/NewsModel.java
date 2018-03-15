package com.example.bandaab.mvvmprac.viewmodel;

import com.example.bandaab.mvvmprac.model.News;

import java.util.ArrayList;

/**
 * Created by bandaab on 2/20/18.
 */

public class NewsModel {

    public String header;
    public String description;

    public NewsModel(News news){
        this.header = news.header;
        this.description = news.description;
    }

    public NewsModel() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<NewsModel> getArrayList(){
        ArrayList<NewsModel> newsModelsList = new ArrayList<>();
        NewsModel newsModel1 = new NewsModel(new News("first","1st Desc"));
        NewsModel newsModel2 = new NewsModel(new News("second","second Desc"));
        NewsModel newsModel3 = new NewsModel(new News("third","third Desc"));
        NewsModel newsModel4 = new NewsModel(new News("fourth","fourth Desc"));
        NewsModel newsModel5 = new NewsModel(new News("fifth","fifth Desc"));
        newsModelsList.add(newsModel1);
        newsModelsList.add(newsModel2);
        newsModelsList.add(newsModel3);
        newsModelsList.add(newsModel4);
        newsModelsList.add(newsModel5);
        return newsModelsList;
    }
}
