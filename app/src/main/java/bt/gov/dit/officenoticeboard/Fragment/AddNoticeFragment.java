package bt.gov.dit.officenoticeboard.Fragment;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import bt.gov.dit.officenoticeboard.Helper.DateDialog;
import bt.gov.dit.officenoticeboard.R;

public class AddNoticeFragment extends Fragment implements View.OnFocusChangeListener {
    private EditText startDate, endDate, place;
    private View rowView;
    private Spinner noticePurpose;
    private String action;

    public AddNoticeFragment() {
        // Required empty public constructor
    }

    public static AddNoticeFragment newInstance() {
        AddNoticeFragment fragment = new AddNoticeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /* if (getArguments() != null) {

        }*/
        /*if(action.equals(NoticeAction.ACTION_ADD)) {
            initlayout();
            enableEditing(true);
            //image.setVisibility(View.VISIBLE);
            //updateTaskBtn.setVisibility(View.INVISIBLE);
            startDate.setOnFocusChangeListener(this);
            endDate.setOnFocusChangeListener(this);
        }*//*else if(action.equals(NoticeAction.ACTION_VIEW)) {
            initlayout();
            enableEditing(false);

        }else if(action.equals(NoticeAction.ACTION_EDIT)) {
            initlayout();
            enableEditing(true);

        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rowView = inflater.inflate(R.layout.fragment_add_notice, container, false);
        initlayout();

        return rowView;
    }

    private void initlayout() {
        place = (EditText) rowView.findViewById(R.id.place_edit_text);
        noticePurpose = (Spinner) rowView.findViewById(R.id.notice_purpose_spinner);
        startDate = (EditText) rowView.findViewById(R.id.start_date_edit_text);
        endDate = (EditText) rowView.findViewById(R.id.end_date_edit_text);
        startDate.setOnFocusChangeListener(this);
        endDate.setOnFocusChangeListener(this);
        fillnoticepurpose();
    }

    private void fillnoticepurpose() {
        String[] task = new String[]{"Training", "Workshop", "Tour", "Meeting", "Seminar", "Leave"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, task);
        noticePurpose.setAdapter(adapter);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        DateDialog dialog = new DateDialog(v);
        FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
        dialog.show(fragmentTransaction, "DatePicker");
    }

    private void enableEditing(boolean enable) {
        noticePurpose.setEnabled(enable);
        startDate.setEnabled(enable);
        endDate.setEnabled(enable);
        place.setEnabled(enable);

    }
}
