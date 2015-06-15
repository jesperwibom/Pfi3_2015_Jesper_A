package se.mah.idk.assignment_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<Planet> {

    ArrayList<Planet> planets;
    Context context;

    public CustomArrayAdapter(Context context, ArrayList<Planet> planets) {
        super(context,0,planets);
        this.planets = planets;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.item_grid,null);

        Planet planet = planets.get(position);

        TextView textView = (TextView) convertView.findViewById(R.id.textView_planetName);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageView_planetImage);
        textView.setText(planet.getName());
        image.setImageDrawable(planet.getImage());

        return convertView;
    }
}
