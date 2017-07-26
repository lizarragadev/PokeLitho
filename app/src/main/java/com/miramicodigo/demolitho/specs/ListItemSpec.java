package com.miramicodigo.demolitho.specs;

import android.content.Intent;
import android.graphics.Typeface;
import android.widget.ImageView;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Image;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;
import com.miramicodigo.demolitho.model.Pokemon;
import com.miramicodigo.demolitho.ui.DetalleActivity;

import static com.facebook.yoga.YogaEdge.ALL;

/**
 *
 * @author Gustavo Lizárraga
 * @date 25-07-17
 *
 */

@LayoutSpec
public class ListItemSpec {

    @OnCreateLayout
    static ComponentLayout onCreateLayout(ComponentContext c,
                                          @Prop int backgroundColor,
                                          @Prop int textColor,
                                          @Prop Pokemon pokemon) {
        return Row.create(c)
                .paddingDip(ALL, 10)
                .alignItems(YogaAlign.CENTER)
                .backgroundColor(backgroundColor)
                .clickHandler(ListItem.onClick(c))
                .child(
                        Image.create(c)
                                .drawableRes(pokemon.getImage())
                                .scaleType(ImageView.ScaleType.CENTER_CROP)
                                .build()
                )
                .child(
                        Column.create(c)
                                .paddingDip(ALL, 10)
                                .alignItems(YogaAlign.FLEX_START)
                                .child(
                                        Text.create(c)
                                                .text(pokemon.getTitle())
                                                .textSizeSp(30)
                                                .textColor(textColor)
                                                .textStyle(Typeface.BOLD))
                                .child(
                                        Text.create(c)
                                                .text(pokemon.getSubtitle())
                                                .textSizeSp(20)
                                                .textColor(textColor))
                )
                .build();
    }

    @OnEvent(ClickEvent.class)
    static void onClick(ComponentContext c, @Prop Pokemon pokemon) {
        Intent intent = new Intent(c, DetalleActivity.class);
        intent.putExtra("pokemon", pokemon);
        c.startActivity(intent);
    }
}
