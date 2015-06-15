package se.mah.idk.assignment_4;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;


public class GridFragment extends Fragment {

    public static ArrayList<Planet> planets = new ArrayList<Planet>();
    public static ArrayList<Drawable> planetImages = new ArrayList<Drawable>();

    public GridFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        planetImages.add(getResources().getDrawable(R.drawable.mercury));
        planetImages.add(getResources().getDrawable(R.drawable.venus));
        planetImages.add(getResources().getDrawable(R.drawable.earth));
        planetImages.add(getResources().getDrawable(R.drawable.mars));
        planetImages.add(getResources().getDrawable(R.drawable.jupiter));
        planetImages.add(getResources().getDrawable(R.drawable.saturn));
        planetImages.add(getResources().getDrawable(R.drawable.uranus));
        planetImages.add(getResources().getDrawable(R.drawable.neptune));

        String[] planetInfo = getResources().getStringArray(R.array.planet_info);
        String[] planetNames = getResources().getStringArray(R.array.planet_names);
        String[] planetRadius = getResources().getStringArray(R.array.planet_radius);
        String[] planetMass = getResources().getStringArray(R.array.planet_mass);
        String[] planetURL = getResources().getStringArray(R.array.planet_links);

        planets.clear();
        for(int i = 0; i < 8; i++){
            Drawable image = planetImages.get(i);
            String info = planetInfo[i];
            String name = planetNames[i];
            String radius = planetRadius[i];
            String mass = planetMass[i];
            String url = planetURL[i];
            planets.add(new Planet(name, info, radius, mass, image, url));
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_grid, container, false);
        CustomArrayAdapter adapter = new CustomArrayAdapter(getActivity(),planets);

        GridView gridView = (GridView) view.findViewById(R.id.gridView_planets);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                InfoFragment infoFragment = new InfoFragment();

                fragmentTransaction.replace(R.id.activityLayout_main, infoFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        return view;
    }


}
