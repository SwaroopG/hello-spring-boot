Story: Securemedia Integration
As a operations guy
I want a ping API through portal 
So that I can check the status/health of the Securemedia server

Scenario: Securemedia server should be pingable
Given a securemedia server
When ping command is issued
Then the response from the server should give the details of the server
