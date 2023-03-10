package com.example.ex00.dependency.qualifier;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Data
@Qualifier(value = "laptop")
public class Laptop implements Computer {
    @Override
    public int getScreenWidth() {
        return 1920;
    }
}
