package se.mah.idk.assignment_4;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class InfoFragment extends Fragment {


    public InfoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        Planet planet = (Planet) getArguments().getSerializable("planet");

        ImageView imageViewPlanet = (ImageView) view.findViewById(R.id.imageView_planetImage);
        TextView textViewName = (TextView) view.findViewById(R.id.textView_planetName);
        TextView textViewRadius = (TextView) view.findViewById(R.id.textView_radius);
        TextView textViewMass = (TextView) view.findViewById(R.id.textView_mass);
        TextView textViewInfo = (TextView) view.findViewById(R.id.textView_info);
        TextView textViewLink = (TextView) view.findViewById(R.id.textView_link);

        imageViewPlanet.setImageDrawable(planet.getImage());
        textViewName.setText(planet.getName());
        textViewRadius.setText("Radius: " + planet.getRadius());
        textViewMass.setText("Mass: " + planet.getMass());
        textViewInfo.setText(planet.getInfo());
        textViewLink.setText(planet.getWebURL());

        return view;
    }


}
