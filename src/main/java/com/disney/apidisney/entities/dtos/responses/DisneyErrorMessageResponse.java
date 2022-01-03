package com.disney.apidisney.entities.dtos.responses;

import com.disney.apidisney.exceptions.DisneyErrorMessage;
import lombok.Data;

@Data

public class DisneyErrorMessageResponse {

  private Integer httpStatusCode;
  private String httpStatusDescription;
  private String displayMessage;

  public DisneyErrorMessageResponse(
      DisneyErrorMessage disneyErrorMessage) {

    this.httpStatusCode = disneyErrorMessage.getHttpStatus().value();
    this.httpStatusDescription = disneyErrorMessage.getHttpStatus().getReasonPhrase();
    this.displayMessage = disneyErrorMessage.getDisneyErrorEnum().getDisplayMessage();

  }

}
