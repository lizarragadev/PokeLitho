package com.miramicodigo.demolitho.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.Text;

/**
 *
 * @author Gustavo Lizárraga
 * @date 25-07-17
 *
 */

public class HelloWorldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ComponentContext context = new ComponentContext(this);

        final LithoView lithoView = LithoView.create(
                this,
                Text.create(context)
                    .text("DroidLatino")
                    .textSizeDip(40)
                    .textColor(Color.BLUE)
                    .build()
        );
        setContentView(lithoView);
    }
}
