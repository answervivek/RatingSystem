package com.trilectus.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Hotel {

    private String id;
    private String name;
    private String location;
    private String about;
}
