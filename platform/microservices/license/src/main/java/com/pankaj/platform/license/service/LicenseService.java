package com.pankaj.platform.license.service;

import com.pankaj.platform.license.model.License;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {

  public License getLicense(String licenseId, String organizationId) {
    return License.builder()
        .id(new Random().nextInt(1000))
        .licenseId(licenseId)
        .organizationId(organizationId)
        .description("Software product")
        .productName("Ostock")
        .licenseType("full")
        .build();
  }

  public String createLicense(License license, String organizationId) {
    String responseMessage = null;
    if (license != null) {
      license =
          License.builder()
              .id(license.getId())
              .licenseId(license.getLicenseId())
              .description(license.getDescription())
              .organizationId(organizationId)
              .productName(license.getProductName())
              .licenseType(license.getLicenseType())
              .build();
      responseMessage = String.format("This is the post and the object is: %s", license);
    }
    return responseMessage;
  }

  public String updateLicense(License license, String organizationId) {
    String responseMessage = null;
    if (license != null) {
      license =
          License.builder()
              .id(license.getId())
              .licenseId(license.getLicenseId())
              .description(license.getDescription())
              .organizationId(organizationId)
              .productName(license.getProductName())
              .licenseType(license.getLicenseType())
              .build();
      responseMessage = String.format("This is the put and the object is: %s", license);
    }
    return responseMessage;
  }

  public String deleteLicense(String licenseId, String organizationId) {
    return String.format(
        "Deleting license with id %s for the organization %s", licenseId, organizationId);
  }
}
