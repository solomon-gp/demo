package example.cognizant.episodedemo.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import example.cognizant.episodedemo.R;

/**
 * Created by spathinathan on 2/6/16.
 * This class is the base activity of all the activities. This provides common UI features like the
 * ActionBar like tool bar. This also has the common logic to handle the menu items.
 */
public class EpisodeBaseActivity extends AppCompatActivity implements View.OnClickListener , LowerToolbarListener{

    private ProgressDialog mProgressDialog;

    @Override
    public void setContentView(int layoutResID)
    {
        CoordinatorLayout fullView = (CoordinatorLayout) getLayoutInflater().inflate(R.layout.layout_main, null);

        FrameLayout activityContainer = (FrameLayout) fullView.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);

        super.setContentView(fullView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.topToolBar);
        setSupportActionBar(toolbar);



        Toolbar toolbarBottom = (Toolbar) findViewById(R.id.toolbar_bottom);
        ImageButton backButton = (ImageButton)toolbarBottom.findViewById(R.id.menuItemBack);
        backButton.setOnClickListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        onToolBarMenuItemClicked(v);
    }

    /**
     * This method shows an error dialog with an OK button. This can be called from any child
     * activities.
     * @param title Title of the Error Alert
     * @param errorMessage Error message to be shown in the alert dialog.
     */
    protected void showErrorDialog(String title, String errorMessage){
        new AlertDialog.Builder(EpisodeBaseActivity.this)
                .setTitle(title)
                .setMessage(errorMessage)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        EpisodeBaseActivity.this.onBackPressed();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    /**
     * This method is from the interface {@link LowerToolbarListener}. This enables different activities
     * to override this method so that they can perform a different action based on the context.
     * If this method is not overridden in the child activities, the method in {@link EpisodeBaseActivity} will be called.
     * @param view View Item which is clicked in the ToolBar. Here it is an ImageButton.
     */
    @Override
    public void onToolBarMenuItemClicked(View view) {
        switch(view.getId()){
            case R.id.menuItemBack:
                onBackPressed();
                break;
            case R.id.menuItemHome:
                break;
            case R.id.menuItemList:

                break;
        }

    }

    /**
     * This method shows a progress indicator when a background operation is going on.
     */
    protected void showLoadingIndicator(){
        mProgressDialog = new ProgressDialog(EpisodeBaseActivity.this);
        mProgressDialog.setMessage("Please wait...");
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    /**
     * This method cancels the progress dialog being shown
     */
    protected void hideLoadingIndicator(){
        if(mProgressDialog != null){
            mProgressDialog.cancel();
            mProgressDialog = null;
        }
    }
}
