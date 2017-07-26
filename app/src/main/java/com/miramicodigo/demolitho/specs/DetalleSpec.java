package com.miramicodigo.demolitho.specs;

import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.ImageView;

import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Image;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;

import static com.facebook.yoga.YogaEdge.ALL;

/**
 *
 * @author Gustavo Lizárraga
 * @date 25-07-17
 *
 */

@LayoutSpec
public class DetalleSpec {

    @OnCreateLayout
    static ComponentLayout onCreateLayout(ComponentContext c,
                                          @Prop String title,
                                          @Prop String subtitle,
                                          @Prop int image) {
        return Column.create(c)
                .paddingDip(ALL, 20)
                .alignItems(YogaAlign.CENTER)
                .backgroundColor(Color.WHITE)
                .clickHandler(ListItem.onClick(c))
                .child(
                        Image.create(c)
                                .drawableRes(image)
                                .scaleType(ImageView.ScaleType.CENTER_CROP)
                                .build()
                )
                .child(
                        Text.create(c)
                                .text(title)
                                .textSizeSp(50)
                                .textColor(Color.DKGRAY)
                                .textStyle(Typeface.BOLD))
                .child(
                        Text.create(c)
                                .text(subtitle)
                                .textSizeSp(30)
                                .textColor(Color.LTGRAY))
                .build();
    }
}
