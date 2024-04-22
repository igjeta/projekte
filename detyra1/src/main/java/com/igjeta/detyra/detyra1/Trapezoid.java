package com.igjeta.detyra.detyra1;

import org.springframework.stereotype.Component;

@Component
public class Trapezoid implements Shape2D{
    private ShapeFormEnun type=ShapeFormEnun.TRAPEZOID;
    @Override
    public boolean isShapeTypeSupported(String shapeType) {
        return type.equals(ShapeFormEnun.fromValue(shapeType));
    }

    @Override
    public Double calculatePerimeter2D(Double... params) {
        return params[0]+params[1]+params[2]+params[3];
    }

    @Override
    public Double calculateArea2D(Double... params) {
        return ((params[0]+params[1])*params[2])/2;
    }
}
