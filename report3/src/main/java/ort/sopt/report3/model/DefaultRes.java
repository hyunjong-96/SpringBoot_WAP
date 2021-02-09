package ort.sopt.report3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefaultRes<T> {
    private int statusCode;
    private String responseMessage;
    private T responseData;

    public DefaultRes(final HttpStatus statusCode, final String responseMessage){
        this.statusCode = statusCode.value();
        this.responseMessage = responseMessage;
        this.responseData = null;
    }

    public static<T> DefaultRes<T> res(final int statusCode,final String responseMessage){
        log.info("데이터없는 defaultRes");
        return res(statusCode,responseMessage,null);
    }

    public static<T> DefaultRes<T> res(final int statusCode,final String responseMessage,final T data){
        log.info("베베베베베");
        return DefaultRes.<T>builder()
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .responseData(data)
                .build();
    }
}
