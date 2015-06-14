package se.mah.idk.assignment_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import se.mah.k3.skaneAPI.model.Journey;
import se.mah.k3.skaneAPI.model.Station;


public class ListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<Journey> journeys;

    public ListAdapter (Context c, ArrayList<Journey> j){
        context = c;
        journeys = j;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater= (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.list_collapsed,null);

        TextView departure = (TextView) convertView.findViewById(R.id.collapsedInfo_departureTime);
        String minutesToDeparture = journeys.get(groupPosition).getTimeToDeparture();
        departure.setText(minutesToDeparture);

        ImageView imageViewWarning = (ImageView) convertView.findViewById(R.id.imageView_soonDeparture);
        int timeLeft = Integer.parseInt(minutesToDeparture);

        if(timeLeft <= 4 ){
            imageViewWarning.setVisibility(View.VISIBLE);
        } else {
            imageViewWarning.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.list_expanded,null);


        TextView from = (TextView) convertView.findViewById(R.id.expandedInfo_from);
        Station fromStation = journeys.get(groupPosition).getStartStation();
        from.setText(fromStation.getStationName());

        TextView departure = (TextView) convertView.findViewById(R.id.expandedInfo_departureTime);
        String timeToDeparture = journeys.get(groupPosition).getTimeToDeparture();
        departure.setText(timeToDeparture);

        TextView to = (TextView) convertView.findViewById(R.id.expandedInfo_to);
        Station toStation = journeys.get(groupPosition).getEndStation();
        to.setText(toStation.getStationName());

        TextView arrival = (TextView) convertView.findViewById(R.id.expandedInfo_arrivalTime);
        String timeOfTravel = journeys.get(groupPosition).getTravelMinutes();
        arrival.setText(timeOfTravel);

        return convertView;
    }



    @Override
    public int getGroupCount() {
        return journeys.size();
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }
}
