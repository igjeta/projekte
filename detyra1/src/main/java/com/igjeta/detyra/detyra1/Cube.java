package com.igjeta.detyra.detyra1;

import org.springframework.stereotype.Component;

@Component
public class Cube implements Shape3D{
    private ShapeFormEnun type=ShapeFormEnun.CUBE;
    @Override
    public boolean isShapeTypeSupported(String shapeType) {
        return type.equals(ShapeFormEnun.fromValue(shapeType));
    }

    @Override
    public Double calculateArea3D(Double... params) {
        return 6*(params[0]*params[0]);
    }

    @Override
    public Double calculateVolume3D(Double... params) {
        return params[0]*params[0]*params[0];
    }
}
