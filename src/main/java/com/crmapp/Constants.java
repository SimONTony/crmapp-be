package com.crmapp;

import org.springframework.stereotype.Component;

@Component
public class Constants {


    public static final int API_VERSION = 1;
    public static final String API_PATH = "api/v" + API_VERSION;
    public static final String DEFAULT_SCHEMA = "crmapp";

    public static class TableName {
        public static final String PERSONS = "persons";
        public static final String USERS = "users";
        public static final String EMPLOYEES = "employees";
        public static final String ADDRESSES = "addresses";
    }

    public static class MessageConstants {
        public static final String BEAN_VALIDATION_FAIL = "bean.validation.fail";
    }

    public enum MailConstants {
        MESSAGE_SOURCE_BASE_NAME("classpath:messages/messages"),
        MAIL_USERNAME("spring.mail.username"),
        MAIL_NO_SUBJECT("No subject"),
        CONFIRMATION_EMAIL_SENT("auth.service.send.confirmation.email");

        private String value;

        MailConstants(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
