package se.mah.idk.assignment_3;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import se.mah.k3.skaneAPI.control.Constants;
import se.mah.k3.skaneAPI.model.Journey;
import se.mah.k3.skaneAPI.model.Journeys;
import se.mah.k3.skaneAPI.xmlparser.Parser;


public class MainActivity extends ActionBarActivity {

    //private  ArrayList<Journey> journeyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MainFragment menuFragment = new MainFragment();
        fragmentTransaction.replace(R.id.MainLayout, menuFragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    /*
    private void searchFinished(){
        TextView tw = (TextView)findViewById(R.id.textView_test);
        tw.setText("");
        for (Journey j: journeyList){
            tw.append("From"+ j.getStartStation().getStationName()
                    +" To: "+ j.getEndStation()
                    + " leaves : "+j.getTimeToDeparture()+ "\n");

        }
    }

    //This is a AsyncTask Thread built for Android
    private class DoInBackground extends AsyncTask<String,Void,Long> {
        @Override
        protected Long doInBackground(String... params) {
            //Search
            Journeys journeys = Parser.getJourneys(params[0]); //There can be many in the params Array
            //And put the Journeys in our list.
            journeyList.clear();
            journeyList.addAll(journeys.getJourneys());
            return null;
        }

        @Override
        protected void onPostExecute(Long result) { //Called when the AsyncTask is all done
            searchFinished();
        }
    }
    */
}
