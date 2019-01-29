package com.lkreski.homedoc.model;

import lombok.Data;

@Data
public class Dotpay
{
    Integer id;
    String operation_type;
    String operation_status;
    String operation_amount;
    String operation_currency;
    String operation_withdrawal_amount;
    String operation_commission_amount;
    Boolean is_completed;
    String operation_original_amount;
    String operation_original_currency;
    String operation_datetime;
    String operation_related_number;
    String control;


}
