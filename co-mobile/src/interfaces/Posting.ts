export interface Posting {
    date: string,
    "image": {
        action: string,
        method: string,
        url: string
    },
    postingID: string,
    text: string,
    title: string,
    userID: string,
    votings: {
        links: [
            {
                action: string,
                method: string,
                url: string
            }
        ],
        down: number,
        up: number,
        voted: string
    }
}
