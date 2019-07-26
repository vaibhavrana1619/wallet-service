package com.omio.wallet.walletservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WalletResponse {
    String error;
    Wallet walletResponse;
}
