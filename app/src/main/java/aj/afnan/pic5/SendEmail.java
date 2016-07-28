package aj.afnan.pic5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SendEmail extends AppCompatActivity {

    Button buttonSend;
    String textTo="gdpci@tvtc.gov.sa";
    EditText textMessage;
    EditText ID;
    EditText phone ;
    EditText Name ;
    boolean blank=false;
    String select;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
        setTitle("راسلنا");




        buttonSend = (Button) findViewById(R.id.buttonSend);
        ID = (EditText) findViewById(R.id.editTextID);
        textMessage =  (EditText) findViewById(R.id.editTextMessage);
        phone = (EditText) findViewById(R.id.editTextPhone);
        Name = (EditText) findViewById(R.id.editTextName);
        final Spinner Category = (Spinner) findViewById(R.id.spinnerCategory);
        final List<String> CategoryArray = new ArrayList<String>();
        CategoryArray.add("اختر");
        CategoryArray.add("اقتراح");
        CategoryArray.add("شكوى");
        CategoryArray.add("استفسار");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item , CategoryArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Category.setAdapter(adapter);
        Category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                select= CategoryArray.get(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        buttonSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                blank = false;
                String to = textTo;
                String subject = select; //textSubject.getText().toString();
                String message = "الاسم: " + Name.getText().toString() + "\n رقم الهوية: " + ID.getText().toString() + "\n رقم الجوال: " + phone.getText().toString() + "\n  الرسالة:\n " + textMessage.getText().toString() + " \n  ";

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
                //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                if (Name.getText().length() == 0) {
                    Name.setError("حقل مطلوب");
                    blank = true;
                }
                if (textMessage.getText().length() == 0) {
                    textMessage.setError("حقل مطلوب");
                    blank = true;
                }
                if (ID.getText().length() == 0) {
                    ID.setError("حقل مطلوب");
                    blank = true;
                }
                if (phone.getText().length() == 0) {
                    phone.setError("حقل مطلوب");
                    blank = true;
                }
                if (phone.getText().length() < 10 && phone.getText().length() > 0 ) {
                    phone.setError("ادخل ١٠ آرقام");
                    blank = true;
                }
                if (ID.getText().length() < 10 && ID.getText().length() > 0 ) {
                    ID.setError("ادخل ١٠ آرقام");
                    blank = true;
                }
                if (select.equals("اختر")){
                    blank = true;
                    Toast.makeText(getApplicationContext(), "اختر تصنيف", Toast.LENGTH_LONG).show();
                }

                if ( (!phone.getText().toString().isEmpty())&&(phone.getText().toString().charAt(1) != '5' || phone.getText().toString().charAt(0) != '0' )) {
                    if ( phone.getText().toString().charAt(0) != '٠' || phone.getText().toString().charAt(1) != '٥' )
                    phone.setError("ادخل رقم جوال صحيح");
                    blank = true;
                }
                if(blank){
                    Toast.makeText(getApplicationContext(), "اكمل البيانات" , Toast.LENGTH_LONG).show();
                }

                if (!blank) {
                    startActivity(Intent.createChooser(email, "Choose an Email client :"));
                }







            }
        });
    }
}





