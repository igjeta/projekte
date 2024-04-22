package com.igjeta.detyra.detyra1;

import org.springframework.stereotype.Component;

@Component
public class Cuboid implements Shape3D{
    private ShapeFormEnun type=ShapeFormEnun.CUBOID;
    @Override
    public boolean isShapeTypeSupported(String shapeType) {
        return type.equals(ShapeFormEnun.fromValue(shapeType));
    }

    @Override
    public Double calculateArea3D(Double... params) {
        return 2*( (params[0]* params[2]) + (params[1] * params[2]) + (params[0] *params[1]));
    }

    @Override
    public Double calculateVolume3D(Double... params) {
        return params[0]*params[1]*params[2];
    }
}
