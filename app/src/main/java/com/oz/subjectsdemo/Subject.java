package com.oz.subjectsdemo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ojesh on 3/2/2016.
 */
public class Subject {


    @SerializedName("syllabus_subject_id")
    public String subId;
    @SerializedName("syllabus_subject_name")
    public String subName;
    @SerializedName("parent_class")
    public String className;


}
