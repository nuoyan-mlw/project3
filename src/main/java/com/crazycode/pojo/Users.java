package com.crazycode.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Users {

  private String id;
  private String email;
  private String username;
  private String password;
  private String phoneNum;
  private Long status;

}
