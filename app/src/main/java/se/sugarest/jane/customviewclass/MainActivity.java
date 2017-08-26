package se.sugarest.jane.customviewclass;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private CustomView mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCustomView = (CustomView) findViewById(R.id.customView);
    }

    public void btnPressed(View view) {
        Log.i(TAG, "Text in the circle is: " + mCustomView.getCircleText());
        if (mCustomView.getCircleText() == "Hello") {
            mCustomView.setCircleColor(Color.GREEN);
            mCustomView.setLabelColor(Color.MAGENTA);
            mCustomView.setCircleText("hehe");
        } else {
            mCustomView.setCircleColor(Color.parseColor("#ff0099"));
            mCustomView.setLabelColor(Color.parseColor("#ffff66"));
            mCustomView.setCircleText("Hello");
        }
    }
}
