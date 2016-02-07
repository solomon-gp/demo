package example.cognizant.episodedemo.ui;

import android.view.View;

/**
 * Created by spathinathan on 2/7/16.
 * This interface enables different activities to define their own actions for the menu items in the
 * lower tool bar.
 */
public interface LowerToolbarListener {

    /**
     * Method to be implemented in Child activities to define custom actions for menu items in the
     * lower tool bar.
     * @param view Image button which is part of the Lower tool bar.
     */
    void onToolBarMenuItemClicked(View view);
}
