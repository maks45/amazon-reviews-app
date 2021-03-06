package com.maks.durov.amazonreviewapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.maks.durov.amazonreviewapp.dto.ReviewDto;
import com.maks.durov.amazonreviewapp.service.impl.ReviewDtoParserServiceImpl;
import org.junit.jupiter.api.Test;

class ReviewDtoParserServiceTest {
    private final ReviewDtoParserServiceImpl reviewDtoParserServiceImpl =
            new ReviewDtoParserServiceImpl();

    @Test
    void parseDto_ok() {
        String csvLine = "1, productId, userId, profileName, 1, 1, 10, 1594136030, summary, text";
        ReviewDto expected = new ReviewDto(1L, "productId",
                "userId", "profileName", 1, 1,
                10, 1594136030L,"summary", "text");
        ReviewDto actual = reviewDtoParserServiceImpl.parseDto(csvLine);
        assertEquals(expected, actual);
    }

    @Test
    void parseCommaDto_ok() {
        String csvLine = "1, productId, userId, profileName, 1, 1, 10, 1594136030,"
                + " \"s,u,m,m,a,r,y\", \"t,e,x,t\"";
        ReviewDto expected = new ReviewDto(1L, "productId",
                "userId", "profileName", 1, 1,
                10, 1594136030L,"s,u,m,m,a,r,y", "t,e,x,t");
        ReviewDto actual = reviewDtoParserServiceImpl.parseDto(csvLine);
        assertEquals(expected, actual);
    }
}
