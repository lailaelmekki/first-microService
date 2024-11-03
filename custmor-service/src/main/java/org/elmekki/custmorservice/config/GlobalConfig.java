package org.elmekki.custmorservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "global.params")
public  record GlobalConfig(int p1, int p2) {
}
/*@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GlobalConfig{
    private int p1;
    private int p2;
}*/
