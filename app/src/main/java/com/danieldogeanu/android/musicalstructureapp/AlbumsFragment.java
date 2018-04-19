package com.danieldogeanu.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AlbumsFragment extends Fragment {

    public AlbumsFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        Data data = Data.getInstance();
        final ArrayList<Album> albums = data.getAlbums();

        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        AlbumAdapter adapter = new AlbumAdapter(getActivity(), albums);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Album thisAlbum = albums.get(position);

                Intent listActivity = new Intent(getContext(), ListActivity.class);
                listActivity.putExtra("album_data", thisAlbum);
                startActivity(listActivity);

            }
        });

        return rootView;
    }
}
