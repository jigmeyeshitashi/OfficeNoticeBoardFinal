package bt.gov.dit.officenoticeboard.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import bt.gov.dit.officenoticeboard.NoticeBoard;
import bt.gov.dit.officenoticeboard.NoticeListAdapter;
import bt.gov.dit.officenoticeboard.NoticeBoardAsyncTask;
import bt.gov.dit.officenoticeboard.Notices;
import bt.gov.dit.officenoticeboard.OnReceiveNotices;
import bt.gov.dit.officenoticeboard.R;


public class OfficeNoticeBoardFragment extends Fragment implements OnReceiveNotices{
    private View rootView;
    private ListView noticesListView;
    private NoticeListAdapter adapter;

    public OfficeNoticeBoardFragment() {
        // Required empty public constructor
    }


    public static OfficeNoticeBoardFragment newInstance() {
        OfficeNoticeBoardFragment fragment = new OfficeNoticeBoardFragment();
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
        rootView = inflater.inflate(R.layout.fragment_office_notice_board, container, false);
        initLayout();
        return rootView;
    }

    private void initLayout() {
        noticesListView = (ListView) rootView.findViewById(R.id.notice_board_fragment_list_view);
        adapter = new NoticeListAdapter(getActivity());
        noticesListView.setAdapter(adapter);
        new NoticeBoardAsyncTask(getActivity(), this).execute(0);
    }

    @Override
    public void onReceive(ArrayList<Notices> notices) {
        if(notices != null){
            adapter.addAll(notices);
            adapter.notifyDataSetChanged();
        }

    }
}
