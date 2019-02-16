package com.negen.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_sold")
public class Sold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp soldTime;                //售出时间
    private String soldProductBars;            //售出商品条码数组
    private String soldProductPrice;            //售出商品价格数组
    private String soldProductCount;              //售出商品对应数量数组
    private String soldProductName;              //售出商品对应名称数组
    private double soldTotalMoney;             //售出总价
}
