package org.tiqr.authenticator.enrollment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import org.tiqr.authenticator.MainActivity;
import org.tiqr.authenticator.R;
import org.tiqr.authenticator.general.AbstractActivityGroup;
import org.tiqr.authenticator.general.FooterView;
import org.tiqr.authenticator.general.HeaderView;

public class EnrollmentSummaryActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enrollment_summary);

        HeaderView headerView = (HeaderView)findViewById(R.id.headerView);
        headerView.hideLeftButton();
        headerView.hideRightButton();

        AbstractActivityGroup parent = (AbstractActivityGroup)getParent();

        TextView dn = (TextView)findViewById(R.id.display_name);
        dn.setText(parent.getChallenge().getIdentity().getDisplayName());

        TextView ipdn = (TextView)findViewById(R.id.identity_provider_name);
        ipdn.setText(parent.getChallenge().getIdentity().getIdentifier());

        final Button ok = (Button)findViewById(R.id.confirm_button);
        if (ok != null) {
            ok.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    _returnToHome();
                }
            });
        }

        FooterView footer = (FooterView)findViewById(R.id.fallbackFooterView);

        if (footer != null) {
            footer.hideInfoIcon();
        }
    }

    /**
     * Return to the home screen
     */
    protected void _returnToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
