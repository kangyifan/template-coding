package com.evan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.swing.text.html.Option;
import java.io.Serializable;
import java.util.Currency;
import java.util.Optional;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/2/2022 10:33 AM
 */
@Data
@AllArgsConstructor
@ToString
public class Transaction implements Serializable {

    private String name;

    private String currency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getCurrency() {
        return Optional.ofNullable(currency);
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
