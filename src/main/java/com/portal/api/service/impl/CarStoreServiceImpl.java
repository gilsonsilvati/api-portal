package com.portal.api.service.impl;

import com.portal.api.client.CarStoreClient;
import com.portal.api.dto.CarDTO;
import com.portal.api.service.CarStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarStoreServiceImpl implements CarStoreService {

    @Autowired
    private CarStoreClient carStoreClient;

    @Override
    public List<CarDTO> getCarForSales() {

        return carStoreClient.carForSaleClient();
    }

    @Override
    public void changeCarForSale(CarDTO carDTO, String id) {

        carStoreClient.changeCarForSaleClient(carDTO, id);
    }

    @Override
    public void removeCarForSale(String id) {

        carStoreClient.deleteCarForSaleClient(id);
    }
}
