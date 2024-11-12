package org.example.resources;

import org.example.pojo.AddPlace;
import org.example.pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {
    public AddPlace addPlacePayLoad(){
        AddPlace newPlace = new AddPlace();
        Location location = new Location();
        List<String> types = new ArrayList<String>();
        types.add("shoe park");
        types.add("shop");

        location.setLat(-38.383494);
        location.setLng(33.427362);

        newPlace.setLocation(location);
        newPlace.setAccuracy(50);
        newPlace.setName("Cristian");
        newPlace.setAddress("Chisinau");
        newPlace.setPhone_number("(+373) 79356922");
        newPlace.setTypes(types);
        newPlace.setWebsite("https://rahulshettyacademy.com");
        newPlace.setLanguage("French-IN");
        return newPlace;
    }
}