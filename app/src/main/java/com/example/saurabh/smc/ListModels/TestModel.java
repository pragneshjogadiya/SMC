package com.example.saurabh.smc.ListModels;

/**
 * Created by Saurabh on 6/3/2016.
 */
public class TestModel {


    String Text;
    boolean A;


    public TestModel(String Q, boolean A) {
        this.Text = Q;
        this.A = A;

    }
    public String getTitle(){
        return Text;
    }
    public boolean getCheck(){
        return A;
    }




}
