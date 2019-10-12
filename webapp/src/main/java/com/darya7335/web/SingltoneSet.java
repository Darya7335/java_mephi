package com.darya7335.web;

import java.util.HashSet;
import java.util.Set;

public class SingltoneSet {

    private Set<String> setId;

    private SingltoneSet() {                           //конструктор
        setId = new HashSet<String>();
    }

    private static class SingltoneSetHolder {
        private final static SingltoneSet instance = new SingltoneSet();   //экземпляр
    }

    public static SingltoneSet getInstance () {
        return SingltoneSetHolder.instance;
    }

    public void addSessionId (String sessionId) {
        setId.add(sessionId);
    }

    public boolean containsSessionId (String sessionId) {
        return setId.contains(sessionId);
    }
}