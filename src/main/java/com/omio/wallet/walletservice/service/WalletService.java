package com.omio.wallet.walletservice.service;


import com.omio.wallet.walletservice.model.Wallet;
import com.omio.wallet.walletservice.model.WalletResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class WalletService {
    private Map<String, Wallet> walletMap = new HashMap<>();

    public Map<String,String> getAmount(String userProfileId) {
        Map<String,String> response = new HashMap<>();
        if (!walletMap.containsKey(userProfileId)) {
            response.put("error","Are you sure this person keep wallet !!");
            return response;
        }
        response.put("amount",String.valueOf(walletMap.get(userProfileId).getAmount()));
        return response;
    }

    public Map<String,String> updateAmountToWallet(String userProfileId, int amount) {
        if (!walletMap.containsKey(userProfileId) && amount < 0) {
            Map<String,String> response = new HashMap<>();
            response.put("error","UserProfile does not exist !!");
            return response;
        }
        if(walletMap.containsKey(userProfileId) && walletMap.get(userProfileId).getAmount() + amount < 0) {
            Map<String,String> response = new HashMap<>();
            response.put("error","Sorry your wallet doesnt have enough balance !!");
            return response;
        }
        walletMap.putIfAbsent(userProfileId, Wallet.builder().userId(userProfileId).build());
        int value = walletMap.get(userProfileId) == null ? 0: walletMap.get(userProfileId).getAmount();
        walletMap.get(userProfileId).setAmount(value + amount);
        HashMap<String,String> response = new HashMap<>();
        response.put("amount",String.valueOf(walletMap.get(userProfileId).getAmount()));
        return response;
    }

}
