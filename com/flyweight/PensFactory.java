package com.flyweight;

import java.util.HashMap;
import java.util.Map;

public class PensFactory {

    public static Map<String, Pen> pensMap = new HashMap<String, Pen>();

    public static Pen getThickPen(String color) {
        String key = "THICK-" + color;
        Pen pen = pensMap.get(key);

        if (pen != null) {
            return pen;
        } else {
            pen = new ThickPen();
            pen.setColor(color);
            pensMap.put(key, pen);
        }
        return pen;
    }

    public static Pen getThinPen(String color) {
        String key = "THIN-" + color ;
        Pen pen = pensMap.get(key);

        if (pen != null) {
            return pen;
        } else {
            pen = new ThinPen();
            pen.setColor(color);
            pensMap.put(key, pen);
        }
        return pen;
    }

    public static Pen getMediumPen(String color) {
        String key = "MEDIUM-" + color ;
        Pen pen = pensMap.get(key);

        if (pen != null) {
            return pen;
        } else {
            pen = new MediumPen();
            pen.setColor(color);
            pensMap.put(key, pen);
        }
        return pen;
    }
}
