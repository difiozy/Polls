package com.shurov.polls.model.entity;

public enum Type {
    TEXT(1), ONE(2), SEVERAL(3);
    int a;
    Type(int i) {
        a=i;
    }
}
