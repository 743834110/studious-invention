package com.example.coolweather.android.json;

import com.example.coolweather.android.dto.DatabaseDto.County;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by angel beat on 2017/8/7.
 */

public class ParseWithCountyJSON implements IParse {
    @Override
    public Object execute(String data,int code) {
        try {
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0 ; i < jsonArray.length() ; i++){
                JSONObject object = jsonArray.getJSONObject(i);
                County county = new County();
                county.setCountyCode(object.getInt("id"));
                county.setCountyName(object.getString("name"));
                county.setWeatherID(object.getString("weather_id"));
                county.setCityCode(code);
                county.save();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }
}
