package aj.afnan.pic5;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NoAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_account);
        setTitle("رقم حساب الادارة");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab); //home icon
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Home);
            }
        });

        TouchImageView img = new TouchImageView(this);
        img.setImageResource(R.drawable.account);
        img.setMaxZoom(4f);
        setContentView(img);

    }
}
