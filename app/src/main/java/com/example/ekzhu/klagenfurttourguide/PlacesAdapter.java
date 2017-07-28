package com.example.ekzhu.klagenfurttourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlacesAdapter extends ArrayAdapter<Place> {


    public PlacesAdapter(Context context, ArrayList<Place> pPlaces) {
        super(context, 0, pPlaces);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //get the object located at given position
        Place currentPlace = getItem(position);

        // Find the TextView with view ID name
        TextView name = (TextView) listView.findViewById(R.id.name);
        name.setText(currentPlace.getName());

        // Find the TextView with ID knownFor
        TextView description = (TextView) listView.findViewById(R.id.description);
        description.setText(currentPlace.getDescription());

        // Find the TextView with ID price
        TextView price = (TextView) listView.findViewById(R.id.price);
        price.setText(currentPlace.getPrice());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listView.findViewById(R.id.image);
        // Check if an image is provided
        if (currentPlace.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentPlace.getmImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }
        return listView;
    }
}
