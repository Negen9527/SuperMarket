[TOC]
### 一、数据库设计
#### 1.商品表（product）

序号 | 字段名 | 类型 | 长度 | isNull| 备注
---|---|---|---|---|---
1 | id | long | 11 | NO | 自增id
2 | productName | varchar | 32  | NO | 商品名称
3 | productBarCode | varchar | 32  | NO | 商品条码
4 | productPrice | double | 4  | NO | 商品单价
5 | productCount | int | 5  | NO | 商品数量

#### 2.销售表(sold)
序号 | 字段名 | 类型 | 长度 | isNull| 备注
---|---|---|---|---|---
1 | id | long | 11 | NO | 自增id
2 | soldTime | timestamp |   | NO | 售出时间
3 | soldProductBars | list |   | NO | 售出商品条码数组
4 | soldProductCount | int | 5  | NO | 售出商品对应数量
5 | soldTotalMoney | double | 5  | NO | 售出总价



