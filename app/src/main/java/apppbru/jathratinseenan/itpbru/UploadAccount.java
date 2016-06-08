package apppbru.jathratinseenan.itpbru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class UploadAccount extends AppCompatActivity {

    // Explicit
    private TextView inOutTextView, nameTextView;
    private Spinner spinner;
    private EditText editText;
    private String[] loginStrings;
    private int inOutAnInt;
    private String[] inOutStrings = new String[]{"บัญชีบันทึก รายรับ", "บัญชีบันทึก รายจ่าย"};
    private String[] inComeStrings = new String[]{"เงินเดือน", "ล่วงเวลา", "สอนพิเศษ"};
    private String[] outComeStrings = new String[]{"อาหาร", "เดินทาง", "Entertrain", "การศึกษา"};
    private ArrayAdapter<String> stringArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_account);

        // Bind Widget
        inOutTextView = (TextView) findViewById(R.id.textView6);
        nameTextView = (TextView) findViewById(R.id.textView7);
        spinner = (Spinner) findViewById(R.id.spinner);
        editText = (EditText) findViewById(R.id.editText7);

        // Receive Value From Intent
        loginStrings = getIntent().getStringArrayExtra("Login");
        inOutAnInt = getIntent().getIntExtra("InOut", 0);

        // Show View
        inOutTextView.setText(inOutStrings[inOutAnInt]);
        nameTextView.setText(loginStrings[1] + "  " + loginStrings[2]);

        // Create Spininer
        createSpinner();

    } // Main Method

    private void createSpinner() {

        switch (inOutAnInt) {

            case 0:
                stringArrayAdapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, inComeStrings);
                break;
            case 1:
                stringArrayAdapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, outComeStrings);
                break;

        } // switch

        spinner.setAdapter(stringArrayAdapter);

    } // Create Spinner

    public void clickUpload(View view) {

    } // ClickUpload

    public void clickCancel(View view) {
        finish();
    } // ClickCancel

} // Main Class
