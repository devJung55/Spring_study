package com.example.ex00.dependency.qualifier;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Data
@Qualifier("desktop") @Primary
public class Desktop implements Computer {
    @Override
    public int getScreenWidth() {
        return 2180;
    }
}
