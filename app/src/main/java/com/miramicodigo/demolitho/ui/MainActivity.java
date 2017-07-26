package com.miramicodigo.demolitho.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.miramicodigo.demolitho.R;

/**
 *
 * @author Gustavo Lizárraga
 * @date 25-07-17
 *
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnHelloWorld;
    private Button btnRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    public void initUI() {
        btnHelloWorld = (Button) findViewById(R.id.btnHelloWorld);
        btnRecycler = (Button) findViewById(R.id.btnRecycler);
        
        btnHelloWorld.setOnClickListener(this);
        btnRecycler.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btnHelloWorld:
                intent = new Intent(getApplicationContext(), HelloWorldActivity.class);
                break;
            case R.id.btnRecycler:
                intent = new Intent(getApplicationContext(), RecyclerActivity.class);
                break;
        }
        startActivity(intent);
    }
}
