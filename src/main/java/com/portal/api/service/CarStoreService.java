package com.portal.api.service;

import com.portal.api.dto.CarDTO;

import java.util.List;

public interface CarStoreService {

    List<CarDTO> getCarForSales();

    void changeCarForSale(CarDTO carDTO, String id);

    void removeCarForSale(String id);
}
