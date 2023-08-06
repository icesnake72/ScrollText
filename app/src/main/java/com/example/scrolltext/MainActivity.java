package com.example.scrolltext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private final String APIKEY = "739904b4b49c4cd1b425a7dc29361092";
    private EditText editSave;

    private Button clearButton;
    private Button dataListButton;

    private final String spValueText = "SharedPreference_Data";
    private final String SP_SAVE_DATA = "SAVED_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LinearLayout linearLayout = new LinearLayout(this);
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//
//        TextView myText = new TextView(this);
//        myText.setText("안녕하세요, 안드로이드 프로그램입니다.");
//        linearLayout.addView(myText);
//
//        setContentView(linearLayout);

        SharedPreferences sp = getSharedPreferences(spValueText, Context.MODE_PRIVATE);
        
        // 로그인 상태 확인
        boolean isLogged = sp.getBoolean("isLogged", false);
        if (!isLogged) {
            // 로그인되어 있지 않으면 로그인 화면으로 이동
            startLoginActivity();
        }


        // SharedPreference 란?
        editSave = findViewById(R.id.edit_save);
        


        // spValueText를 이용한 SharedPreferences 객체를 얻어온다.
        /*
        * Context.MODE_PRIVATE: 현재 앱에서만 SharedPreferences 파일에 접근할 수 있도록 설정합니다.
            Context.MODE_WORLD_READABLE: 다른 앱에서도 SharedPreferences 파일을 읽을 수 있도록 설정합니다. (이 상수는 안드로이드 4.2 버전 이후로 사용하지 않도록 권장됩니다.)
            Context.MODE_WORLD_WRITEABLE: 다른 앱에서도 SharedPreferences 파일을 수정할 수 있도록 설정합니다. (이 상수는 안드로이드 4.2 버전 이후로 사용하지 않도록 권장됩니다.)
            Context.MODE_MULTI_PROCESS: 이전에는 다중 프로세스에서 SharedPreferences를 공유하는 데 사용되었습니다. 하지만 현재는 사용되지 않으며, SharedPreferencesCompat 클래스를 사용하는 것이 권장됩니다.
            Context.MODE_APPEND: 이미 존재하는 SharedPreferences 파일을 덮어쓰지 않고 기존 데이터에 이어서 추가합니다.
            Context.MODE_ENABLE_WRITE_AHEAD_LOGGING: SQLite 데이터베이스에 대해 Write-Ahead Logging (WAL) 모드를 사용합니다.
            일반적으로 대부분의 경우에는 Context.MODE_PRIVATE를 사용하여 현재 앱에서만 SharedPreferences를 접근하고 관리하는 것이 좋습니다. 다른 앱과 데이터를 공유해야 하는 경우에는 ContentProvider 또는 다른 데이터 공유 방법을 고려해야 합니다.
        */
        
        String loadedValue = sp.getString(SP_SAVE_DATA, "");
        editSave.setText(loadedValue);

        clearButton = findViewById(R.id.btnClear);
        clearButton.setOnClickListener(this::onClearButtonClick);

        dataListButton = findViewById(R.id.btnDataList);
        dataListButton.setOnClickListener(this::onDataListButtonClick);
    }

    private void startLoginActivity() {

        Intent intent = new Intent(MainActivity.this, OtherActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sp = getSharedPreferences(spValueText, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String willSaveValue = String.valueOf(editSave.getText());
        editor.putString(SP_SAVE_DATA, willSaveValue);
        editor.commit();
    }

    private void onClearButtonClick(View view)
    {
        SharedPreferences sp = getSharedPreferences(spValueText, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();

        Toast toast = Toast.makeText(getApplicationContext(), "초기화되었습니다", Toast.LENGTH_SHORT);
        toast.show();
    }

    private void onDataListButtonClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, DataListActivity.class);
        startActivity(intent);
    }


}