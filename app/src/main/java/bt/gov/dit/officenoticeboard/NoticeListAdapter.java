package bt.gov.dit.officenoticeboard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jigme on 1/26/2017.
 */

public class NoticeListAdapter extends ArrayAdapter<Notices> {
    private Context context;

    public NoticeListAdapter(Context context){
        super(context, R.layout.notice_list_item, new ArrayList<Notices>());
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View rowView = inflater.inflate(R.layout.notice_list_item, parent, false);

        TextView noticesTextView = (TextView) rowView.findViewById(R.id.notice_text_view);
        Notices notices = getItem(position);

        noticesTextView.setText(notices.getDescription());

        return rowView;
    }
}
