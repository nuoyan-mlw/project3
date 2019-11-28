package com.crazycode.pojo;

import lombok.Data;

@Data
public class Orders {

  private String id;
  private String orderNum;
  private java.sql.Timestamp orderTime;
  private long peopleCount;
  private String orderDesc;
  private long payType;
  private long orderStatus;
  private String productId;
  private String memberId;

  private Product product;
}
