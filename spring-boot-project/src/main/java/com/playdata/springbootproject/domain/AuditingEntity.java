package com.playdata.springbootproject.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
// 생성, 수정
@Getter
@MappedSuperclass                               // 상속받는 엔티티클래스에서 상속받은 필드와 메소드를 사용할 수 있도록 해줍니다.
@EntityListeners(AuditingEntityListener.class)          // 생성일시와 수정일시를 자동으로 업데이트하는 기능을 제공
public abstract class AuditingEntity {
    @CreatedDate
    private LocalDateTime createdDate;          //생성일자


    @LastModifiedDate
    private LocalDateTime modifiedDate;         //수정일자


}
