package kr.or.womanup.nambu.yjh.activitytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.edt_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        //익명 클래스로 진행
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SubActivity.class);
               /* intent.putExtra("num1",123);
                intent.putExtra("num2",456);*/

                String input_text = editText.getText().toString();
                intent.putExtra("text",input_text);
                startActivityForResult(intent,101); //request code :
                editText.setText("");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { //받아온 결과값 처리하기 위한 오버라이드 함수
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101) {
            if(resultCode == Activity.RESULT_OK){
               /* int sum = data.getIntExtra("sum",0);
                textView.setText("Result = " + sum);*/
                String result = data.getStringExtra("text");
                textView.setText(result);

            }

        }
    }
}
