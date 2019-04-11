package dz.deepwork.gamemn02.presenceregister.utils;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionTime;

public class BindingUtil {

    @BindingAdapter(value={"calendar"})
    public static void bindWithCalendar(TextView view, Calendar calendar)
    {
        String dateString =
                calendar != null ?
                        new SimpleDateFormat("hh:mm   dd-MM-yyyy").format(calendar.getTime())
                        : null;
        view.setText(dateString);
    }

    @BindingAdapter(value={"nameFormat", "name"})
    public static void bindWithName(TextView view, String nameFormat, String name)
    {
        view.setText(String.format(nameFormat, name));
    }

    @BindingAdapter(value={"detailsFormat", "details"})
    public static void bindWithDetails(TextView view, String detailsFormat, String details)
    {
        view.setText(String.format(detailsFormat, details));
    }

    @BindingAdapter(value={"roomFormat", "room"})
    public static void bindWithRoom(TextView view, String roomFormat, String room)
    {
        view.setText(String.format(roomFormat, room));
    }

    @BindingAdapter(value={"sessionIntervalFormat", "sessionTime", "sessionSize"})
    public static void bindWithInterval(TextView view, String sessionIntervalFormat, SessionTime sessionTime, int sessionSize)
    {
        view.setText(
                sessionTime != null ?
                        String.format(sessionIntervalFormat,
                                sessionTime.startToString(),
                                sessionTime.endToString(sessionSize))
                        : null);
    }

    @BindingAdapter(value={"show"})
    public static void bindWithShow(TextView view, Boolean show)
    {
        view.setVisibility((show != null ? show : false) ? View.VISIBLE : View.INVISIBLE);
    }

    @BindingAdapter(value={"hide"})
    public static void bindWithHide(TextView view, Boolean hide)
    {
        view.setVisibility((hide != null ? hide : true) ? View.INVISIBLE : View.VISIBLE);
    }
}
