package com.portal.api.client;

import com.portal.api.dto.CarDTO;
import com.portal.api.dto.OwnerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Component
public class CarStoreClient {

    private static final String USER_STORE_SERVICE_URI = "http://localhost:8080/user";
    private static final String POSTS_STORE_SERVICE_URI = "http://localhost:8080/sales";

    @Autowired
    private RestTemplate restTemplate;

    public List<CarDTO> carForSaleClient() {
        var response = restTemplate.getForEntity(POSTS_STORE_SERVICE_URI + "/cars", CarDTO[].class);

        return Arrays.asList(requireNonNull(response.getBody()));
    }

    public void ownerClient(OwnerDTO newUser) {

        restTemplate.postForEntity(USER_STORE_SERVICE_URI, newUser, OwnerDTO.class);
    }

    public void changeCarForSaleClient(CarDTO carDTO, String id) {

        restTemplate.put(POSTS_STORE_SERVICE_URI + "/car/" + id, carDTO, CarDTO.class);
    }

    public void deleteCarForSaleClient(String id) {

        restTemplate.delete(POSTS_STORE_SERVICE_URI + "/car/" + id);
    }
}
