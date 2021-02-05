# WeatherApp
Weather app for ent app development class


#Weather Output JSON Schema
{
    "description": "WeatherApp api output json schema",
    "examples": [
        {
            "city": "Cincinnati",
            "weather": {
                "currentTemp": 30,
                "maxTemp": 40,
                "minTemp": 20,
                "windMPH": 10,
                "humidityPercent": 50,
                "dewPointTemp": 23,
                "pressure": 20,
                "uvIndex": 0,
                "visibilityMiles": 10,
                "sunriseTime": "7:30",
                "sunsetTime": "6:30",
                "morningTemp": 25,
                "afternoonTemp": 31,
                "nightTemp": 20,
                "nextSixHoursTemps": [
                    32,
                    33,
                    34,
                    35,
                    36,
                    36
                ]
            },
            "country": "United States",
            "state": "Ohio",
            "zipcode": 45220
        }
    ],
    "required": [
        "city",
        "weather",
        "country",
        "state",
        "zipcode"
    ],
    "title": "Weather output schema",
    "type": "object",
    "properties": {
        "city": {
            "$id": "#/properties/city",
            "type": "string",
            "title": "The city schema",
            "description": "The city to check the weather of.",
            "default": "",
            "examples": [
                "Cincinnati"
            ]
        },
        "weather": {
            "$id": "#/properties/weather",
            "type": "object",
            "title": "The weather schema",
            "description": "All details about the weather of a location",
            "default": {},
            "examples": [
                {
                    "currentTemp": 30,
                    "maxTemp": 40,
                    "minTemp": 20,
                    "windMPH": 10,
                    "humidityPercent": 50,
                    "dewPointTemp": 23,
                    "pressure": 20,
                    "uvIndex": 0,
                    "visibilityMiles": 10,
                    "sunriseTime": "7:30",
                    "sunsetTime": "6:30",
                    "morningTemp": 25,
                    "afternoonTemp": 31,
                    "nightTemp": 20,
                    "nextSixHoursTemps": [
                        32,
                        33,
                        34,
                        35,
                        36,
                        36
                    ]
                }
            ],
            "required": [
                "currentTemp",
                "maxTemp",
                "minTemp",
                "windMPH",
                "humidityPercent",
                "dewPointTemp",
                "pressure",
                "uvIndex",
                "visibilityMiles",
                "sunriseTime",
                "sunsetTime",
                "morningTemp",
                "afternoonTemp",
                "nightTemp",
                "nextSixHoursTemps"
            ],
            "properties": {
                "currentTemp": {
                    "$id": "#/properties/weather/properties/currentTemp",
                    "type": "integer",
                    "title": "The currentTemp schema",
                    "description": "Current temperature",
                    "default": 0,
                    "examples": [
                        30
                    ]
                },
                "maxTemp": {
                    "$id": "#/properties/weather/properties/maxTemp",
                    "type": "integer",
                    "title": "The maxTemp schema",
                    "description": "max temperature for the day",
                    "default": 0,
                    "examples": [
                        40
                    ]
                },
                "minTemp": {
                    "$id": "#/properties/weather/properties/minTemp",
                    "type": "integer",
                    "title": "The minTemp schema",
                    "description": "Min temperature for the day",
                    "default": 0,
                    "examples": [
                        20
                    ]
                },
                "windMPH": {
                    "$id": "#/properties/weather/properties/windMPH",
                    "type": "integer",
                    "title": "The windMPH schema",
                    "description": "Wind in miles per hour",
                    "default": 0,
                    "examples": [
                        10
                    ]
                },
                "humidityPercent": {
                    "$id": "#/properties/weather/properties/humidityPercent",
                    "type": "integer",
                    "title": "The humidityPercent schema",
                    "description": "humidity in percentage",
                    "default": 0,
                    "examples": [
                        50
                    ]
                },
                "dewPointTemp": {
                    "$id": "#/properties/weather/properties/dewPointTemp",
                    "type": "integer",
                    "title": "The dewPointTemp schema",
                    "description": "The dew point",
                    "default": 0,
                    "examples": [
                        23
                    ]
                },
                "pressure": {
                    "$id": "#/properties/weather/properties/pressure",
                    "type": "integer",
                    "title": "The pressure schema",
                    "description": "Pressure of the air",
                    "default": 0,
                    "examples": [
                        20
                    ]
                },
                "uvIndex": {
                    "$id": "#/properties/weather/properties/uvIndex",
                    "type": "integer",
                    "title": "The uvIndex schema",
                    "description": "Uv index for the day(0-10)",
                    "default": 0,
                    "examples": [
                        0
                    ]
                },
                "visibilityMiles": {
                    "$id": "#/properties/weather/properties/visibilityMiles",
                    "type": "integer",
                    "title": "The visibilityMiles schema",
                    "description": "Visibility in miles",
                    "default": 0,
                    "examples": [
                        10
                    ]
                },
                "sunriseTime": {
                    "$id": "#/properties/weather/properties/sunriseTime",
                    "type": "string",
                    "title": "The sunriseTime schema",
                    "description": "time of sunset",
                    "default": "",
                    "examples": [
                        "7:30"
                    ]
                },
                "sunsetTime": {
                    "$id": "#/properties/weather/properties/sunsetTime",
                    "type": "string",
                    "title": "The sunsetTime schema",
                    "description": "time of sunset",
                    "default": "",
                    "examples": [
                        "6:30"
                    ]
                },
                "morningTemp": {
                    "$id": "#/properties/weather/properties/morningTemp",
                    "type": "integer",
                    "title": "The morningTemp schema",
                    "description": "temperature during morning time",
                    "default": 0,
                    "examples": [
                        25
                    ]
                },
                "afternoonTemp": {
                    "$id": "#/properties/weather/properties/afternoonTemp",
                    "type": "integer",
                    "title": "The afternoonTemp schema",
                    "description": "temperature during afternoon time",
                    "default": 0,
                    "examples": [
                        31
                    ]
                },
                "nightTemp": {
                    "$id": "#/properties/weather/properties/nightTemp",
                    "type": "integer",
                    "title": "The nightTemp schema",
                    "description": "temperature during night time",
                    "default": 0,
                    "examples": [
                        20
                    ]
                },
                "nextSixHoursTemps": {
                    "$id": "#/properties/weather/properties/nextSixHoursTemps",
                    "type": "array",
                    "title": "The nextSixHoursTemps schema",
                    "description": "Temperature of each hour in the next six hours",
                    "default": [],
                    "examples": [
                        [
                            32,
                            33
                        ]
                    ],
                    "additionalItems": true,
                    "items": {
                        "$id": "#/properties/weather/properties/nextSixHoursTemps/items",
                        "anyOf": [
                            {
                                "$id": "#/properties/weather/properties/nextSixHoursTemps/items/anyOf/0",
                                "type": "integer",
                                "title": "The first anyOf schema",
                                "description": "An explanation about the purpose of this instance.",
                                "default": 0,
                                "examples": [
                                    32,
                                    33
                                ]
                            }
                        ]
                    }
                }
            },
            "additionalProperties": true
        },
        "country": {
            "$id": "#/properties/country",
            "type": "string",
            "title": "The country schema",
            "description": "Country of the location.",
            "default": "",
            "examples": [
                "United States"
            ]
        },
        "state": {
            "$id": "#/properties/state",
            "type": "string",
            "title": "The state schema",
            "description": "State of the city if applicable",
            "default": "",
            "examples": [
                "Ohio"
            ]
        },
        "zipcode": {
            "$id": "#/properties/zipcode",
            "type": "integer",
            "title": "The zipcode schema",
            "description": "Zipcode of the city if applicable",
            "default": 0,
            "examples": [
                45220
            ]
        }
    },
    "additionalProperties": true
}


