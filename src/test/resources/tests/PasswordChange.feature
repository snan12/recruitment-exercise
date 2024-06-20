Feature: The user can change their own password
  Rule: As a user
  I want to be able to change my own password within the guidelines of password policy
  So that the integrity of my account security requirements are met.
  
  Background:
    Given I am logged in as "user1" with password "passabc@345"
    And I am on the password change page
  
 
    Scenario: Successfully change password
    Given I enter my Username
    And I enter my current password "passabc@345"
    Then I enter a new password "passabc@345"
    And I confirm the verify password "passadd@345"
    And I click the "Submit" button
    Then I should see a message "Your password has been changed successfully"
    
    Scenario: New password does not meet the minimum length
    When I enter my current password "passadd@345"
    And I enter a new password "ab3"
    And I confirm the verify password "ab3"
    And I click the "Submit" button
    Then I should see an error message "New password does not meet the minimum length of 3 characters"
    
    Scenario: New password does not contain a digit
    When I enter my current password "passadd@345"
    And I enter a new password "passadd"
    And I confirm the verify password "passad"
    And I click the "Submit" button
    Then I should see an error message "New password must contain at least one digit"
    
    Scenario: New Password and Verify password do not match
    When I enter my current password "passadd@345"
    And I enter a new password "passabe@678"
    And I confirm the verify password "passabe@67898"
    And I click the "Submit" button
    Then I should see an error message "Password and confirm password do not match"
    
    Scenario: Current password is incorrect
    When I enter my current password "oldpassadd@34543"
    And I enter a new password "Newpassd123"
    And I confirm the verify password "Newpassd123"
    And I click the "Submit" button
    Then I should see an error message "Current password is incorrect"
    
    Scenario: Missing data in a field
    When I enter my current password "passadd@345"
    And I leave the new password field empty
    And I confirm the verify password "NewPass123"
    And I click the "Submit" button
    Then I should see an error message "New password is required"
    
    Scenario: New password is the same as the current password
    When I enter my current password "passadd@345"
    And I enter a new password "passadd@345"
    And I confirm the verify password "passadd@345"
    And I click the "Submit" button
    Then I should see an error message "New password cannot be the same as the current password"