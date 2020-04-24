# Url

# Json Structure

## Posting List
`
[
    {
        "postingID": 0,
        "userID": 0,
        "date": "2020-04-24T17:18:27.600Z",
        "title": "string",
        "text": "string",
        "votes": { "up": 123, "down": 4545 },
        "voted": false
  }
]
`

## Post
`{
    "userID": 0,
    "date": "2020-04-24T17:18:27.600Z",
    "title": "string",
    "text": "string",
    "image": "string"
}`

## Vote
`
{
    "postingID": 0,
    "userID": 0,
    "upVote": true,
    "downVote": false
}
`

## User Registration
`
{
    "username": "string"
}
`
