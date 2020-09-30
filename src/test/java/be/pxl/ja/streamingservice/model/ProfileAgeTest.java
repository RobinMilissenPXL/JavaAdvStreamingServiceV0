package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProfileAgeTest {

    @Test
    void ShouldBeAllowedToWatchMatureContentWhenOver16() {
        //ARRANGE
        Profile profile = new Profile("test");

        //ACT
        profile.setDateOfBirth(LocalDate.of(1979,12,11));
        Content matureContent = new TVShow("test content",Rating.MATURE, 2);

        // ASSERT
        assertTrue(profile.allowedToWatch(matureContent));
    }

    @Test
    void ItShouldGetCorrectAgeWhenSettingBirthdate() {
        // ARRANGE
        Profile profile = new Profile("Test profile");

        // ACT
        profile.setDateOfBirth(LocalDate.of(1979,12,11));

        // ASSERT
        assertTrue(profile.getAge() == 40);
    }
}