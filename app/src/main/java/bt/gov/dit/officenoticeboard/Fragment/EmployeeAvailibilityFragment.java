package bt.gov.dit.officenoticeboard.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bt.gov.dit.officenoticeboard.R;


public class EmployeeAvailibilityFragment extends Fragment {

    public EmployeeAvailibilityFragment() {
        // Required empty public constructor
    }

    public static EmployeeAvailibilityFragment newInstance() {
        EmployeeAvailibilityFragment fragment = new EmployeeAvailibilityFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee_availibility, container, false);
    }

}
