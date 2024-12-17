package com.vignesh.basics.restjson;

public record User(
        long id,
        String name,
        String email,
        String phone
) {
}
