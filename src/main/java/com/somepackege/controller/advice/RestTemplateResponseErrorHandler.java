package com.somepackege.controller.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Slf4j
// @Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
        return (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR || httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse) throws IOException {
//		try {
//			String body = new String(IOUtils.toByteArray(httpResponse.getBody()));
//			log.error("Response code is %s and response body %s", httpResponse.getStatusCode(), body);
//		} catch (Throwable e) {
        log.error("Response code is %s and response %s", httpResponse.getStatusCode(), httpResponse);
//		}
    }
}
