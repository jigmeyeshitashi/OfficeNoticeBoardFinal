package bt.gov.dit.officenoticeboard.Helper;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

/**
 * Created by Jigme on 1/22/2017.
 */

public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener{
   EditText textDate;

    public DateDialog(View view){
        textDate = (EditText) view;
    }

    @TargetApi(Build.VERSION_CODES.N)
    public Dialog onCreateDialog(Bundle saveInstanceState){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
      String date = dayOfMonth + "-" +month+"-"+year;
       textDate.setText(date);

    }

}
