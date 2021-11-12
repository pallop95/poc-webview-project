package com.ktb.app.pms.commonlibrary.model.base;

public interface ResponseConst {

  public static enum Response {
    CD2000("Success"),
    CD2001("Data not found"),
    CD5000("Error"),
    CD5101("Query Data Exception"),
    CD4003("Permission Denied")
    ;
    private final String value;

    private Response(String value) {
      this.value = value;
    }
    public String getValue() {
      return this.value;
    }
  };

}
