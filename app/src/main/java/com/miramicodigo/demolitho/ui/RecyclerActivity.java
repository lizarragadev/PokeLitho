package com.miramicodigo.demolitho.ui;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.OrientationHelper;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentInfo;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.LinearLayoutInfo;
import com.facebook.litho.widget.Recycler;
import com.facebook.litho.widget.RecyclerBinder;
import com.miramicodigo.demolitho.R;
import com.miramicodigo.demolitho.model.Pokemon;
import com.miramicodigo.demolitho.specs.ListItem;

/**
 *
 * @author Gustavo Lizárraga
 * @date 25-07-17
 *
 */

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ComponentContext context = new ComponentContext(this);

        final RecyclerBinder recyclerBinder = new RecyclerBinder(
                context,
                new LinearLayoutInfo(this, OrientationHelper.VERTICAL, false));

        final Component component = Recycler.create(context)
                .binder(recyclerBinder)
                .build();

        addItems(recyclerBinder, context);

        setContentView(LithoView.create(context, component));
    }

    private void addItems(RecyclerBinder recyclerBinder, ComponentContext context) {
        String[] title = getResources().getStringArray(R.array.nombre);
        String[] subtitle = getResources().getStringArray(R.array.poder);
        TypedArray images = getResources().obtainTypedArray(R.array.image);

        for (int i = 0; i < 49; i++) {
            ComponentInfo.Builder componentInfoBuilder = ComponentInfo.create();
            Pokemon pokemon = new Pokemon(title[i], subtitle[i], images.getResourceId(i, -1));

            componentInfoBuilder.component(
                    ListItem.create(context)
                            .backgroundColor(i % 2 == 0 ? Color.WHITE : ContextCompat.getColor(context, R.color.colorPrimary))
                            .textColor(i % 2 == 0 ? Color.DKGRAY : Color.WHITE)
                            .pokemon(pokemon)
                            .build());
            recyclerBinder.insertItemAt(i, componentInfoBuilder.build());
        }
    }
}
