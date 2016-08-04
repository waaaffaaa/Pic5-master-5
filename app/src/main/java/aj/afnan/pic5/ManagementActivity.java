package aj.afnan.pic5;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ManagementActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] Option_names;
    TypedArray Icon_id;
    TypedArray Move_id;


    List<RowItem> rowItems;
    ListView mylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);

       // getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
      // getSupportActionBar().setCustomView(R.layout.action_bar);
        //getSupportActionBar().setTitle("عن الادارة");


        setTitle("عن الإدارة"); //title of activity

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab); //home icon
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Home = new Intent(getApplicationContext(), MainActivity.class);
                Home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(Home);


            }
        });

        rowItems = new ArrayList<RowItem>(); //to display content of every row in ListView

        Option_names = getResources().getStringArray(R.array.Option_Name); //to take name of button from array in string.xml
        Icon_id = getResources().obtainTypedArray(R.array.OptionIcon);//to take icon of button from array in string.xml
        Move_id = getResources().obtainTypedArray(R.array.MoveIcon);//to take arrow icon from array in string.xml


        for (int i = 0; i < 5; i++) {
            RowItem item = new RowItem(Option_names[i], Icon_id.getResourceId(i, -1), Move_id.getResourceId(i, -1));
            rowItems.add(item); //to save every row item in array
        }

        mylistview = (ListView) findViewById(R.id.listViewMangment); //to create list view
        CustomAdapter1 adapter = new CustomAdapter1(this, rowItems);
        mylistview.setAdapter(adapter);

        mylistview.setOnItemClickListener(this);

    }
        @Override
        public void onItemClick (AdapterView < ? > parent, View view,int position, long id){//move to new activity

            if (position == 0) {
                Intent AboutUs = new Intent(getApplicationContext(), AboutUs.class);
                startActivity(AboutUs);
            }
            if (position == 1) {
                Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
                String name = "http://www.tvtc.gov.sa/Arabic/Departments/Departments/pt/AboutDepartment/Pages/Outemployeetel.aspx";
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            if (position == 2) {
                Intent AboutUs = new Intent(getApplicationContext(), NoAccount.class);
                startActivity(AboutUs);
            }
            if (position == 3) {
                Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
                String name = "http://www.tvtc.gov.sa/Arabic/Departments/Departments/pt/Pages/default.aspx";
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            if (position == 4) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/الادارة+العامة+للتدريب+الأهلي%E2%80%AD/@24.7155432,46.7824191,15z/data=!4m12!1m6!3m5!1s0x0:0xdc93307c8a370f8!2z2KfZhNin2K_Yp9ix2Kkg2KfZhNi52KfZhdipINmE2YTYqtiv2LHZitioINin2YTYo9mH2YTZig!8m2!3d24.7155432!4d46.7824191!3m4!1s0x0:0xdc93307c8a370f8!8m2!3d24.7155432!4d46.7824191"));
                startActivity(intent);

            }

        }



    }



