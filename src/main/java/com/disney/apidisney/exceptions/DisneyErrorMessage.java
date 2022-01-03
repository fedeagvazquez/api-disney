package com.disney.apidisney.exceptions;

import com.disney.apidisney.entities.dtos.responses.DisneyErrorMessageResponse;
import com.disney.apidisney.entities.enums.DisneyErrorEnum;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data

public class DisneyErrorMessage {

    public HttpStatus httpStatus;
    private DisneyErrorEnum disneyErrorEnum;
    private String internalErrorMessage;

    public DisneyErrorMessage(
        HttpStatus httpStatus,
        DisneyErrorEnum conirradErrorEnum,
        String internalErrorMessage) {

      this.httpStatus = httpStatus;
      this.disneyErrorEnum = conirradErrorEnum;
      this.internalErrorMessage = internalErrorMessage;

    }

    public DisneyErrorMessageResponse response() {
      return new DisneyErrorMessageResponse(this);
    }

  }


