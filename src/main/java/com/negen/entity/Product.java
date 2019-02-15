package com.negen.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;                //商品名
    private String productBarCode;             //商品条码
    private double productPrice;               //商品单价
    private int productCount;                  //商品数量

}
