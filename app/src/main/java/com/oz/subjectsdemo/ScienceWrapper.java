package com.oz.subjectsdemo;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ojesh on 3/14/2016.
 */
public class ScienceWrapper {
    @SerializedName(value="subject_id")
    public String id;
    @SerializedName("unit")
    public String unit;
    @SerializedName(value="lessons")
    public JSONObject jsonObject=new JSONObject();
    @SerializedName(value="Physics")
    public ArrayList<Science> pList=new ArrayList<>();
    @SerializedName(value="Chemistry")
    public ArrayList<Science> cList=new ArrayList<>();
    @SerializedName(value="Biology")
    public ArrayList<Science> bList=new ArrayList<>();
    @SerializedName(value="Geology and Astronomy")
    public ArrayList<Science> gList=new ArrayList<>();
    @SerializedName(value="Environment Science")
    public ArrayList<Science> eList=new ArrayList<>();

}
