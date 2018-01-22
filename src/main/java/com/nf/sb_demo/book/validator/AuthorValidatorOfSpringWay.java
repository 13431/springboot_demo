package com.nf.sb_demo.book.validator;

import com.nf.sb_demo.book.entity.Author;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class AuthorValidatorOfSpringWay implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Author.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Author author = (Author) target;

        if(author.getName() == null || author.getName().length() < 5) {
            errors.rejectValue("name", null, "名字不能为空，并且要保持 5 位以上。");
        }

        if(!Pattern.matches("1[345678][0-9]{9}", author.getTelephone())) {
            errors.rejectValue("telephone", null, "电话号的格式化或或或或不争取。");
        }
    }
}
