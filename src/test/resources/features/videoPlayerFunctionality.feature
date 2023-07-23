#Author: Pranali H Vaidya
Feature: Video player functionality

  #Background:
  #Given user navigate to home page
  
  
  @Scenario3
  Scenario: Verify the video player functionality.
    Given user navigate to application and accept cookies
      | Mail Online Videos |
    When user clicks on Video in page to begin playback
    And user clicks the video again to pause playback
    And user clicks on the forward arrow to change to the next video
    And user clicks on the back arrow to navigate to the previous video
    And user on the speaker icon to mute the video
    And user on the speaker icon again to unmute the video
    Then user checks video is finished and next video should autoplay

  @Scenario4
  Scenario Outline: Get the Position and Points for the given team from the Premier League table.
    Given user navigate to application and accept cookies
      | Daily Mail Online |
    And user clicks on on Sport menu and scroll down to the Premier League table
    And user clicks on on the View all tables
    Then user retrieves the Pos and PTS for the given team <team>

    Examples: 
      | team           |
      | "Bournemouth"  |
      | "Brighton"     |
      | "Liverpool"    |
      | "Wolves"       |
      | "Nottm Forest" |
