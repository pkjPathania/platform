package com.pankaj.platform.license.model;

import com.pankaj.platform.utility.GenUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class License {
  private int id;
  private String licenseId;
  private String description;
  private String organizationId;
  private String productName;
  private String licenseType;

  @Override
  public String toString() {
    return GenUtil.toString(this);
  }
}
