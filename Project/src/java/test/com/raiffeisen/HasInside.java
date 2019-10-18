package com.raiffeisen;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.core.SubstringMatcher;

public class HasInside extends SubstringMatcher {

    protected HasInside(String substring) {
        super(substring);
    }

    @Override
    protected boolean evalSubstringOf(String string) {
        return string.contains(substring);
    }

    @Override
    protected String relationship() {
        return null;
    }

    @Factory
    public static Matcher<String> hasCowInside(){
        return new HasInside("COW");
    }
}
