package kr.or.womanup.nambu.yjh.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SubActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent intent = getIntent();
      /*  int num1 = intent.getIntExtra("num1",0);
        int num2 = intent.getIntExtra("num2",0);
        int sum = num1 + num2;*/
        String text = intent.getStringExtra("text");
        editText = findViewById(R.id.edt_sub);
        textView = findViewById(R.id.textView3);
        textView.setText(text);


        button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(); //내부 내용이 필요없다.
                /*intent1.putExtra("sum",sum);*/
                String resultText = editText.getText().toString();
                intent1.putExtra("text",resultText);
                setResult(Activity.RESULT_OK,intent1);
                finish();
            }
        });




    }
}