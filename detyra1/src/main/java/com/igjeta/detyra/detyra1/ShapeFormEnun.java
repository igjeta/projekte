package com.igjeta.detyra.detyra1;

import java.util.Arrays;

public enum ShapeFormEnun {
    TRIANGULAR("triangular"), SQUARE("square"), RECTANGULAR("rectangular"),
    TRAPEZOID("trapezoid"),RHOMBUS("rhombus"),CUBE("cube"),CUBOID("cuboid"),CYLINDER("cylinder");
    String shapeForm;

    ShapeFormEnun(String shapeForm){
        this.shapeForm=shapeForm;
    }

    public static ShapeFormEnun fromValue(String val){
        return Arrays.stream(ShapeFormEnun.values())
                .filter(o -> o.shapeForm.equals(val))
                .findFirst().orElseThrow(() -> new RuntimeException("Value for enum not found"));
    }
}
