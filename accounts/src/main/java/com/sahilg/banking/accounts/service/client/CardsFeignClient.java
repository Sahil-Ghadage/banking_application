package com.sahilg.banking.accounts.service.client;

import com.sahilg.banking.accounts.dto.CardsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cards")
public interface CardsFeignClient {

    @GetMapping(value = "/api/fetch",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CardsDTO> fetchCardDetails(    @RequestHeader("bankApp-correlation-id") String correlationId ,
                                                         @RequestParam String mobileNumber);
}
