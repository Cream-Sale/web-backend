package com.creamsale.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.URI;
import java.util.Objects;

public class ProblemDetail {

    private URI type;
    private String title;
    private int status;
    private String detail;

    private ProblemDetail(){
    }

    public URI getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public static Builder builder(Throwable throwable) {
        return new ProblemDetail().new Builder(throwable);
    }

    public class Builder {

        private final Throwable throwable;

        private Builder(Throwable throwable) {
            this.throwable = throwable;
        }

        ProblemDetail build() {
            ProblemDetail.this.type = buildType();
            ProblemDetail.this.title = buildTitle();
            ProblemDetail.this.status = buildStatus();
            ProblemDetail.this.detail = buildDetailMessage();
            return ProblemDetail.this;
        }

        private URI buildType() {
            //ToDo create valid uri
            String uri = String.format("https://api.creamsale.com/apidocs/%s.html", throwable.getClass().getSimpleName());
            return URI.create(uri);
        }

        private String buildTitle() {
            return camelToWords(throwable.getClass().getSimpleName());
        }

        private String camelToWords(String input) {
            return String.join(" ", input.split("(?=\\p{javaUpperCase})"));
        }

        private String buildDetailMessage() {
            return throwable.getMessage();
        }

        private int buildStatus() {
            ResponseStatus status = throwable.getClass().getAnnotation(ResponseStatus.class);
            if (Objects.nonNull(status)) {
                return status.value().value();
            } else {
                return HttpStatus.INTERNAL_SERVER_ERROR.value();
            }
        }
    }
}
