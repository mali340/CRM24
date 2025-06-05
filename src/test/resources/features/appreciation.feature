
Feature: User should be able to write an appreciation


Scenario: User writes an successfully appreciation
Given User is on the log in page
Then User clicks the "More" tab and selects "Appreciation"
And  User enters an appreciation message
And  User clicks the "Send" button
Then The appreciation should be posted in the stream
