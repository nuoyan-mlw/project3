package com.crazycode.pojo;

import lombok.Data;

@Data
public class Product {

  private String id;
  private String productNum;
  private String productName;
  private String cityName;
  private java.sql.Timestamp departureTime;
  private double productPrice;
  private String productDesc;
  private long productStatus;
}
