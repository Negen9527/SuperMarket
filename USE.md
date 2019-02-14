[TOC]
### 数据库设计
### 数据库名：db_supermarket
#### 1.商品表（t_product）

序号 | 字段名 | 类型 | 长度 | isNull| 备注
---|---|---|---|---|---
1 | id | long | 11 | NO | 自增id
2 | productName | varchar | 32  | NO | 商品名称
3 | productBarCode | varchar | 32  | NO | 商品条码
4 | productPrice | double | 4  | NO | 商品单价
5 | productCount | int | 5  | NO | 商品数量

#### 2.销售表(t_sold)
序号 | 字段名 | 类型 | 长度 | isNull| 备注
---|---|---|---|---|---
1 | id | long | 11 | NO | 自增id
2 | soldTime | timestamp |   | NO | 售出时间
3 | soldProductBars | list |   | NO | 售出商品条码数组
4 | soldProductCount | list |   | NO | 售出商品对应数量数组
5 | soldTotalMoney | double | 5  | NO | 售出总价


#### 3.卷烟表(t_cigar)
序号 | 字段名 | 类型 | 长度 | isNull| 备注
---|---|---|---|---|---
1 | id | long | 11 | NO | 自增id
2 | cigarName | varchar | 32  | NO | 卷烟名称
3 | cigarBarCode | varchar | 32  | NO | 卷烟条码
4 | singleCigarPrice | double | 5  | NO | 单包价格
5 | cigarPrice | double | 5  | NO | 单条价格


