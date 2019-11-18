package com.example.taxipot_android.util;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import com.example.taxipot_android.domain.entity.History;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapPosition {
    private static Geocoder geocoder;
    public MapPosition(Context context) {
        geocoder = new Geocoder(context);
    }
    public Address coordinateToLocate(double latitude, double longitude) throws IOException {
        return geocoder.getFromLocation(latitude, longitude, 1).get(0);
    }

    public Address locateToCoordinate(String locate) throws IOException {
        return geocoder.getFromLocationName(locate,1,33.0,124.0,43.0,132.0).get(0);
    }

    public String getLocateFromAddress(Address address) {
        return address.getThoroughfare() + " " + address.getFeatureName();
    }

    public List<History> historiesTransForm(List<History> histories) {
        List<History> list = new ArrayList<History>();
        for(History item : histories) {
            Log.e(this.getClass().getSimpleName(),histories.size() + ": historiesT");
            String start;
            try {
                Address add = coordinateToLocate(item.getStart_latitude(), item.getStart_longtitude());
                start = getLocateFromAddress(add);
            } catch (IOException e) {
                Log.e(this.getClass().getSimpleName(),e.getMessage());
                start = "위치 찾을 수 없음";
            }
            item.setStart(start);
            String end;
            try {
                Address add = coordinateToLocate(item.getStart_latitude(), item.getStart_longtitude());
                end = getLocateFromAddress(add);
            } catch (IOException e) {
                Log.e(this.getClass().getSimpleName(),e.getMessage());
                end = "위치 찾을 수 없음";
            }
            item.setFinish(end);
            Log.e(this.getClass().getSimpleName(),start + "~" + end);
            list.add(item);
        }
        return list;
    }
}
