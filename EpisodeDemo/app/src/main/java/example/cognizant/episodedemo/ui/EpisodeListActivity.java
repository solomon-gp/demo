package example.cognizant.episodedemo.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import example.cognizant.episodedemo.R;

/**
 * This class is the parent view of the {@link EpisodeListFragment}
 */
public class EpisodeListActivity extends EpisodeBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_episode_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onToolBarMenuItemClicked(View view) {
        switch(view.getId()){
            case R.id.menuItemBack:
                onBackPressed();
                //finish();
                break;
            case R.id.menuItemHome:
                break;
            case R.id.menuItemList:

                break;
        }
    }
}
