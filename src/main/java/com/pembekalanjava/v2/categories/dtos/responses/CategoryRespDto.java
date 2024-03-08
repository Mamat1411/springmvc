package com.pembekalanjava.v2.categories.dtos.responses;

import lombok.Data;

@Data
public class CategoryRespDto {
    private Long id;
    private String initial;
    private String name;
    private String description;
}
