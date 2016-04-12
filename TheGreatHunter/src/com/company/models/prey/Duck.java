package com.company.models.prey;

import com.company.graphics.Assets;

public class Duck extends Bird {
    public Duck(int x, int y) {
        super(x, y, Assets.duck, 64, 65, 20, 1.1);
    }
}
