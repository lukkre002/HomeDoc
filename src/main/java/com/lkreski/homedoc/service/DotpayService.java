package com.lkreski.homedoc.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service("dotpayService")
public class DotpayService {

    public enum OPERATIONSTATUS {
        NEW, PROCESSING, COMPETED, REJECTED
    }
    public String generateChk(HashMap<String,String> values){
        String result = "";
        StringBuilder stringBuilder = new StringBuilder(result);
        stringBuilder.append(values.getOrDefault("PIN",""));
        stringBuilder.append(values.getOrDefault("api_version",""));
        stringBuilder.append(values.getOrDefault("charset",""));
        stringBuilder.append(values.getOrDefault("lang",""));
        stringBuilder.append(values.getOrDefault("id",""));
        stringBuilder.append(values.getOrDefault("pid",""));
        stringBuilder.append(values.getOrDefault("amount",""));
        stringBuilder.append(values.getOrDefault("currency",""));
        stringBuilder.append(values.getOrDefault("description",""));
        stringBuilder.append(values.getOrDefault("control",""));
        stringBuilder.append(values.getOrDefault("channel",""));
        stringBuilder.append(values.getOrDefault("credit_card_brand",""));
        stringBuilder.append(values.getOrDefault("ch_lock",""));
        stringBuilder.append(values.getOrDefault("channel_groups",""));
        stringBuilder.append(values.getOrDefault("onlinetransfer",""));
        stringBuilder.append(values.getOrDefault("url",""));
        stringBuilder.append(values.getOrDefault("type",""));
        stringBuilder.append(values.getOrDefault("buttontext",""));
        stringBuilder.append(values.getOrDefault("urlc",""));
        stringBuilder.append(values.getOrDefault("firstname",""));
        stringBuilder.append(values.getOrDefault("lastname",""));
        stringBuilder.append(values.getOrDefault("email",""));
        stringBuilder.append(values.getOrDefault("street",""));
        stringBuilder.append(values.getOrDefault("street_n1",""));
        stringBuilder.append(values.getOrDefault("street_n2",""));
        stringBuilder.append(values.getOrDefault("state",""));
        stringBuilder.append(values.getOrDefault("addr3",""));
        stringBuilder.append(values.getOrDefault("city",""));
        stringBuilder.append(values.getOrDefault("postcode",""));
        stringBuilder.append(values.getOrDefault("phone",""));
        stringBuilder.append(values.getOrDefault("country",""));
        stringBuilder.append(values.getOrDefault("code",""));
        stringBuilder.append(values.getOrDefault("p_info",""));
        stringBuilder.append(values.getOrDefault("p_email",""));
        stringBuilder.append(values.getOrDefault("n_email",""));
        stringBuilder.append(values.getOrDefault("deladdr",""));
        stringBuilder.append(values.getOrDefault("recipient_account_number",""));
        stringBuilder.append(values.getOrDefault("recipient_company",""));
        stringBuilder.append(values.getOrDefault("recipient_first_name",""));
        stringBuilder.append(values.getOrDefault("recipient_last_name",""));
        stringBuilder.append(values.getOrDefault("recipient_address_street",""));
        stringBuilder.append(values.getOrDefault("recipient_address_building",""));
        stringBuilder.append(values.getOrDefault("recipient_address_apartment",""));
        stringBuilder.append(values.getOrDefault("recipient_address_postcode",""));
        stringBuilder.append(values.getOrDefault("recipient_address_city",""));
        stringBuilder.append(values.getOrDefault("application",""));
        stringBuilder.append(values.getOrDefault("application_version",""));
        stringBuilder.append(values.getOrDefault("warranty",""));
        stringBuilder.append(values.getOrDefault("bylaw",""));
        stringBuilder.append(values.getOrDefault("personal_data",""));
        stringBuilder.append(values.getOrDefault("credit_card_number",""));
        stringBuilder.append(values.getOrDefault("credit_card_expiration_date_year",""));
        stringBuilder.append(values.getOrDefault("credit_card_expiration_date_month",""));
        stringBuilder.append(values.getOrDefault("credit_card_security_code",""));
        stringBuilder.append(values.getOrDefault("credit_card_store",""));
        stringBuilder.append(values.getOrDefault("credit_card_store_security_code",""));
        stringBuilder.append(values.getOrDefault("credit_card_customer_id",""));
        stringBuilder.append(values.getOrDefault("credit_card_id",""));
        stringBuilder.append(values.getOrDefault("blik_code",""));
        stringBuilder.append(values.getOrDefault("credit_card_registration",""));
        stringBuilder.append(values.getOrDefault("recurring_frequency",""));
        stringBuilder.append(values.getOrDefault("recurring_interval",""));
        stringBuilder.append(values.getOrDefault("recurring_start",""));
        stringBuilder.append(values.getOrDefault("recurring_count",""));
        stringBuilder.append(values.getOrDefault("surcharge_amount",""));
        stringBuilder.append(values.getOrDefault("ignore_last_payment_channel",""));
        stringBuilder.append(values.getOrDefault("vco_call_id",""));
        stringBuilder.append(values.getOrDefault("vco_update_order_info",""));
        stringBuilder.append(values.getOrDefault("vco_subtotal",""));
        stringBuilder.append(values.getOrDefault("vco_shipping_handling",""));
        stringBuilder.append(values.getOrDefault("vco_tax",""));
        stringBuilder.append(values.getOrDefault("vco_discount",""));
        stringBuilder.append(values.getOrDefault("vco_gift_wrap",""));
        stringBuilder.append(values.getOrDefault("vco_misc",""));
        stringBuilder.append(values.getOrDefault("vco_promo_code",""));
        stringBuilder.append(values.getOrDefault("credit_card_security_code_required",""));
        stringBuilder.append(values.getOrDefault("credit_card_operation_type",""));
        stringBuilder.append(values.getOrDefault("credit_card_avs",""));
        stringBuilder.append(values.getOrDefault("credit_card_threeds",""));
        stringBuilder.append(values.getOrDefault("id1",""));
        stringBuilder.append(values.getOrDefault("amount1",""));
        stringBuilder.append(values.getOrDefault("currency1",""));
        stringBuilder.append(values.getOrDefault("description1",""));
        stringBuilder.append(values.getOrDefault("control1",""));
        result =stringBuilder.toString();
        return result;
    }



}
