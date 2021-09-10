package com.somepackege.service;

import com.somepackege.pojo.Circle;
import com.somepackege.pojo.Rectangle;
import com.somepackege.pojo.Square;
import com.somepackege.pojo.Triangle;
import org.springframework.stereotype.Service;

@Service
public class AreaService {

    public double calculate(Square figure) {
        return Math.pow(figure.getSide(), 2);
    }

    public double calculate(Triangle figure) {
        return 0.5 * figure.getBase() * figure.getHeight();
    }

    public double calculate(Rectangle figure) {
        return figure.getLength() * figure.getWidth();
    }

    public double calculate(Circle figure) {
        return Math.PI * Math.pow(figure.getRadius(), 2);
    }
}
