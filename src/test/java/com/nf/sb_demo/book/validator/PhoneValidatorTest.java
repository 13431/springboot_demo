package com.nf.sb_demo.book.validator;

import org.junit.Test;

public class PhoneValidatorTest {
    @Test
    public void isValid() throws Exception {
        PhoneValidator phoneValidator = new PhoneValidator();
        assert phoneValidator.isValid("13566667777", null);
    }

}