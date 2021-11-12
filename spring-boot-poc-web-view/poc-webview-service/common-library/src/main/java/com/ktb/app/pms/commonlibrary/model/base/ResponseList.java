package com.ktb.app.pms.commonlibrary.model.base;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ResponseList<T> extends ResponseBase implements Serializable
{
  @JsonIgnore
  private static final long serialVersionUID = 470266841345782890L;
  private List<T> responseList;
}