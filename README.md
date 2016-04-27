# weatherapp

Brief instructions:

* Press the + button to add a new place
* Enter the name or part name in the popup and hit search
* Tap on the place name to add it to your favourites
* On the main page, long press on a place name to bring up the delete menu
* Tap on the place name to retrieve the 5 day wind forecast for that location

Design notes

* Produced using Test driven MVP pattern
* Network traffic handled by IntentService - long queries will show a map icon in the notification bar.
* Thought about using autocomplete on the search box, but given the amount of data returned by the API and time constraints, kept it simple
