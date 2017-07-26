package com.miramicodigo.demolitho.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.miramicodigo.demolitho.model.Pokemon;
import com.miramicodigo.demolitho.specs.Detalle;

/**
 *
 * @author Gustavo Lizárraga
 * @date 25-07-17
 *
 */

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Pokemon pokemon = (Pokemon) getIntent().getSerializableExtra("pokemon");

        final ComponentContext context = new ComponentContext(this);

        final Component view = Detalle.create(context)
                .title(pokemon.getTitle())
                .subtitle(pokemon.getSubtitle())
                .image(pokemon.getImage())
                .build();

        setContentView(LithoView.create(context, view));
    }
}
