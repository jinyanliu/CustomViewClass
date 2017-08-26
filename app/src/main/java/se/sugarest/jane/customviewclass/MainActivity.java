package se.sugarest.jane.customviewclass;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CustomView mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCustomView = (CustomView) findViewById(R.id.customView);
    }

    public void btnPressed(View view) {
        // update the View
        mCustomView.setCircleColor(Color.GREEN);
        mCustomView.setLabelColor(Color.MAGENTA);
        mCustomView.setCircleText("hehe");
    }
}
