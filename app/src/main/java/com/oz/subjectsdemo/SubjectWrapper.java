package com.oz.subjectsdemo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Ojesh on 3/2/2016.
 */
public class SubjectWrapper {
    @SerializedName("class_id")
    public String id;
    @SerializedName(value="subjects")
    public ArrayList<Subject> list=new ArrayList<>();
}
