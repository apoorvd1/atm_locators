package com.indorse.atm.locations.controller;

import com.indorse.atm.locations.model.Locations;
import com.indorse.atm.locations.service.LocationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api")
public class AtmLocationsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AtmLocationsController.class);

    private LocationService locationService;

    @Autowired
    public AtmLocationsController(LocationService locationService) {
        this.locationService = locationService;
    }

    @ApiOperation(value = "Returns the list of ATM Locations")
    @ApiResponses({@ApiResponse(code = 200, message = "Retrieve ATM Locations"),
            @ApiResponse(code = 404, message = "server not responding"),
            @ApiResponse(code = 500, message = "internal server error")})
    @GetMapping(path = "/v1/locations")
    @ResponseStatus(OK)
    public List<Locations> findLocation() {
        LOGGER.info("[START] call location controller ");
        return locationService.findLocation();
    }
}
