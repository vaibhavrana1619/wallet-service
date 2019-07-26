package com.omio.wallet.walletservice.controller;

import com.omio.wallet.walletservice.model.WalletRequest;
import com.omio.wallet.walletservice.model.WalletResponse;
import com.omio.wallet.walletservice.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class WalletController {

    @Autowired
    WalletService walletService;

    @GetMapping("/wallet/{profileId}")
    ResponseEntity<Map<String,String>> getWalletBalance(@PathVariable String profileId) {
        return new ResponseEntity(walletService.getAmount(profileId), HttpStatus.OK);
    }

    @PutMapping("/wallet/{profileId}")
    ResponseEntity<Map<String,String>> addWalletBalance(@PathVariable String profileId, @RequestBody WalletRequest request) {
        return new ResponseEntity<>(walletService.updateAmountToWallet(profileId, request.getAmount()), HttpStatus.OK);
    }

}
