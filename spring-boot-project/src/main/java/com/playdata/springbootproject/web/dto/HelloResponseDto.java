package com.playdata.springbootproject.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
                        // 롬북의 기능
@Getter                  // 선언되 모든 필드의 get메서드 생성
@RequiredArgsConstructor // final 혹은 nonnull로 선언된 필드를 인자를 가지는 생성자.
public class HelloResponseDto{

    private final String name  ;
    private final int amount;

}
