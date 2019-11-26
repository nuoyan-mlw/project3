package com.crazycode.pojo;

import lombok.Data;

@Data
public class Syslog {

  private String id;
  private java.sql.Timestamp visitTime;
  private String username;
  private String ip;
  private String url;
  private long executionTime;
  private String method;
}
