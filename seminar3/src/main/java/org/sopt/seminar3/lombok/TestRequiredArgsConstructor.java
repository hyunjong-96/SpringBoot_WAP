package org.sopt.seminar3.lombok;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestRequiredArgsConstructor {
    @NonNull
    private int userIdx;
    private String name;
    private final String email;
}
