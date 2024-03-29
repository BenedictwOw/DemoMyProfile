package sg.edu.rp.c346.demomyprofile;

import android.content.SharedPreferences;
import android.os.Trace;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText etName;
EditText etGPA;
RadioGroup rgGender;
Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName =findViewById(R.id.editTextName);
        etGPA =findViewById(R.id.editTextGPA);
        rgGender=findViewById(R.id.Radio_Group);
        btnSave=findViewById(R.id.buttonSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName  = etName.getText().toString();
                float fltGPA  = Float.parseFloat(etGPA.getText().toString());
                int intGenderId  = rgGender.getCheckedRadioButtonId();

                //Step 1b: Obtain an instance of the SharedPreferences
                SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

                //Step 1c: Obtain an instance of the SharedPreferences Editor for update later
                SharedPreferences.Editor prefEdit = prefs.edit();

                //Step 1d: Add the key-value pair
                prefEdit.putString("name",strName);
                prefEdit.putFloat("gpa", fltGPA);
                prefEdit.putInt("genderID",intGenderId);

                //Step 1e: Call commit() to save the changes into SharedPreferences
                prefEdit.commit();



            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Code for namee
        //Step 1a: Get the user input from the EditText and store it in a variable
        String strName = etName.getText().toString();
        float fltGPA = Float.parseFloat(etGPA.getText().toString());
        int intGenderId = rgGender.getCheckedRadioButtonId();

        //Step 1b: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Step 1c: Obtain an instance of the SharedPreferences Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        //Step 1d: Add the key-value pair
        prefEdit.putString("name", "Ben");
        prefEdit.putFloat("gpa", (float) 4.0);
        prefEdit.putInt("genderID", intGenderId);
        //Step 1e: Call commit() to save the changes into SharedPreferences
        prefEdit.commit();


    }

    @Override
    protected void onResume() {
        super.onResume();

        //Step 2a:Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Step 2b:Retrieve the saved data from the SharedPreferences object
        String msg = prefs.getString("name","No name");
        Float msg2 = prefs.getFloat("gpa",(float) 0.0);
        int intGenderId = prefs.getInt("genderID",R.id.radioButtonGenderMale);
        //Step 2c:Update the UI element with the value
        etName.setText(msg);
        etGPA.setText(msg2+"");
        rgGender.check(intGenderId);

    }

}
