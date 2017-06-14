package gift.witch.gradle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView appIDTV = (TextView) findViewById(R.id.appid);
        TextView versionCodeTV = (TextView) findViewById(R.id.versionCode);
        TextView versionNameTV = (TextView) findViewById(R.id.versionName);
        TextView packageNameTV = (TextView) findViewById(R.id.packageName);
        TextView buildConfigTV = (TextView) findViewById(R.id.buildConfig);
        TextView resValueTV = (TextView) findViewById(R.id.resValue);
        TextView flavorStringTV = (TextView) findViewById(R.id.flavorString);


        try {
            String pkName = this.getPackageName();
            String versionName = this.getPackageManager().getPackageInfo(
                    pkName, 0).versionName;
            int versionCode = this.getPackageManager()
                    .getPackageInfo(pkName, 0).versionCode;
            versionCodeTV.setText(String.valueOf(versionCode));
            versionNameTV.setText(versionName);
            packageNameTV.setText(pkName);
        } catch (Exception e) {
        }

        buildConfigTV.setText(BuildConfig.API_URL);
        resValueTV.setText(R.string.appname);
        flavorStringTV.setText(R.string.flavor_string);
        flavorStringTV.setBackgroundColor(this.getResources().getColor(R.color.flavor_color));

    }
}
