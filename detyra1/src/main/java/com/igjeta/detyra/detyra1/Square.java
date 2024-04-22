package com.igjeta.detyra.detyra1;

import org.springframework.stereotype.Component;

@Component
public class Square implements Shape2D{
    private ShapeFormEnun type=ShapeFormEnun.SQUARE;
    @Override
    public boolean isShapeTypeSupported(String shapeType) {
        return type.equals(ShapeFormEnun.fromValue(shapeType));
    }

    @Override
    public Double calculatePerimeter2D(Double... params) {
        return 4*params[0];
    }

    @Override
    public Double calculateArea2D(Double... params) {
        return params[0]*params[0];
    }
}
