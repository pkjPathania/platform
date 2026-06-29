package com.pankaj.platform.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class GenUtil {

  private static final ObjectMapper OM = new ObjectMapper();

  private GenUtil() {}

  public static String toString(Object o) {
    try {
      return OM.writeValueAsString(o);
    } catch (JsonProcessingException e) {
      throw new IllegalStateException(e);
    }
  }
}
