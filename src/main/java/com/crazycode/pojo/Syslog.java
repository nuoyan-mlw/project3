package com.crazycode.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Syslog {

  private String id;
  private Date visitTime;
  private String username;
  private String ip;
  private String url;
  private Long executionTime;
  private String method;

  private Long StartTime;
  private Long EndTime;
}
