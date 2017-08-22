package com.example.demo.entity.constant;

import lombok.Getter;

/**
 * Created by whilemouse on 17. 8. 22.
 */
@Getter
public enum SocialProvider {
    FACEBOOK("facebook"), GOOGLE("google"), NONE("local");

    private String providerType;

    SocialProvider(final String providerType) {
        this.providerType = providerType;
    }
}
