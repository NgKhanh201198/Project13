package com.employeemanager.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationException {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
    public static final Pattern VALID_PHONE_REGEX = Pattern.compile("^(05[5|8|9]|08[1|2|3|4|5|8|6|9]|03[2|3|4|5|6|7|8|9]|07[0|9|7|6|8]|09[0|2|1|4|3|6|7|8|9]|01[2|9])+([0-9]{7})\\b$");
    public static final Pattern VALID_BIRTHDAY_REGEX = Pattern.compile("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$");
    public static final Pattern VALID_NAME_REGEX = Pattern.compile("^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]{1,50}$");
    public static final Pattern VALID_NUMBER_REGEX = Pattern.compile("^[0-9]$");

    public void checkNumber(String str) throws NumberException {
        Matcher matcher = VALID_NUMBER_REGEX.matcher(str);
        if (!matcher.matches()) {
            throw new NumberException("Invalid number");
        }
    }

    public void checkEmail(String email) throws EmailException {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if (matcher.matches()) {
            System.out.println(ANSI_GREEN + "Email accecpted" + ANSI_RESET);
        } else {
            throw new EmailException("Invalid email");
        }
    }

    public void checkPhone(String phone) throws PhoneException {
        Matcher matcher = VALID_PHONE_REGEX.matcher(phone);
        if (matcher.matches()) {
            System.out.println(ANSI_GREEN + "Phone number accecpted" + ANSI_RESET);
        } else {
            throw new PhoneException("Invalid phone number");
        }
    }

    public void checkBirthday(String birthday) throws BirthdayException {
        Matcher matcher = VALID_BIRTHDAY_REGEX.matcher(birthday);
        if (matcher.matches()) {
            System.out.println(ANSI_GREEN + "Birthday accecpted" + ANSI_RESET);
        } else {
            throw new BirthdayException("Invalid birthday");
        }
    }

    public void checkName(String name) throws NameException {
        Matcher matcher = VALID_NAME_REGEX.matcher(name);
        if (matcher.matches()) {
            System.out.println(ANSI_GREEN + "Name accecpted" + ANSI_RESET);
        } else {
            throw new NameException("Invalid name");
        }
    }
}
