# Url

# Json Structure
url: /labels
## Label List
```json
[
  {
    "label": "asdf",
    "link": {
      "method": "GET",
      "url": "/label/asdf"
    }
  }
]
```

## Posting List
```json
[
    {
        "user": { "displayName":  "steve.jobs" },
        "date": "2020-04-24T17:18:27.600Z",
        "title": "string",
        "text": "string",
        "votings": { 
            "up": 123, 
            "down": 4545,
            "voted": "up",
            "links": [
              { "action": "voteUp", "method": "PUT", "url": "/posting/postingId/voteUp" },
              { "action": "voteUp", "method": "PUT", "url": "/posting/postingId/voteDown" }
            ]}  
    }
]
```

## Post
```json
{
    "user": { "displayName":  "steve.jobs" },
    "date": "2020-04-24T17:18:27.600Z",
    "title": "string",
    "text": "string",
    "image": "string"
}
```

## Vote
```json
{
    "postingID": 0,
    "userID": 0,
    "upVote": true,
    "downVote": false
}
```

## User Registration
```json
{
    "username": "string"
}
```
