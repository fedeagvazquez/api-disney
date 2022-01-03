package com.disney.apidisney.entities.enums;

public enum DisneyErrorEnum {

    PERSONAJE_NOT_FOUND("personaje_not_found");


  private final String displayMessage;

     DisneyErrorEnum(String displayMessage) {
      this.displayMessage = displayMessage;
    }

    public String getDisplayMessage() {
      return this.displayMessage;
    }
  }

