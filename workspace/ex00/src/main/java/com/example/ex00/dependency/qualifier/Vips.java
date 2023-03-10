package com.example.ex00.dependency.qualifier;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Data
@Qualifier("vips")
public class Vips implements Restaurant {
    private int steak = Restaurant.steak - 90000;

    @Override
    public boolean isSalad() {
        return true;
    }
}
