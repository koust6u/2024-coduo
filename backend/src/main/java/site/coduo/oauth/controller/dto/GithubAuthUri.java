package site.coduo.oauth.controller.dto;

import java.net.URI;

import org.springframework.web.util.UriComponentsBuilder;

public record GithubAuthUri(GithubAuthQuery query) {
    private static final String GITHUB_AUTH_END_POINT = "https://www.github.com/login/oauth/authorize";

    public URI toUri() {
        return UriComponentsBuilder.fromHttpUrl(GITHUB_AUTH_END_POINT)
                .queryParams(query.toQueryParams())
                .build()
                .toUri();
    }
}
