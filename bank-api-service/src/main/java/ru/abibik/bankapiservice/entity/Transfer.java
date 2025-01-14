package ru.abibik.bankapiservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {
    private String amount;
    private String to;
    private String note;
}
