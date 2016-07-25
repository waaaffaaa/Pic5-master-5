package aj.afnan.pic5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().hide();

        Button Guides = ( Button ) findViewById(R.id.ButtonGuides);
        Guides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Guides = new Intent(getApplicationContext(), GuidesActivity.class);
                startActivity(Guides);
            }
        });



        Button Manegment = ( Button ) findViewById(R.id.ButtonManagement);
        Manegment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Manegment = new Intent(getApplicationContext(), ManagementActivity.class)  ;
                startActivity(Manegment);
            }
        });

        Button TrainingFacility = ( Button ) findViewById(R.id.ButtonFacility);
        TrainingFacility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TrainingFacility = new Intent(getApplicationContext(), TrainingFacility.class)  ;
                startActivity(TrainingFacility);
            }
        });


        Button TrainingPrograms = ( Button ) findViewById(R.id.ButtonPrograms);
        TrainingPrograms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TrainingPrograms = new Intent(getApplicationContext(), TrainingPrograms.class)  ;
                startActivity(TrainingPrograms);
            }
        });

        Button Exams = ( Button ) findViewById(R.id.ButtonExams);
        Exams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Exams = new Intent(getApplicationContext(), Exams.class)  ;
                startActivity(Exams);
            }
        });

        Button Contactus = ( Button ) findViewById(R.id.ButtonContactUs);
        Contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Contactus  = new Intent(getApplicationContext(), ContactUs.class)  ;
                startActivity(Contactus );
            }
        });

        Button Forms = ( Button ) findViewById(R.id.ButtonForms);
        Forms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Forms  = new Intent(getApplicationContext(), Forms.class)  ;
                startActivity(Forms );
            }
        });

        Button AboutApp = ( Button ) findViewById(R.id.ButtonAboutApp);
        AboutApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AboutApp  = new Intent(getApplicationContext(), AboutApp.class)  ;
                startActivity(AboutApp );
            }
        });


        Button Calendar = ( Button ) findViewById(R.id.ButtonCalender);
        Calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Calendar  = new Intent(getApplicationContext(), Calendar.class)  ;
                startActivity(Calendar );
            }
        });


        TextView Web = ( TextView ) findViewById(R.id.textViewWeb);
        Web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tvtc.gov.sa/Arabic/Departments/Departments/pt/Pages/default.aspx"));
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
