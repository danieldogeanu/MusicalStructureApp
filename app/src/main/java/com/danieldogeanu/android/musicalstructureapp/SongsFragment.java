package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongsFragment extends Fragment {

    Data mData;
    ArrayList<Song> mSongs;
    MediaState mMediaState;
    ListView mListView;
    SongAdapter mAdapter;

    public SongsFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        mData = Data.getInstance();
        mSongs = mData.getSongs();
        mMediaState = MediaState.getInstance();

        mListView = (ListView) rootView.findViewById(R.id.listView);
        mAdapter = new SongAdapter(getActivity(), mSongs, mMediaState);
        mListView.setAdapter(mAdapter);
        mAdapter.setNotifyOnChange(true);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Song song = mSongs.get(position);
                mMediaState.togglePlayingSong(song, view);

            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter = new SongAdapter(getActivity(), mSongs, mMediaState);
        mListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
