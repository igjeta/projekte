package com.igjeta.detyra.detyra1;

import org.springframework.stereotype.Component;

@Component
public class Cylinder implements Shape3D{
    private ShapeFormEnun type=ShapeFormEnun.CYLINDER;
    @Override
    public boolean isShapeTypeSupported(String shapeType) {
        return type.equals(ShapeFormEnun.fromValue(shapeType));
    }

    @Override
    public Double calculateArea3D(Double... params) {
        return 2*Math.PI * params[0]*(params[0]+ params[1]);
    }

    @Override
    public Double calculateVolume3D(Double... params) {
        return Math.PI * params[0] * params[0] * params[1];
    }
}
