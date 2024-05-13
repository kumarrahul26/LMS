package com.example.minor.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TxnSettlementResponse {

    private String txnId;

    private Integer settlementAmount;
}
