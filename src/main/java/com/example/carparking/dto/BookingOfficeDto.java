package com.example.carparking.dto;

import com.example.carparking.model.Trip;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingOfficeDto {
    @NotNull(message = "can not be null")
    private Date endContractDeadline;
    @NotNull(message = "can not be null")
    private String officeName;
    @NotNull(message = "can not be null")
    private String officePhone;
    @NotNull(message = "can not be null")
    private String officePlace;
    @NotNull(message = "can not be null")
    private int officePrice;
    @NotNull(message = "can not be null")
    private Date startContractDeadline;
    @NotNull(message = "can not be null")
    private Long trip;
}
