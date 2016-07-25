package aj.afnan.pic5;


    import android.content.Intent;
    import android.os.Bundle;
    import android.support.design.widget.FloatingActionButton;
    import android.support.v7.app.AppCompatActivity;
    import android.view.View;
    import android.widget.ExpandableListView;
    import android.widget.TextView;

    import java.util.ArrayList;
    import java.util.LinkedHashMap;

    public class TrainingFacility extends AppCompatActivity{

        private LinkedHashMap<String, ExpandableListGroupInfo> subjects = new LinkedHashMap<String, ExpandableListGroupInfo>();
        private ArrayList<ExpandableListGroupInfo> deptList = new ArrayList<ExpandableListGroupInfo>();

        private CustomAdapter listAdapter;
        private ExpandableListView simpleExpandableListView;

        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_training_facility);
            setTitle("المنشأة التدريبية");

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab); //home icon
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent Home = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(Home);
                }
            });

            // add data for displaying in expandable list view
            loadData();
            //get reference of the ExpandableListView
            simpleExpandableListView = (ExpandableListView) findViewById(R.id.simpleExpandableListView);
            // create the adapter by passing your ArrayList data
            listAdapter = new CustomAdapter(TrainingFacility.this , deptList);
            // attach the adapter to the expandable list view
            simpleExpandableListView.setAdapter(listAdapter);
            //expand all the Groups
            // expandAll();




            // setOnChildClickListener listener for child row click
            simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                    //get the group header
                    ExpandableListGroupInfo headerInfo = deptList.get(groupPosition);
                    //get the child info
                    ExpandableListChildInfo detailInfo = headerInfo.getProductList().get(childPosition);
                    //display it or do something with it
                    if (groupPosition == 0) {
                        TextView ForMore = (TextView) v.findViewById(R.id.sequence);
                        ForMore.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
                                String name = "http://www.tvtc.gov.sa/Arabic/Departments/Departments/pt/Orgnazaition/center/Pages/default.aspx";
                                Bundle bundle = new Bundle();
                                bundle.putString("name", name);
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }
                        });
                    }
                    if (groupPosition == 1) {
                        TextView ForMore = (TextView) v.findViewById(R.id.sequence);
                        ForMore.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
                                String name = "http://www.tvtc.gov.sa/Arabic/Departments/Departments/pt/Orgnazaition/ins/Pages/default.aspx";
                                Bundle bundle = new Bundle();
                                bundle.putString("name", name);
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }
                        });
                    }
                    if (groupPosition == 2) {
                        TextView ForMore = (TextView) v.findViewById(R.id.sequence);
                        ForMore.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
                                String name = "http://www.tvtc.gov.sa/Arabic/Departments/Departments/pt/Orgnazaition/high_ins/Pages/default.aspx";
                                Bundle bundle = new Bundle();
                                bundle.putString("name", name);
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }
                        });
                    }

                    return true;
                }
            });
            // setOnGroupClickListener listener for group heading click
            simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                @Override
                public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                    //get the group header
                    ExpandableListGroupInfo headerInfo = deptList.get(groupPosition);
                    //display it or do something with it
                    //  if (groupPosition == 1)
                    // {   Toast.makeText(getBaseContext(), " Header is :: " + headerInfo.getName(),
                    //        Toast.LENGTH_LONG).show();

                    //  }
                    return false;
                }
            });



        }

        //method to expand all groups
        private void expandAll() {
            int count = listAdapter.getGroupCount();
            for (int i = 0; i < count; i++){
                simpleExpandableListView.expandGroup(i);
            }
        }

        //method to collapse all groups
        private void collapseAll() {
            int count = listAdapter.getGroupCount();
            for (int i = 0; i < count; i++){
                simpleExpandableListView.collapseGroup(i);
            }
        }

        //load some initial data into out list
        private void loadData(){

            addProduct("مركز تدريب","المنشأة التي تقدم دورات تطويرية فقط.","للمزيد");

            addProduct("معهد تدريب","المنشأة التي تقدم البرامج التدريبية والدورات التأهيلية والتطويرية.","للمزيد");
            addProduct("معهد تدريب عالي","المنشأة التي تقدم الدبلومات والبرامج التدريبية والدورات التأهيلية والتطويرية.","للمزيد");
        }



        //here we maintain our products in various departments
        private int addProduct(String department, String product,String More){

            int groupPosition = 0;

            //check the hash map if the group already exists
            ExpandableListGroupInfo headerInfo = subjects.get(department);
            //add the group if doesn't exists
            if(headerInfo == null){
                headerInfo = new ExpandableListGroupInfo();
                headerInfo.setName(department);
                subjects.put(department, headerInfo);
                deptList.add(headerInfo);

            }

            //get the children for the group
            ArrayList<ExpandableListChildInfo> productList = headerInfo.getProductList();
            //size of the children list
            int listSize = productList.size();
            //add to the counter
            listSize++;

            //create a new child and add that to the group
            ExpandableListChildInfo detailInfo = new ExpandableListChildInfo();
            detailInfo.setSequence(More);
            detailInfo.setName(product);
            productList.add(detailInfo);
            headerInfo.setProductList(productList);

            //find the group position inside the list
            groupPosition = deptList.indexOf(headerInfo);

            //deptList.indexOf();

            return groupPosition;
        }




    }
