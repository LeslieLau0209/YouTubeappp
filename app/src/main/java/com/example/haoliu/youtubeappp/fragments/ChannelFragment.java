package com.example.haoliu.youtubeappp.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haoliu.youtubeappp.Adaters.VideoPostAdapter;
import com.example.haoliu.youtubeappp.Model.YoutubeDataModel;
import com.example.haoliu.youtubeappp.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChannelFragment extends Fragment {

    private static String API_KEY = "AIzaSyB9jsnhZxTk3P3AgAPMR01yvazXgmy_IqU";
    private static String CHANNEL_ID = "JFlaMusic";
    private static String CHANNEL_GET_URL = "http://www.googleapis.com/youtube/v3/search?part=snippet&order=date&channelId=" + CHANNEL_ID + "&maxResults=20&key=" + API_KEY + "";

    private RecyclerView mList_videos = null;
    private VideoPostAdapter adapter = null;
    private ArrayList<YoutubeDataModel> mListData = new ArrayList<>();


    public ChannelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_channel, container, false);
        mList_videos = (RecyclerView) view.findViewById(R.id.mList_videos);
        init(mListData);
        new RequestYoutubeAPI().execute();
        return view;
    }

    // start out an empty array
    private void init(ArrayList<YoutubeDataModel> mListData) {
        mList_videos.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new VideoPostAdapter(mListData,getActivity());
        mList_videos.setAdapter(adapter);
    }

    private class RequestYoutubeAPI extends AsyncTask<Void, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(CHANNEL_GET_URL);
            Log.e("URL", CHANNEL_GET_URL);

            HttpResponse response = null;
            try {
                response = httpClient.execute(httpGet);
                HttpEntity httpEntity = response.getEntity();
                String json = EntityUtils.toString(httpEntity);
                return json;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String str) {
            super.onPostExecute(str);
            if (str != null) {
                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Log.e("response", jsonObject.toString());
//                    mListData = parseVideoListFromResponse(jsonObject);
                    init(mListData);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    private ArrayList<YoutubeDataModel> parseVideoListFromResponse(JSONObject jsonObject) {
//        ArrayList<YoutubeDataModel> mList = new ArrayList<>();
//        if (jsonObject.has("items")) {
//            try {
//                JSONObject jsonArray = jsonObject.getJSONArray("items");
//                for (int i = 0; i < jsonArray.length(); i++) {
//                    JSONObject json = jsonArray.getJSONObject(i);
//
//                }
//            }
//        }
//        return mList;
//    }

}
