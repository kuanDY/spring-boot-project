package com.playdata.springbootproject.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.*;


class HelloResponseDtoTest {
    @Test
    public void lombokTest(){
        //given
        String name = "남민우";
        int amount = 1000;

        //when
        //@RequiredArgsConstructor 가 정말 필요한 필드에 대해서 생성자를 생성하는지 확인
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); //isEqulaTo 주어진 값과 예상 값이 같은지 확인
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}