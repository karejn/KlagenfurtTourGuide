package com.example.ekzhu.klagenfurttourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends Fragment {

    public ShoppingFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        String[] name = getResources().getStringArray(R.array.shopping_name);
        String[] description = getResources().getStringArray(R.array.shopping_description);
        String[] web = getResources().getStringArray(R.array.shopping_web);
        String[] price = getResources().getStringArray(R.array.shopping_price);
        int[] images = {
                R.drawable.arkaden,
                R.drawable.sued,
                R.drawable.benedikt,
                R.drawable.arts,
        };


        ArrayList<Place> places = new ArrayList<Place>();
        for (int i = 0; i < name.length ; i++) {
            places.add(new Place(name[i], description[i], web[i], images[i], price[i]));
        }
        // Create a new {@link ArrayAdapter} for shopping category
        final PlacesAdapter adapter = new PlacesAdapter(getActivity(), places);

        final ListView placesListView = (ListView) rootView.findViewById(R.id.list);

        placesListView.setAdapter(adapter);
        placesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Place currentPlace = adapter.getItem(position);
                Uri placeUri = Uri.parse(currentPlace.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, placeUri);
                startActivity(websiteIntent);
            }
        });
        return rootView;
    }
}
