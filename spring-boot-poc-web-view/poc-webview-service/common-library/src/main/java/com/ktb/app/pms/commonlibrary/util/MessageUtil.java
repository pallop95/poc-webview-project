package com.ktb.app.pms.commonlibrary.util;

import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MessageUtil
{

  private static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

  private MessageUtil() {
    super();
  }

  public static String getMessage(String key) {
    String result = null;
    try {
      result = new String(resourceBundle.getString(key).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
}
