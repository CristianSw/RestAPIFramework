package org.example.resources;

import org.example.pojo.AddPlace;
import org.example.pojo.DeletePlace;
import org.example.pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {
    public AddPlace addPlacePayLoad(String name, String language, String address) {
        AddPlace newPlace = new AddPlace();
        Location location = new Location();
        List<String> types = new ArrayList<>();
        types.add("shoe park");
        types.add("shop");

        location.setLat(-38.383494);
        location.setLng(33.427362);

        newPlace.setLocation(location);
        newPlace.setAccuracy(50);
        newPlace.setName(name);
        newPlace.setAddress(address);
        newPlace.setPhone_number("(+373) 79356922");
        newPlace.setTypes(types);
        newPlace.setWebsite("https://rahulshettyacademy.com");
        newPlace.setLanguage(language);
        return newPlace;
    }

    public DeletePlace deletePlacePayloadData(String placeId){
        DeletePlace placeToDelete = new DeletePlace();
        placeToDelete.setPlace_id(placeId);
        return placeToDelete;
    }
}