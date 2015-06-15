package se.mah.idk.assignment_3;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import se.mah.k3.skaneAPI.control.Constants;
import se.mah.k3.skaneAPI.model.Journey;
import se.mah.k3.skaneAPI.model.Journeys;
import se.mah.k3.skaneAPI.xmlparser.Parser;


public class MainFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private ListAdapter listAdapter;
    private ArrayList<Journey> arrayJourneys;
    private Spinner spinnerFrom;
    private Spinner spinnerTo;

    public MainFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); //this activates menu items for fragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        arrayJourneys = new ArrayList<Journey>();

        ExpandableListView expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListViewJourneys);
        listAdapter = new ListAdapter(getActivity(), arrayJourneys);
        expandableListView.setAdapter(listAdapter);

        spinnerFrom = (Spinner) view.findViewById(R.id.spinnerFrom);
        spinnerTo = (Spinner) view.findViewById(R.id.spinnerTo);

        spinnerFrom.setOnItemSelectedListener(this);
        spinnerTo.setOnItemSelectedListener(this);

        spinnerTo.setSelection(1);

        return view;
    }

    //Listens to refresh
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.refresh:

                int fromStation = spinnerFrom.getSelectedItemPosition();
                int toStation = spinnerTo.getSelectedItemPosition();

                String[] arrayStationNumbers = getResources().getStringArray(R.array.stationNumbers);
                String searchURL = Constants.getURL(arrayStationNumbers[fromStation], arrayStationNumbers[toStation], 10);

                new CustomAsyncTask().execute(searchURL);
                Toast.makeText(getActivity(), "Refreshed", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    //Listens to spinner change
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        int fromStation = spinnerFrom.getSelectedItemPosition();
        int toStation = spinnerTo.getSelectedItemPosition();

        String[] arrayStationNumbers = getResources().getStringArray(R.array.stationNumbers);
        String searchURL = Constants.getURL(arrayStationNumbers[fromStation], arrayStationNumbers[toStation], 10);

        new CustomAsyncTask().execute(searchURL);

    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    private class CustomAsyncTask extends AsyncTask<String, Void, Long> {

        @Override
        protected Long doInBackground(String... params) {
            Journeys journeys = Parser.getJourneys(params[0]);

            arrayJourneys.clear();
            arrayJourneys.addAll(journeys.getJourneys());
            return null;
        }


        protected void onPostExecute(Long result) {
            listAdapter.notifyDataSetChanged();
        }
    }
}
