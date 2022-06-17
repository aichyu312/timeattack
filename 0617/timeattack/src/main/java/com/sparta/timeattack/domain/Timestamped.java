package com.sparta.timeattack.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // 부모클래스를 상속받는 자식클래스에게 매핑 정보만 제공하고 싶을때 사용하는 어노테이션 (상속하게되면 컬럼으로 인식하게함)
@EntityListeners(AuditingEntityListener.class) //생성/수정 시간을 자동으로 반영하도록 하게함

public abstract class Timestamped {
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
