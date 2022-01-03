package com.disney.apidisney.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;


public class DisneyExceptions {


  @Data
  @EqualsAndHashCode(callSuper = true)
  public class DisneyException extends RuntimeException {

    private DisneyErrorMessage disneyErrorMessage;

    public DisneyException(
        DisneyErrorMessage disneyErrorMessage) {

      super(disneyErrorMessage.getInternalErrorMessage());
      this.disneyErrorMessage = disneyErrorMessage;

    }
  }
}
