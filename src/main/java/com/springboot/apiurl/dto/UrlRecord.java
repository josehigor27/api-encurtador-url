package com.springboot.apiurl.dto;

import jakarta.validation.constraints.NotBlank;

public record UrlRecord(@NotBlank String originalUrl,@NotBlank String userId) {
}
