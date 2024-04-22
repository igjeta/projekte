package com.igjeta.detyra.detyra1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShapeServiceImpl implements ShapeService{

    @Autowired
    private List<Shape2D> shape2D;

    @Autowired
    private List<Shape3D> shape3D;
    @Override
    public Double calculateArea2D(String shapeForm, Double... params) {
        return shape2D.stream()
                .filter(os -> os.isShapeTypeSupported(shapeForm))
                .findFirst().orElseThrow(()-> new RuntimeException("Shape form not supported"))
                .calculateArea2D(params);
    }

    @Override
    public Double calculatePerimeter2D(String shapeForm, Double... params) {
        return shape2D.stream()
                .filter(os -> os.isShapeTypeSupported(shapeForm))
                .findFirst().orElseThrow(()-> new RuntimeException("Shape form not supported"))
                .calculatePerimeter2D(params);
    }

    @Override
    public Double calculateArea3D(String shapeForm, Double... params) {
        return shape3D.stream()
                .filter(os -> os.isShapeTypeSupported(shapeForm))
                .findFirst().orElseThrow(()-> new RuntimeException("Shape form not supported"))
                .calculateArea3D(params);
    }

    @Override
    public Double calculateVolume3D(String shapeForm, Double... params) {
        return shape3D.stream()
                .filter(os -> os.isShapeTypeSupported(shapeForm))
                .findFirst().orElseThrow(()-> new RuntimeException("Shape form not supported"))
                .calculateVolume3D(params);
    }
}
