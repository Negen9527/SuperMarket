package com.negen.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_cigar")
public class Cigar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cigarName;                 //卷烟名称
    private String cigarBarCode;              //卷烟条码
    private double singleCigarPrice;          //单包价格
    private double cigarPrice;                //单条价格
}
