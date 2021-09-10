package com.somepackege.controller;

import com.somepackege.exception.BadRequestException;
import com.somepackege.pojo.*;
import com.somepackege.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ControllerAPI.AREA_CONTROLLER + ControllerAPI.VERSION_1_0)
@Slf4j
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping(value =  ControllerAPI.AREA_CONTROLLER_CIRCLE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> calculate(Circle figure) throws BadRequestException {
        return ResponseEntity.ok(new Result(areaService.calculate(figure)));
    }

    @GetMapping(value =  ControllerAPI.AREA_CONTROLLER_RECTANGLE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> calculate(Rectangle figure) throws BadRequestException {
        return ResponseEntity.ok(new Result(areaService.calculate(figure)));
    }

    @GetMapping(value =  ControllerAPI.AREA_CONTROLLER_TRIANGLE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> calculate(Triangle figure) throws BadRequestException {
        return ResponseEntity.ok(new Result(areaService.calculate(figure)));
    }

    @GetMapping(value =  ControllerAPI.AREA_CONTROLLER_SQUARE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> calculate(Square figure) throws BadRequestException {
        return ResponseEntity.ok(new Result(areaService.calculate(figure)));
    }
}
