package dev.reuise.web.frontend.config;
public class ReuiseWebFrontendConfig {
    private static ReuiseWebFrontendConfig INSTANCE = new ReuiseWebFrontendConfig();

    public ReuiseWebFrontendConfig() {
    }

    public static ReuiseWebFrontendConfig getInstance() {
        return ReuiseWebFrontendConfig.INSTANCE;
    }
}
