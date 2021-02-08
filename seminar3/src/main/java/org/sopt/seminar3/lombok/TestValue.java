package org.sopt.seminar3.lombok;

import lombok.AccessLevel;
import lombok.Value;
import lombok.With;
import lombok.experimental.NonFinal;

@Value
public class TestValue {
    @With(AccessLevel.PROTECTED)
    private int userIdx;
    @NonFinal
    private String name;
    private String email;
}
