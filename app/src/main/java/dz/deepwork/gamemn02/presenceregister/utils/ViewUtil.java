package dz.deepwork.gamemn02.presenceregister.utils;

import android.view.View;

public class ViewUtil {

    static public Integer sessionToVisible(boolean exist) {
        return exist ? View.VISIBLE : View.INVISIBLE;
    }
}
