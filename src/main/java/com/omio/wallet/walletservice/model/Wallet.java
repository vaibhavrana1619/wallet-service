package com.omio.wallet.walletservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Wallet {
    @JsonIgnore
   private String userId;
   private int amount = 0;
}
