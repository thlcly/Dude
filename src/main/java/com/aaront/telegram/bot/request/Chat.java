package com.aaront.telegram.bot.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Optional;

/**
 * @author tonyhui
 * @since 2017/8/11
 */
@Data
public class Chat {
    Integer id;
    String type;
    Optional<String> title;
    Optional<String> username;
    @JsonProperty("first_name")
    Optional<String> firstName;
    @JsonProperty("last_name")
    Optional<String> lastName;
    @JsonProperty("all_members_are_administrators")
    Optional<Boolean> allMembersAreAdministrators;
    Optional<String> description;
    @JsonProperty("invite_link")
    Optional<String> inviteLink;
    // TODO: 2017/8/11 photo后续支持
}
