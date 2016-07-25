
package aj.afnan.pic5;

        import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        Intent intent = new Intent(getApplicationContext(), PDFView.class);
        //String name = "http://docs.google.com/gview?embedded=http://www.tvtc.gov.sa/Arabic/Departments/Departments/pt/InformationCenter/Calender/Documents/trainingcalender_semester-quarter_1438-1437.pdf";
        //  String name= "https://docs.google.com/gview?embedded=true&url=http://tvtc.gov.sa/Arabic/Departments/Departments/pt/InformationCenter/Calender/Documents/trainingcalender_semester-quarter_1438-1437.pdf";

        String name="http://tvtc.gov.sa/Arabic/Departments/Departments/pt/InformationCenter/Calender/Documents/trainingcalender_semester-quarter_1438-1437.pdf";
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        intent.putExtras(bundle);
        startActivity(intent);



    }
}