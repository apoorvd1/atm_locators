package com.indorse.atm.locations.service;

import com.indorse.atm.locations.model.Locations;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LocationService {

    List<Locations> findLocation();
}
