package com.igjeta.detyra.detyra1;

import org.springframework.stereotype.Component;

@Component
public class Rectangular implements Shape2D{
    private ShapeFormEnun type=ShapeFormEnun.RECTANGULAR;
    @Override
    public boolean isShapeTypeSupported(String shapeType) {
        return type.equals(ShapeFormEnun.fromValue(shapeType));
    }

    @Override
    public Double calculatePerimeter2D(Double... params) {
        return (2*params[0])+(2*params[1]);
    }

    @Override
    public Double calculateArea2D(Double... params) {
        return (params[0]*params[1]);
    }
}
