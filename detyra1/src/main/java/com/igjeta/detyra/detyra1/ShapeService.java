package com.igjeta.detyra.detyra1;

public interface ShapeService{
    Double calculateArea2D(String shapeForm, Double ...params);
    Double calculatePerimeter2D(String shapeForm, Double ...params);
    Double calculateArea3D(String shapeForm, Double ...params);
    Double calculateVolume3D(String shapeForm, Double ...params);
}
