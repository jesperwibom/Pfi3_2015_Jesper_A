package se.mah.idk.assignment_4;


import android.app.DialogFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CustomDialogFragment extends DialogFragment implements View.OnClickListener {


    public CustomDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogfragment_about, container, false);
        view.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        CustomDialogFragment.this.dismiss();
    }


}
