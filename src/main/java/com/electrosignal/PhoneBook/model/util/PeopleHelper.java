package com.electrosignal.PhoneBook.model.util;

import com.electrosignal.PhoneBook.model.User;

public abstract class PeopleHelper {

    public static String getAuthorName(User author) {
        return author != null ? author.getUsername() : "<Unknown>";
    }

}
