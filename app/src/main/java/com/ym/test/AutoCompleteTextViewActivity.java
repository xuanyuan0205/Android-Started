package com.ym.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class AutoCompleteTextViewActivity extends AppCompatActivity {

    private static final String[] data = new String[]{
            "小猪猪", "小狗狗", "小鸡鸡", "小猫猫", "小咪咪"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);
        AutoCompleteTextView atv_content = (AutoCompleteTextView) findViewById(R.id.atv_content);
        MultiAutoCompleteTextView matv_content = (MultiAutoCompleteTextView) findViewById(R.id.matv_content);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AutoCompleteTextViewActivity.
                this, android.R.layout.simple_dropdown_item_1line, data);
        atv_content.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, data);
        matv_content.setAdapter(adapter);
//        是为其设置分隔符
        matv_content.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}
