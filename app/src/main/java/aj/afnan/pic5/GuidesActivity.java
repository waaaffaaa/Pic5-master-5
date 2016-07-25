package aj.afnan.pic5;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


    public class GuidesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

        String[] Option_names;
        TypedArray Move_id;


        List<RowNoPic> rowItems;
        ListView mylistview;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_guides);
            setTitle("الأدلة واللوائح");

            // getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            // getSupportActionBar().setCustomView(R.layout.action_bar);

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab); //home icon
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent Home = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(Home);
                }
            });

            rowItems = new ArrayList<RowNoPic>(); //to display content of every row in ListView

            Option_names = getResources().getStringArray(R.array.Option_Name_Guids); //to take name of button from array in string.xml
            Move_id = getResources().obtainTypedArray(R.array.MoveIcon);//to take arrow icon from array in string.xml


            for (int i = 0; i < 5; i++) {
                RowNoPic item = new RowNoPic(Option_names[i], Move_id.getResourceId(i, -1));
                rowItems.add(item); //to save every row item in array
            }

            mylistview = (ListView) findViewById(R.id.listViewMangment); //to create list view
            CustomAdapter2 adapter = new CustomAdapter2(this, rowItems);
            mylistview.setAdapter(adapter);

            mylistview.setOnItemClickListener(this);

        }
        @Override
        public void onItemClick (AdapterView < ? > parent, View view,int position, long id){//move to new activity

            if (position == 0) {
                // Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("http://tvtc.gov.sa/Arabic/Departments/Departments/pt/InformationCenter/ReportsAndGuides/Documents/training_guids.pdf"));
                Intent intent = new Intent(getApplicationContext(), PDFView.class);
                String name = "http://docs.google.com/gview?embedded=http://www.tvtc.gov.sa/Arabic/Departments/Departments/pt/InformationCenter/Files/Documents/ShortGraduate.pdf";
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                intent.putExtras(bundle);
                startActivity(intent);

                //  Intent i = new Intent(getApplicationContext(), PDFView.class);
                startActivity(intent);


            }
            if (position == 1) {

                Intent intent = new Intent(getApplicationContext(), PDFView.class);
                String name = "http://tvtc.gov.sa/Arabic/Departments/Departments/pt/MediaCenter/Memos/Documents/new_rule1.pdf";
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                intent.putExtras(bundle);
                startActivity(intent);

            }
            if (position == 2) {
                Intent intent = new Intent(getApplicationContext(), PDFView.class);
                String name = "http://tvtc.gov.sa/Arabic/Departments/Departments/pt/InformationCenter/ReportsAndGuides/Documents/new_rule2.pdf";
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            if (position == 3) {
                Intent intent = new Intent(getApplicationContext(), PDFView.class);
                // Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse( "https://docs.google.com/gview?embedded=true&url=http://tvtc.gov.sa/Arabic/Departments/Departments/pt/InformationCenter/ReportsAndGuides/Documents/pro_cer.pdf"));
                String name = "http://tvtc.gov.sa/Arabic/Departments/Departments/pt/InformationCenter/ReportsAndGuides/Documents/pro_cer.pdf";
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            if (position == 4) {
                Intent intent = new Intent(getApplicationContext(), PDFView.class);
                String name ="http://tvtc.gov.sa/Arabic/Departments/Departments/pt/prof_cer/Documents/rulesofproftranining.pdf";
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                intent.putExtras(bundle);
                startActivity(intent);
            }

        }


    }



