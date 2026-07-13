Feature: Checking loging test for Practice test Automation

Scenario:
Given User should open Chrome Browser
When User should Enter url in browser
Then Type username student into Username in Edit Field
Then Type password Password123 into Password in Text Field
Then User should click on Push Sumbit button
Then User should Verify new page URL contains https://practicetestautomation.com/logged-in-successfully/
Then User should Verify new page contains expected text ("Logged In Successfully" or "Congratulations student. You successfully logged in!" or "You are now logged in as a student.")
Then User should  on verify Log out button
Then User should Verify new page URL contains https://practicetestautomation.com/logged-in-successfully/
