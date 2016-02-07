package example.cognizant.episodedemo.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import example.cognizant.episodedemo.R;

/**
 * Created by spathinathan on 2/4/16.
 */
public class EpisodeListAdapter extends ArrayAdapter{
    Context mContext;
    int layoutResourceId;
    ArrayList<Episode> episodeArrayList = null;

    public EpisodeListAdapter(Context context, int layoutResourceId, ArrayList<Episode> episodeArrayList) {
        super(context, layoutResourceId, episodeArrayList);
        this.mContext = context;
        this.layoutResourceId = layoutResourceId;
        this.episodeArrayList = episodeArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        // object item based on the position
        Episode episode = episodeArrayList.get(position);

        // get the TextView and then set the text (item name) and tag (item ID) values
        TextView textViewItem = (TextView) convertView.findViewById(R.id.episodeTitle);
        textViewItem.setText(episode.getTitle());
        convertView.setTag(episode.getImdbId());
        return convertView;

    }

}
