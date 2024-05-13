package com.example.minor.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CreateTxnRequest {
   @NotBlank(message = "Student contact must not be blank")
    private String studentContact;
    @NotBlank(message = "BookNo must not be blank")
    private String bookNo;
    @NotNull
    private Integer paidAmount;

}
