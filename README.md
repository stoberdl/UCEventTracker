# UC Event Tracker App
Tracker app for University of Cincinnati events.

## Introduction
Have you ever wanted to know what events are going on at campus? Then try the premier tracker app for UC! You can view all future events, favorite them, or even add you're own.
## Storyboard
![Storyboard](https://user-images.githubusercontent.com/41589695/107148721-c7fd4180-6922-11eb-97f3-c0e9dff9703a.png)

## Requirements

## Class Diagram
![Class Diagram](https://user-images.githubusercontent.com/41589695/107131519-40252200-68a5-11eb-943a-285d60345bde.png)

### Class Diagram Description 
**MainActivity:** The first screen the user sees. This will have a list of all the ongoing and previous events on campus, and an option to get more info and rsvp a particular event.  

**RetrofitInstance:** Boostrap class required for Retrofit.  

**Event:** Noun class that represents an Event.  

**IEventDAO:** Interface for Retrofit to find and parse Event data JSON.  

**Host:** Noun class that represents a event Host which might be a preofessor or a student organisation.  

**IHostDAO:** Interface for Retrofit to find and parse Host data JSON.  


## Event Output JSON Schema
```
{
    "title": "event output schema",
    "description": "Events json schema for API output",
    "default": {},
    "examples": [
        {
            "name": "Friday Fitness",
            "location": "TUC",
            "host": "David Stober",
            "description": "Checkout the fitness session this friday",
            "startDate": "Fri, 05 Feb 2021 22:00:00 GMT",
            "endDate": "Fri, 05 Feb 2021 23:00:00 GMT",
            "categories": [
                "Virtual Event",
                "Community Engagement"
            ]
        }
    ],
    "required": [
        "name",
        "location",
        "host",
        "description",
        "startDate",
        "endDate",
        "categories"
    ],
    "properties": {
        "name": {
            "$id": "#/properties/name",
            "type": "string",
            "title": "The name schema",
            "description": "Name of event.",
            "default": "",
            "examples": [
                "Friday Fitness"
            ]
        },
        "location": {
            "$id": "#/properties/location",
            "type": "string",
            "title": "The location schema",
            "description": "Location the event is hosted.",
            "default": "",
            "examples": [
                "TUC"
            ]
        },
        "host": {
            "$id": "#/properties/host",
            "type": "string",
            "title": "The host schema",
            "description": "The host or author of the event.",
            "default": "",
            "examples": [
                "David Stober"
            ]
        },
        "description": {
            "$id": "#/properties/description",
            "type": "string",
            "title": "The description schema",
            "description": "Event description",
            "default": "",
            "examples": [
                "Checkout the fitness session this friday"
            ]
        },
        "startDate": {
            "$id": "#/properties/startDate",
            "type": "string",
            "title": "The startDate schema",
            "description": "Start date and time of event.",
            "default": "",
            "examples": [
                "Fri, 05 Feb 2021 22:00:00 GMT"
            ]
        },
        "endDate": {
            "$id": "#/properties/endDate",
            "type": "string",
            "title": "The endDate schema",
            "description": "End date and time of event.",
            "default": "",
            "examples": [
                "Fri, 05 Feb 2021 23:00:00 GMT"
            ]
        },
        "categories": {
            "$id": "#/properties/categories",
            "type": "array",
            "title": "The categories schema",
            "description": "Categories of the event.",
            "default": [],
            "examples": [
                [
                    "Virtual Event",
                    "Community Engagement"
                ]
            ],
            "additionalItems": true,
            "items": {
                "$id": "#/properties/categories/items",
                "anyOf": [
                    {
                        "$id": "#/properties/categories/items/anyOf/0",
                        "type": "string",
                        "title": "The first anyOf schema",
                        "description": "Any number of categories can fill this list.",
                        "default": "",
                        "examples": [
                            "Virtual Event",
                            "Community Engagement"
                        ]
                    }
                ]
            }
        }
    },
    "additionalProperties": true
}
```
## Team Members and Roles

UI Specialist: Hayden Worrix  
Business Logic/Persistence: Atharva Chalke  
DevOps/Product Owner/Scrum Master/GitHub Admin: David Stober  

## Group Standup
*Our weekly meetings will be held on Wednesdays at 10:00 AM on a Discord/Skype server we have set up for the group project. Other meetings will be scheduled as necessary.*
