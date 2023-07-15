package com.github.youssefwadie.messagehub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class HomeController {

    @RequestMapping("/user")
    public Mono<String> user(@AuthenticationPrincipal Mono<OAuth2User> principalMono) {
        return principalMono.mapNotNull(principal -> principal.getAttribute("name"));
    }
}
