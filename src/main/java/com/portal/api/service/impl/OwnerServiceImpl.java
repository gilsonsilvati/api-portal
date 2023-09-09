package com.portal.api.service.impl;

import com.portal.api.client.CarStoreClient;
import com.portal.api.dto.OwnerDTO;
import com.portal.api.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    protected CarStoreClient carStoreClient;

    @Override
    public void createdOwnerCar(OwnerDTO ownerDTO) {

        carStoreClient.ownerClient(ownerDTO);
    }
}
