export interface Posting {
    postingID: number,
    username: string,
    date: string,
    title: string,
    text: string,
    votes: {
        up: number,
        down: number
    },
    voted: boolean
}
